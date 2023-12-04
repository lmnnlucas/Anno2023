
import Game.Buildings.CementPlant;
import Game.Buildings.House;
import Manager.*;
import UI.*;
import Game.*;
public class Main {
    public static void main(String[] args)
        {
            Manager manager = new Manager();
            GameLoop gameLoop = new GameLoop(manager);
            gameLoop.loop();
        }
    }
