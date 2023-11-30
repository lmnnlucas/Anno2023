package UI;

import Game.Buildings.*;
import Manager.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class UI
{
    private Manager manager;
    private int width = manager.getWidth();
    private int height = manager.getHeight();
    private WorldEntity[][] world;

    public UI() {}


    //public void UI(){}

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

    private static Building transfromWorldEntityToDecor(WorldEntity worldEntity)
    {
        switch(worldEntity)
        {
            case WOODEN_CABIN:
                return new WoodenCabin();
            case HOUSE:
                    return new House();
            case APARTMENTBUILDING:
                return new ApartementBuilding();
            case FARM:
                return new Farm();
            case QUARRY:
                return new Quarry();
            case LUMBERMILL:
                return new LumberMill();
            case CEMENTPLANT:
                return new CementPlant();
            case STEELMILL:
                return new SteelMill();
            case TOOLFACTORY:
                return new ToolFactory();
            default:
                return null;
        }
    }
    //fonction à appeler avant le print pour mettre à jour le monde
    public void buildWorld()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                world[x][y] = WorldEntity.NOTHING; // A mettre Manager.getWorld().getEntityAt(x, y);
            }
        }
    }


    public void printWorld()
    {
        buildWorld();
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                if(x != 0)
                {
                    System.out.print("_");
                }
                System.out.print(world[x][y]);
                if(x != width)
                {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }




    public void waitEntry()
    {
        while(true)
        {
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();
            if(value.equals("h"))
            {
                System.out.println("W : Wooden Cabin");
                System.out.println("H : House");
                System.out.println("A : Apartment Building");
                System.out.println("F : Farm");
                System.out.println("Q : Quarry");
                System.out.println("L : Lumber Mill");
                System.out.println("C : Cement Plant");
                System.out.println("S : Steel Mill");
                System.out.println("T : Tool Factory");
            }
            else
            {

            }
        }
    }

}
