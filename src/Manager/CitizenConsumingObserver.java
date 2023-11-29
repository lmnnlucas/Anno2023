package Manager;

import Game.People.Citizen;
import Game.Resource;

import java.util.ArrayList;
import java.util.HashMap;

public class CitizenConsumingObserver implements Observer {
    private Manager manager;

    CitizenConsumingObserver(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void update() {;
        manager.getCitizens().forEach(citizen -> {
            System.out.println("Citizen " + citizen.getId() + " is consuming food");
            if (manager.getNumberRessource(Resource.FOOD) == 0) {
                System.out.println("Citizen " + citizen.getId() + " is starving");
                manager.citizenDeath(citizen);
            } else {
                manager.setResource(Resource.FOOD, -1);
            }
        });

    }
}
