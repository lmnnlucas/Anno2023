package UI;

import Game.Buildings.*;
import Exceptions.WrongEntryException;
import Game.Position;
import Game.Resource;
import Manager.Manager;

import java.util.Scanner;

/**
 * This class is only used to display the game in the console
 */
public class UI
{
    private Manager manager;
    private WorldEntity[][] world;

    public UI(Manager manager)
    {
        this.manager = manager;
        int width = manager.getWidth();
        int height = manager.getHeight();
        world = new WorldEntity[width][height];
        //System.out.println(world.length);
    }

    /*
    * This method is used to transform a building to a WorldEntity
    * @param building the building to transform
    * @return the WorldEntity corresponding to the building
    */
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


    /*
        * This method is used to transform a WorldEntity to a building
        * @param worldEntity the WorldEntity to transform
        * @return the building corresponding to the WorldEntity
     */
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

    /*
        * This method is used to transform a char to a WorldEntity
        * @param c the char to transform
        * @return the WorldEntity corresponding to the char
        * Used with associated method transformWorldEntityToBuilding
     */
    private static WorldEntity transformCharToEntity(char c)
    {
        switch(c)
        {
            case 'W':
                return WorldEntity.WOODEN_CABIN;
            case 'H':
                return WorldEntity.HOUSE;
            case 'A':
                return WorldEntity.APARTMENTBUILDING;
            case 'F':
                return WorldEntity.FARM;
            case 'Q':
                return WorldEntity.QUARRY;
            case 'L':
                return WorldEntity.LUMBERMILL;
            case 'C':
                return WorldEntity.CEMENTPLANT;
            case 'S':
                return WorldEntity.STEELMILL;
            case 'T':
                return WorldEntity.TOOLFACTORY;
            default:
                return WorldEntity.NOTHING;
        }
    }

    /*
        * This method is used to fill the WorldEntity tab
        * The WorldEntity tab is used to display the game in the console
     */

    public void buildWorld()
    {
        for(int x = 0; x < manager.getWidth(); x++)
        {
            for(int y = 0; y < manager.getHeight(); y++)
            {
                Position position = new Position(x, y);
                world[x][y] = transfromBuildingToWorldEntity(manager.getBuildings().get(position));
            }
        }
    }

    /*
        * This method is used to display the game in the console
        * A game is in the form :
        * H x x
        * x W x
        * x x x
        * A game 3x3 with a house at the position 0 0 and a wooden cabin at the position 1 1
     */
    public void printWorld()
    {
        buildWorld();

        for(int y = 0; y < manager.getHeight(); y++)
        {
            for(int x = 0; x < manager.getWidth(); x++)
            {
                System.out.print(world[x][y].getCode());
                if(x != manager.getWidth() - 1)
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    /*
        * This method is used to display the resources in the console
     */
    public void printResource()
    {
        System.out.println("Round : " + manager.getRound());
        System.out.println(" -- RESOURCES -- ");
        System.out.print("Golds : " + manager.getNumberRessource(Resource.GOLD));
        System.out.print(" | Food : " + manager.getNumberRessource(Resource.FOOD));
        System.out.print(" | Citizens : " + manager.getCitizens().size());
        System.out.print(" | | Wood : " + manager.getNumberRessource(Resource.WOOD));
        System.out.print(" | Stone : " + manager.getNumberRessource(Resource.STONE));
        System.out.print(" | Coal : " + manager.getNumberRessource(Resource.COAL));
        System.out.print(" | Iron : " + manager.getNumberRessource(Resource.IRON));
        System.out.print(" | Steel : " + manager.getNumberRessource(Resource.STEEL));
        System.out.print(" | Cement : " + manager.getNumberRessource(Resource.CEMENT));
        System.out.print(" | Lumber : " + manager.getNumberRessource(Resource.LUMBER));
        System.out.print(" | Tools : " + manager.getNumberRessource(Resource.TOOLS));
    }


    /*
        This method is used to get the entry of the user
     */
    public void waitEntry(){
        while(true) {
            try {
                System.out.println();
                System.out.println("You can type h to get help");
                Scanner sc = new Scanner(System.in);
                String value = sc.nextLine();
                if (value.equals("h")) {
                    System.out.println(" -- WELCOME TO THE HELP -- ");
                    System.out.println("For all manipulation you need to enter the position of the building");
                    System.out.println("Exemple : W 1 2 -> Add a wooden cabin at the position 1 2");
                    System.out.println("+ : Add a workers to a building (We will ask for the number of workers)");
                    System.out.println("- : Remove a workers to a building (We will ask for the number of workers)");
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
                    System.out.println("R : Remove a building (We will ask for the position of the building)");
                    System.out.println("E : Exit");
                    System.out.println("h : Help");
                    continue;
                }
                if (value.equals("E")) {
                    System.out.println(" -- GOODBYE -- ");
                    break;
                } else {
                    try {
                        char c = value.charAt(0);
                        int x = Integer.parseInt(value.substring(2, 3));
                        int y = Integer.parseInt(value.substring(4, 5));
                        Position position = new Position(x, y);
                        if (c == 'W' || c == 'H' || c == 'A' || c == 'F' || c == 'Q' || c == 'L' || c == 'C' || c == 'S' || c == 'T') {
                            Building building = transfromWorldEntityToBuilding(transformCharToEntity(c));
                            manager.setBuilding(position, building);
                            System.out.println("Building added");
                            break;
                        } else if (c == '+') {
                            System.out.println("How many workers do you want to add ?");
                            int number = sc.nextInt();
                            Building building = manager.getBuildings().get(position);
                            manager.AddWorkerToABuilding(building , number);
                            System.out.println("Worker added");
                            break;
                        } else if (c == '-') {
                            System.out.println("How many workers do you want to remove ?");
                            int number = sc.nextInt();
                            Building building = manager.getBuildings().get(position);
                            manager.removeWorkerFromBuilding(building , number);
                            System.out.println("Worker removed");
                            break;
                        } else if (c == 'I') {
                            Building building = manager.getBuildings().get(position);
                            if (building == null) {
                                throw new WrongEntryException("No building at this position");
                            }
                            System.out.println("Building : " + building.getName());
                            System.out.println("Citizens : " + building.getNumberofCitizens());
                            System.out.println("Workers : " + building.getNumberofWorkers());
                            System.out.println("Production : " + building.getResourcesGenerating());
                            System.out.println("Consumption : " + building.getResourcesConsumption());
                            break;
                        } else if (c == 'R') {
                            manager.getBuildings().remove(position);
                            System.out.println("Building removed");
                            break;
                        } else {
                            throw new WrongEntryException("Entry not recognized");
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        throw new WrongEntryException("Missing arguments");
                    }
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}

