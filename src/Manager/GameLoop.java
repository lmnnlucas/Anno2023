package Manager;

public class GameLoop {
    Manager manager;
    public GameLoop(Manager manager) {
        this.manager = manager;
    }
    public void loop(){
        while (!manager.isFinished()){
            manager.printWorld();
            manager.printResource();
            manager.waitEntry();
            manager.notifyObserver();
        }
    }
}
