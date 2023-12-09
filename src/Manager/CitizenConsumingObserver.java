package Manager;

import Game.People.Citizen;
import Game.Resource;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Observer that is notified each round to check if there's enough food for the citizens and update the manager's resources
 */
public class CitizenConsumingObserver implements Observer {
    private Manager manager;

    /**
     * Constructor for CitizenConsumingObserver
     * @param manager Manager of the game
     */
    CitizenConsumingObserver(Manager manager) {
        this.manager = manager;
    }

    /**
     * Checks if there's enough food for the citizens and if there's not, it kills the citizen
     */
    @Override
    public void update() {
        manager.getCitizens().forEach(citizen -> {
            if (manager.getNumberRessource(Resource.FOOD) == 0) {
                System.out.println("Citizen " + citizen.getId() + " is starving and died.");
                manager.citizenDeath(citizen);
            } else {
                manager.setResource(Resource.FOOD, -1);
            }
        });

    }
}
