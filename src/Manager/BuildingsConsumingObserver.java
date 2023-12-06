package Manager;

import Game.Buildings.Building;
import Game.Resource;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Observer that is notified each round to check if the buildings are consuming and/or generating resources and update the manager's resources
 */
public class BuildingsConsumingObserver implements Observer {

    private Manager manager;

    /**
     * Constructor for BuildingsConsumingObserver
     * @param manager Manager of the game
     */
    public BuildingsConsumingObserver(Manager manager) {
        this.manager = manager;
    }

    /**
     * Checks if the buildings are consuming resources and if they are generating resources.
     * If they are consuming resources, it checks if the manager has enough resources to run the building.
     * If the building has no workers, it does not generate anything
     */
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
