package UI;

import Game.Buildings.*;
import Game.Position;
import Manager.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class UI
{
    private Manager manager;
    private int width = 10; //manager.getWidth();
    private int height = 10; //manager.getHeight();
    private WorldEntity[][] world;

    public UI(Manager manager)
    {
        this.manager = manager;
        world = new WorldEntity[width][height];
    }


    //public void UI(){}

    private static WorldEntity transfromBuildingToWorldEntity(Building building)
    {
        if(building == null)
        {
            return WorldEntity.NOTHING;
        }
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
        }
        return null;
    }

    private static Building transfromWorldEntityToBuilding(WorldEntity worldEntity)
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
                Position position = new Position(x, y);
                world[x][y] = transfromBuildingToWorldEntity(manager.getBuilding().get(position)); // A mettre Manager.getWorld().getEntityAt(x, y);
            }
        }
    }


    public void printWorld()
    {
        buildWorld();
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                System.out.print(world[x][y].getCode());
                if(x != width - 1)
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
            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();
            if(value.equals("h"))
            {
                System.out.println(" -- WELCOME TO THE HELP -- ");
                System.out.println("For all manipulation you need to enter the position of the building");
                System.out.println("Exemple : W 1 2 -> Add a wooden cabin at the position 1 2");
                System.out.println("+ : Add a workers to a building (We will ask for the position of the building)");
                System.out.println("- : Remove a workers to a building (We will ask for the position of the building)");
                System.out.println("I : To get information about a building (We will ask for the position of the building)");
                System.out.println("W : Wooden Cabin ");
                System.out.println("H : House");
                System.out.println("A : Apartment Building");
                System.out.println("F : Farm");
                System.out.println("Q : Quarry");
                System.out.println("L : Lumber Mill");
                System.out.println("C : Cement Plant");
                System.out.println("S : Steel Mill");
                System.out.println("T : Tool Factory");
                System.out.println("E : Exit");
                System.out.println("h : Help");
            }
            if (value.equals("E"))
            {
                System.out.println(" -- GOODBYE -- ");
                break;
            }
            else
            {
                if(value.length() > 3)
                {
                    char c = value.charAt(0);
                    int x = Integer.parseInt(value.substring(1,2));
                    int y = Integer.parseInt(value.substring(2,3));
                    Position position = new Position(x, y);
                }
                else
                {
                    System.out.println("Wrong entry");
                }
            }
        }
    }

}
