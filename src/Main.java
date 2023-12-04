
import Manager.*;
import UI.*;
public class Main {
    public static void main(String[] args)
        {
            Manager manager = new Manager(10 , 10);
            UI ui = new UI(manager);
            ui.printWorld();
            ui.waitEntry();
        }
    }
