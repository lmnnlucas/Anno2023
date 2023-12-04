package Manager;

import Game.Buildings.Building;
import Game.Resource;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildingsConsumingObserver implements Observer {

    private Manager manager;
    private ArrayList<Building> buildings;
    public BuildingsConsumingObserver(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void update() {
        for (Building building : manager.getBuildings().values()) {
            for (Resource resource : building.getResourcesConsumption().keySet()) {
                if (manager.getNumberRessource(resource) < building.getResourcesConsumption().get(resource)) {
                    System.out.println("Not enough " + resource + " to run " + building.getName() + ". It will not produce anything.");
                    manager.setResource(resource, -manager.getNumberRessource(resource));
                }
                else {
                    manager.setResource(resource, -building.getResourcesConsumption().get(resource));
                    manager.setResource(resource, building.getResourcesGenerating().get(resource));
                }
            }
        }
    }
}
