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
            if (building.getResourcesConsumption() != null) {

                for (Resource resource : building.getResourcesConsumption().keySet()) {

                    if (manager.getNumberRessource(resource) < building.getResourcesConsumption().get(resource)) {
                        System.out.println("Not enough " + resource + " to run " + building.getName() + ". It will not produce anything.");
                        manager.setResource(resource, -manager.getNumberRessource(resource));
                    } else {
                        manager.setResource(resource, -building.getResourcesConsumption().get(resource) * building.getNumberofWorkers() / building.getWorkersCapacity());
                    }
                }
            }
            if (building.getResourcesGenerating() != null && building.getWorkersCapacity() != 0) {
                for (Resource resource : building.getResourcesGenerating().keySet()) {
                    manager.setResource(resource, building.getResourcesGenerating().get(resource) * building.getNumberofWorkers() / building.getWorkersCapacity());
                    System.out.println(building.getName() + " is producing " + building.getResourcesGenerating().get(resource) * building.getNumberofWorkers() / building.getWorkersCapacity() + " " + resource);
                }
            } else if (building.getWorkersCapacity() == 0) {
                System.out.println(building.getName() + " is not producing anything because it has no workers.");
            }
        }
    }
}
