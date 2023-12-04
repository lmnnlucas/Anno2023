package Manager;

public class GameLoop {
    Manager manager;
    public GameLoop(Manager manager) {
        this.manager = manager;
        while (true){
            loop();
        }
    }
    private void loop(){
        
        while (true){
            manager.printWorld();
            //printressources
            manager.waitEntry();
            manager.notifyObserver();

        }
    }
}
