package Manager;

import Game.Buildings.Building;
import Game.Resource;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildingsConsumingObserver implements Observer {

    private Manager manager;
    private ArrayList<Building> buildings;
    private HashMap<Resource, Integer> resources;

    public BuildingsConsumingObserver(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void update() {
        // HashMap<Resource, Integer> actualResources = manager.getResources();
        for (Building building : buildings) {
            for (Resource resource : building.getResourcesConsumption().keySet()) {
                if (resources.get(resource) < building.getResourcesConsumption().get(resource)) {
                    System.out.println("Not enough " + resource + " to run " + building.getName());
                }
            }
        }
    }
}
