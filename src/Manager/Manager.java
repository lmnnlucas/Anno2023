package Manager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Game.Resource;
import Game.Buildings.Building;
import Game.People.Citizen;

public class Manager {
    private final int width;
    private final int height;
    private int round = 0;
    private HashMap<Resource,Integer> resources = new HashMap<>(); 
    private ArrayList<Citizen> citizens = new ArrayList<>(); 
    private HashMap<Integer,Building> building = new HashMap<>(); //TODO Remplacer par position
    public Manager(int width,int height){
        this.width = width;
        this.height = height;
    }
    public Manager(){
        this.width = 10;
        this.height = 10;
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
}
