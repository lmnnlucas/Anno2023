package Manager;

import Game.People.Citizen;
import Game.Resource;

import java.util.ArrayList;
import java.util.HashMap;

public class CitizenConsumingObserver implements Observer {

    ArrayList<Citizen> citizens = new ArrayList<>();
    HashMap<Resource, Integer> ressources = new HashMap<>();
    private Manager manager;

    CitizenConsumingObserver(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void update() {
        // int food = manager.getRessource(Resource.FOOD);
        citizens.forEach(citizen -> {
            System.out.println("Citizen " + citizen.getId() + " is consuming food");
            if (ressources.get(Resource.FOOD) == 0) {
                System.out.println("Citizen " + citizen.getId() + " is starving");
                // manager.citizenDeath(citizen);
            } else {
                // manager.setRessource(Resource.FOOD, value-1);
            }
        });

    }
}
