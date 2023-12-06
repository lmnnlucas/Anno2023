package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import Game.Position;
import Game.Resource;
import Game.Buildings.Building;
import Game.Buildings.House;
import Game.People.Citizen;
import UI.UI;

public class Manager{
    private final int width;
    private final int height;
    private int round = 0;
    private UI ui = new UI(this);
    private ArrayList<Observer> observers = new ArrayList<>();
    private HashMap<Resource,Integer> resources = new HashMap<>(){{ //Config initial
        put(Resource.GOLD, 10);
        put(Resource.FOOD, 100);
        put(Resource.WOOD, 100);
        put(Resource.STONE, 100);
        put(Resource.COAL, 0);
        put(Resource.IRON, 0);
        put(Resource.STEEL, 0);
        put(Resource.CEMENT, 0);
        put(Resource.LUMBER, 0);
        put(Resource.TOOLS, 0);
    }};
    private HashMap<Position,Building> building = new HashMap<>();
    private ArrayList<Citizen> citizens = new ArrayList<>();

    public Manager(int width,int height){
        this.width = width;
        this.height = height;
        building.put(new Position(0,0),new House());
        citizens.add(new Citizen(building.get((new Position(0,0)))));
        initializeObserver();

    }

    public Manager(){
        this.width = 10;
        this.height = 10;
        building.put(new Position(0,0),new House());
        citizens.add(new Citizen(building.get((new Position(0,0)))));
        initializeObserver();

    }
    public void initializeObserver(){
        observers.add(new BuildingsConsumingObserver(this));
        observers.add(new CitizenConsumingObserver(this));
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public int getRound(){
        return round;
    }

    public void setResource(Resource r, int i){
        resources.put(r, resources.get(r)+i);
    }
    public void citizenDeath(Citizen c){
        c.getHome().removeCitizen(c);
        c.getWorkplace().removeWorker(c);
        citizens.remove(c);
    }
    public int getNumberRessource(Resource r){
        return resources.get(r);
    }
    public HashMap<Resource,Integer> getResources(){
        return resources;
    }
    public List<Citizen> getCitizens(){
        return citizens;
    }
    public HashMap<Position,Building> getBuildings(){
        return building;
    }
    public void setBuilding(Position pos,Building b){
        building.put(pos,b);
        resources.put(Resource.GOLD, resources.get(Resource.GOLD)-b.getResourcesNeeded().get(Resource.GOLD));
        resources.put(Resource.WOOD, resources.get(Resource.WOOD)-b.getResourcesNeeded().get(Resource.WOOD));
        resources.put(Resource.STONE, resources.get(Resource.STONE)-b.getResourcesNeeded().get(Resource.STONE));
        addRound();

        /* Pas Obligatoire pour la  version de base
        resources.put(Resource.IRON, resources.get(Resource.IRON)-b.getResourcesNeeded().get(Resource.IRON));
        resources.put(Resource.COAL, resources.get(Resource.COAL)-b.getResourcesNeeded().get(Resource.COAL));
        resources.put(Resource.CEMENT, resources.get(Resource.CEMENT)-b.getResourcesNeeded().get(Resource.CEMENT));
        resources.put(Resource.LUMBER, resources.get(Resource.LUMBER)-b.getResourcesNeeded().get(Resource.LUMBER));
        resources.put(Resource.TOOLS, resources.get(Resource.TOOLS)-b.getResourcesNeeded().get(Resource.TOOLS));
        */
    }
    public void removeBuilding(Position pos){
        building.remove(pos);
        resources.put(Resource.GOLD,resources.get(Resource.GOLD) + building.get(pos).getResourcesNeeded().get(Resource.GOLD)/2);
        resources.put(Resource.WOOD,resources.get(Resource.WOOD) + building.get(pos).getResourcesNeeded().get(Resource.WOOD)/2);
        resources.put(Resource.STONE,resources.get(Resource.STONE) + building.get(pos).getResourcesNeeded().get(Resource.STONE)/2);
        addRound();
        
        /* Pas Obligatoire pour la  version de base
        resources.put(Resource.IRON,resources.get(Resource.IRON) + building.get(pos).getResourcesNeeded().get(Resource.IRON)/2);
        resources.put(Resource.COAL,resources.get(Resource.COAL) + building.get(pos).getResourcesNeeded().get(Resource.COAL)/2);
        resources.put(Resource.CEMENT,resources.get(Resource.CEMENT) + building.get(pos).getResourcesNeeded().get(Resource.CEMENT)/2);
        resources.put(Resource.LUMBER,resources.get(Resource.LUMBER) + building.get(pos).getResourcesNeeded().get(Resource.LUMBER)/2);
        resources.put(Resource.TOOLS,resources.get(Resource.TOOLS) + building.get(pos).getResourcesNeeded().get(Resource.TOOLS)/2);
         */
    }
    public void addRound(){
        round++;
    }
    public void addObserver(Observer o){ // I guess ca va etre utile 
        observers.add(o);
    }
    public void removeObserver(Observer o){// I guess la meme
        observers.remove(o);
    }

    public void notifyObserver(){
        for(Observer o : observers){
            o.update();
        }
    }
    public void printWorld(){
        ui.printWorld();
    }
    public void waitEntry(){
        ui.waitEntry();
    }

    public void printResource(){
        ui.printResource();
    }

    public void AddWorkerToABuilding(Building b,int number){
        int cpt = 0;
        for (int i = 0; i< citizens.size();i++){
            if (citizens.get(i).getWorkplace() == null){
                b.addWorker(citizens.get(i));
                cpt ++;
                if (cpt == number){
                break;
                }
            }
        }
        if (cpt < number){
            System.out.println("ratio");
        }
        addRound();
    }

    public void removeWorkerFromBuilding(Building b,int number){
        int cpt = 0;
        for (int i = 0; i< citizens.size();i++){
            if (citizens.get(i).getWorkplace() == b){
                b.removeWorker(citizens.get(i));
                cpt ++;
                if (cpt == number){
                    break;
                }
            }
        }
        if (cpt < number){
            System.out.println("ratio");
        }
        addRound();
    }

    public void addCitizenToABuilding(Building b,int number){
        int cpt = 0;
        for (int i = 0; i< citizens.size();i++){
            if (citizens.get(i).getHome() == null){
                b.addCitizen(citizens.get(i));
                cpt++;
                if (cpt == number){
                    break;
                }
            }
        }
        if (cpt < number){
            System.out.println("ratio");
        }
        addRound();
    }

    public void removeCitizenFromBuilding(Building b,int number){
        int cpt = 0;
        for (int i = 0; i< citizens.size();i++){
            if (citizens.get(i).getHome() == b){
                b.removeCitizen(citizens.get(i));
                cpt++;
                if (cpt == number){
                    break;
                }
            }
        }
        if (cpt < number){
            System.out.println("ratio");
        }
        addRound();
    }

    public int getNumberHomeless(){
        int cpt = 0;
        for (int i = 0; i < citizens.size();i++){
            if (citizens.get(i).getHome() == null){
                cpt ++;
            }
        }
        return cpt;
    }
    public int getNumberWorkless(){
        int cpt = 0;
        for (int i =0; i < citizens.size();i++){
            if (citizens.get(i).getWorkplace() == null){
                cpt ++;
            }
        }
        return cpt;
    }

    public boolean isFinished(){
        if (citizens.size() == 0){
            return true;
        }
        if (round == 100){
            return true;
        }
        return false;
    }
}