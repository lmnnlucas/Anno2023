package Manager;

/**
 * Class that contains the game loop
 */
public class GameLoop {
    Manager manager;

    /**
     * Constructor for GameLoop
     * @param manager Manager of the game
     */
    public GameLoop(Manager manager) {
        this.manager = manager;
    }

    /**
     * Loop that runs the game
     */
    public void loop(){
        while (!manager.isFinished()){
            manager.printWorld();
            manager.printResource();
            manager.waitEntry();
            manager.notifyObserver();
            manager.updateWaitingTimeBuilding();
        }
    }
}
