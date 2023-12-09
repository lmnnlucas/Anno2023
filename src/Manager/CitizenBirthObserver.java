package Manager;

import Exceptions.CitizenException;
import Game.Buildings.Building;
import Game.People.Citizen;
import Game.Position;

import java.util.HashMap;

/**
 * Observer that is notified each round to add a citizen to a home if there is one available
 */
public class CitizenBirthObserver implements Observer
{
    private Manager manager;

    /**
     * Constructor for CitizenBirthObserver
     * @param manager Manager of the game
     */
    public CitizenBirthObserver(Manager manager)
    {
        this.manager = manager;
    }

    /**
     * Checks if there is a home available and if there is, it adds a citizen to it
     */
    @Override
    public void update() {
        if (manager.getCitizens().isEmpty()){
            throw new CitizenException("No citizen in the game");
        }
        try {
            HashMap<Position, Building> buildingToCheck = manager.getBuildings();
            for (int y = 0; y < manager.getWidth(); y++) {
                for (int x = 0; x < manager.getHeight(); x++) {
                    Position position = new Position(x, y);
                    if (!buildingToCheck.containsKey(position)) {
                        continue;
                    }
                    if (buildingToCheck.get(position).isAHome()) {
                        if (buildingToCheck.get(position).getNumberofCitizens() == buildingToCheck.get(position).getCitizensCapacity()) // It's already full
                        {
                            continue;
                        } else {
                            Citizen c = new Citizen(buildingToCheck.get(position));
                            buildingToCheck.get(position).addCitizen(c);
                            manager.getCitizens().add(c);
                            return;
                        }
                    }
                }
            }
            throw new CitizenException("No home with free space , you need to build a new one to get more Citizen");
        } catch (CitizenException e) {
            System.out.println(e.getMessage());
        }
    }
}
