
import Game.Buildings.CementPlant;
import Game.Buildings.House;
import Manager.*;
import UI.*;
import Game.*;
public class Main {
    public static void main(String[] args)
        {
            Manager manager = new Manager(10 , 10);
            UI ui = new UI(manager);
            manager.setBuilding(new Position(1,1),new CementPlant());
            ui.printWorld();
            ui.printResource();
            ui.waitEntry();
            ui.printWorld();
        }
    }
