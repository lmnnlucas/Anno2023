package Game.UI;

import Game.Buildings.Building;

public class UI
{
    //private Manager manager;

    private int width;
    private int height;
    private WorldEntity[][] world;

    public UI() {}


    private static WorldEntity transfromDecorToWorldEntity(Building building)
    {
        switch(building.getName())
        {
            case "Wooden Cabin":
                return WorldEntity.WOODEN_CABIN;
            case "House":
                return WorldEntity.HOUSE;
            case "Apartment Building":
                return WorldEntity.APARTMENTBUILDING;
            case "Farm":
                return WorldEntity.FARM;
            case "Quarry":
                return WorldEntity.QUARRY;
            case "Lumber Mill":
                return WorldEntity.LUMBERMILL;
            case "Cement Plant":
                return WorldEntity.CEMENTPLANT;
            case "Steel Mill":
                return WorldEntity.STEELMILL;
            case "Tool Factory":
                return WorldEntity.TOOLFACTORY;
            default:
                return WorldEntity.NOTHING;
        }
    }
    //fonction à appeler avant le print pour mettre à jour le monde
    public void buildWorld()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
                world[x][y] = WorldEntity.NOTHING; // A mettre Manager.getWorld().getEntityAt(x, y);
        }
    }


    public void print()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                System.out.print(world[x][y]);

            }
            System.out.println();
        }
    }

}
