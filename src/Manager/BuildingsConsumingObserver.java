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
            if (building.getResourcesConsumption() == null){ 
                System.out.println(building.getName() + " doesn't consume anything.");
                continue;
            }
            for (Resource resource : building.getResourcesConsumption().keySet()) {
                if (manager.getNumberRessource(resource) < building.getResourcesConsumption().get(resource)) {
                    System.out.println("Not enough " + resource + " to run " + building.getName() + ". It will not produce anything.");
                    manager.setResource(resource, -manager.getNumberRessource(resource));
                }
                else {
                    if (building.getResourcesConsumption().get(resource) != null)
                        manager.setResource(resource, -building.getResourcesConsumption().get(resource)* building.getNumberofWorkers()/building.getWorkersCapacity());
                    if (building.getResourcesGenerating().get(resource) != null)
                        manager.setResource(resource, building.getResourcesGenerating().get(resource) *building.getNumberofWorkers()/building.getWorkersCapacity());
                }
            }
        }
    }
}
