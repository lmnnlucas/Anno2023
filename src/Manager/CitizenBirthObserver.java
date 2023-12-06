package Manager;

import Game.Buildings.Building;
import Game.People.Citizen;
import Game.Position;

import java.util.HashMap;

public class CitizenBirthObserver implements Observer
{
    private Manager manager;

    public CitizenBirthObserver(Manager manager)
    {
        this.manager = manager;
    }

    @Override
    public void update()
    {
        HashMap<Position, Building> buildingToCheck = manager.getBuildings();
        for(int y = 0 ; y < manager.getWidth() ; y++)
        {
            for(int x = 0 ; x < manager.getHeight() ; x++)
            {
                Position position = new Position(x ,y);
                if(buildingToCheck.get(position).isAHome())
                {
                    if(buildingToCheck.get(position).getNumberofCitizens() == buildingToCheck.get(position).getCitizensCapacity()) // It's already full
                    {
                        continue;
                    }
                    else
                    {
                        Citizen c = new Citizen(buildingToCheck.get(position));
                        buildingToCheck.get(position).addCitizen(c);
                        manager.getCitizens().add(c);
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("No home available , you need to build a new one");
    }
}
