package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import Exceptions.BuildingException;
import Game.Position;
import Game.Resource;
import Game.Buildings.Building;
import Game.Buildings.House;
import Game.People.Citizen;
import UI.UI;

/**
 * public class Manager
 * Controler class
 * Define structure of the data and the game
 * Update observers and comunicate with UI
 */
public class Manager{
    /**
     * width of the game
     */
    private final int width;
    /**
     * height of the game
     */
    private final int height;
    /**
     * round of the game
     */
    private int round = 0;
    /**
     * UI of the game
     */
    private UI ui;
    /**
     * List of observers
     */
    private ArrayList<Observer> observers = new ArrayList<>();
    /**
     * List of resources of the player
     */
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
    /**
     * List of buildings on the game
     */
    private HashMap<Position,Building> building = new HashMap<>();
    /**
     * List of citizens alive in the game
     */
    private ArrayList<Citizen> citizens = new ArrayList<>();

    /**
     * Constructor of the class
     * @param width width of the game
     * @param height height of the game
     */
    public Manager(int width,int height){
        this.width = width;
        this.height = height;
        building.put(new Position(0,0),new House());
        citizens.add(new Citizen(building.get((new Position(0,0)))));
        ui = new UI(this);
        initializeObserver();

    }
    /**
     * Constructor of the class
     * Default width and height
     */
    public Manager(){
        this.width = 10;
        this.height = 10;
        building.put(new Position(0,0),new House());
        citizens.add(new Citizen(building.get((new Position(0,0)))));
        ui = new UI(this);
        initializeObserver();

    }
    /**
     * Initialize the list of observers
     */
    private void initializeObserver(){
        observers.add(new BuildingsConsumingObserver(this));
        observers.add(new CitizenConsumingObserver(this));
    }
    /**
     * Getter of the width
     * @return width of the game
     */
    public int getWidth(){
        return width;
    }
    /**
     * Getter of the height
     * @return height of the game
     */
    public int getHeight(){
        return height;
    }
    /**
     * Getter of the round
     * @return round of the game
     */
    public int getRound(){
        return round;
    }
  
    /**
     * Getter of the number of a ressource
     * @param r ressource to get
     * @return
     */
    public int getNumberRessource(Resource r){
        return resources.get(r);
    }

    /**
     * Getter of the list of resources
     * @return list of resources
     */

    public HashMap<Resource,Integer> getResources(){
        return resources;
    }
    
    /**
     * Getter of the list of citizens
     * @return list of citizens
     */
    public List<Citizen> getCitizens(){
        return citizens;
    }

    /**
     * Getter of the list of buildings
     * @return list of buildings
     */

    public HashMap<Position,Building> getBuildings(){
        return building;
    }

    /**
     * Setter of the resources
     * @param r ressource to add
     * @param i number of ressource to add
     */

     public void setResource(Resource r, int i){
        resources.put(r, resources.get(r)+i);
    }
    
    /**
     * Remove a citizen to the game
     * @param c citizen to remove
     */
    
     public void citizenDeath(Citizen c){
        c.getHome().removeCitizen(c);
        c.getWorkplace().removeWorker(c);
        citizens.remove(c);
    }

    /**
     * Setter of the list of buildings
     * @param pos position of the building
     * @param b building to add
     */

    public void setBuilding(Position pos,Building b){
        int cpt = 0;
        int length = b.getResourcesNeeded().size();
        for (Resource r : b.getResourcesNeeded().keySet()){
            if (resources.get(r) >= b.getResourcesNeeded().get(r)){
                cpt ++;
            }
            else{
                System.out.println("Not enought "+ r + " to build " + b.getName());
            }
        }
        if (cpt == length){
            building.put(pos,b);
            for (Resource r : b.getResourcesNeeded().keySet()){
                resources.put(r,resources.get(r) - b.getResourcesNeeded().get(r));
            }
            addRound();
    }

    /**
     * Remove a building to the game
     * @param pos position of the building
     */

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

    /**
     * Add a round to the game
     */

    public void addRound(){
        round++;
    }

    /** 
     * Notify all the observers 
    */

    public void notifyObserver(){
        for(Observer o : observers){
            o.update();
        }
    }
    
    /**
     * Ask the UI to print the world
     */
    
     public void printWorld(){
        ui.printWorld();
    }

    /**
     * Ask the UI to wait the entry of the player
     */

    public void waitEntry(){
        ui.waitEntry();
    }

    /**
     * Ask the UI to print the resources
     */

    public void printResource(){
        ui.printResource();
    }

    /**
     * Add workers to a building
     * @param c citizen to add
     * @param b building where the citizen is added
     */
    public void AddWorkerToABuilding(Building b,int number){
        int cpt = 0;
        try {
            for (int i = 0; i < citizens.size(); i++) {
                if (citizens.get(i).getWorkplace() == null) {
                    b.addWorker(citizens.get(i));
                    cpt++;
                    if (cpt == number) {
                        break;
                    }
                }
            }
        }
        catch (BuildingException e){
            System.err.println("Only " + cpt + " workers added to " + b.getName());
        }
        addRound();
    }
    /**
     * Remove workers to a building
     * @param b building where the citizen is removed
     * @param number number of citizen removed
     */
    public void removeWorkerFromBuilding(Building b,int number){
        int cpt = 0;
        try {
            for (int i = 0; i < citizens.size(); i++) {
                if (citizens.get(i).getWorkplace() == b) {
                    b.removeWorker(citizens.get(i));
                    cpt++;
                    if (cpt == number) {
                        break;
                    }
                }
            }
        }
        catch (BuildingException e){
            System.err.println("Only " + cpt + " workers removed from " + b.getName());
        }
        addRound();
    }

    /**
     * Add citizen to a building 
     * @param b building where the citizen is add
     * @param number number of citizen added
     */
    public void addCitizenToABuilding(Building b,int number){
        int cpt = 0;
        try {
            for (int i = 0; i < citizens.size(); i++) {
                if (citizens.get(i).getHome() == null) {
                    b.addCitizen(citizens.get(i));
                    cpt++;
                    if (cpt == number) {
                        break;
                    }
                }
            }
        }
        catch (BuildingException e){
            System.err.println("Only " + cpt + " citizen added to " + b.getName());
        }
        addRound();
    }
    /**
     * Remove citizen to a building 
     * @param b building where the citizen is removed
     * @param number number of citizen removed
     */
    public void removeCitizenFromBuilding(Building b,int number){
        int cpt = 0;
        try {
            for (int i = 0; i < citizens.size(); i++) {
                if (citizens.get(i).getHome() == b) {
                    b.removeCitizen(citizens.get(i));
                    cpt++;
                    if (cpt == number) {
                        break;
                    }
                }
            }
        }
        catch (BuildingException e){
            System.err.println("Only " + cpt + " workers removed from " + b.getName());
        }
        addRound();
    }
    /**
     * Get the number of citizen without home
     * @return number of homeless
     */
    public int getNumberHomeless(){
        int cpt = 0;
        for (int i = 0; i < citizens.size();i++){
            if (citizens.get(i).getHome() == null){
                cpt ++;
            }
        }
        return cpt;
    }
    /**
     * Get the number of workers without work
     * @return number of workless 
     */
    public int getNumberWorkless(){
        int cpt = 0;
        for (int i =0; i < citizens.size();i++){
            if (citizens.get(i).getWorkplace() == null){
                cpt ++;
            }
        }
        return cpt;
    }

    /**
     * Check if the game is finished
     * @return true if the game is finished
     */

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