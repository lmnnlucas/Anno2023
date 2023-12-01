package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import Game.Position;
import Game.Resource;
import Game.Buildings.Building;
import Game.Buildings.House;
import Game.People.Citizen;

public class Manager implements Observer{
    private final int width;
    private final int height;
    private int round = 0;
    private ArrayList<Observer> observers = {new BuildingsConsumingObserver(this),new BuildingsGeneratingObserver(this)};
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
    }
  
    public Manager(){
        this.width = 10;
        this.height = 10;
        building.put(new Position(0,0),new House());
        citizens.add(new Citizen(building.get((new Position(0,0)))));
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
    public HashMap<Position,Building> getBuilding(){
        return building;
    }
    public void setBuild(Position pos,Building b){
        building.put(pos,b);
    }
    public void addRound(){
        round++;
    }
    public void update(){
        for(Observer o : observers){
            o.update();
        }
        
    }
}