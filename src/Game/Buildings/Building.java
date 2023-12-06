package Game.Buildings;

import Exceptions.BuildingException;
import Game.People.Citizen;
import Game.Resource;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Building {
    private String name;
    private int workersCapacity;
    private int citizensCapacity;
    private int buildingTime;
    private int level;
    private int goldCost;
    private HashMap<Resource, Integer> resourcesNeeded;
    private HashMap<Resource, Integer> resourcesConsumption;
    private HashMap<Resource, Integer> resourcesGenerating;

    private int citizensCount;
    private int workersCount;
    private ArrayList<Citizen> citizens;
    private ArrayList<Citizen> workers;

    public Building(String name, int workersCapacity, int citizensCapacity, int buildingTime, int level, int goldCost) {
        this.name = name;
        this.workersCapacity = workersCapacity;
        this.citizensCapacity = citizensCapacity;
        this.buildingTime = buildingTime;
        this.level = level;
        this.goldCost = goldCost;
        this.resourcesConsumption = new HashMap<>();
        this.resourcesNeeded = new HashMap<>();
        this.resourcesGenerating = new HashMap<>();
        this.citizens = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.citizensCount = 0;
        this.workersCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getWorkersCapacity() {
        return workersCapacity;
    }

    public void setWorkersCapacity(int workersCapacity) {
        this.workersCapacity = workersCapacity;
    }

    public int getCitizensCapacity() {
        return citizensCapacity;
    }

    public void setCitizensCapacity(int citizensCapacity) {
        this.citizensCapacity = citizensCapacity;
    }

    public int getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(int buildingTime) {
        this.buildingTime = buildingTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }

    public HashMap<Resource, Integer> getResourcesNeeded() {
        return resourcesNeeded;
    }

    public void setResourcesNeeded(HashMap<Resource, Integer> resourcesNeeded) {
        this.resourcesNeeded = resourcesNeeded;
    }

    public HashMap<Resource, Integer> getResourcesConsumption() {
        return resourcesConsumption;
    }

    public void setResourcesConsumption(HashMap<Resource, Integer> resourcesConsumption) {
        this.resourcesConsumption = resourcesConsumption;
    }

    public HashMap<Resource, Integer> getResourcesGenerating() {
        return resourcesGenerating;
    }

    public void setResourcesGenerating(HashMap<Resource, Integer> resourcesGenerating) {
        this.resourcesGenerating = resourcesGenerating;
    }

    public void addCitizen(Citizen citizen) {
        if (this.citizensCount < this.citizensCapacity) {
            this.citizens.add(citizen);
            this.citizensCount++;
            citizen.setHome(this);
            System.out.println("Citizen added");
        } else {
            throw new BuildingException("Citizen capacity of  " + this.getName() + " reached");
        }
    }

    public void addWorker(Citizen citizen) {
        if (this.workersCount < this.workersCapacity) {
            this.workers.add(citizen);
            this.workersCount++;
            System.out.println("Worker added");
            citizen.setWorkplace(this);
        } else {
            throw new BuildingException("Worker capacity of  " + this.getName() + " reached");
        }
    }

    public void removeCitizen(Citizen citizen) {
        if (this.citizensCount > 0) {
            for (int i = 0; i < this.citizensCount; i++) {
                if (this.citizens.get(i).getId() == citizen.getId()) {
                    this.citizens.remove(i);
                    this.citizensCount--;
                    this.citizens.get(i).setHome(null);
                    System.out.println("Citizen removed");
                    break;
                }
            }
            throw new BuildingException("Citizen not found");
        } else {
            throw new BuildingException("No citizen to remove");
        }
    }

    public void removeWorker(Citizen citizen) {
        if (this.workersCount > 0) {
            for (int i = 0; i < this.workersCount; i++) {
                if (this.workers.get(i).getId() == citizen.getId()) {
                    this.workers.remove(i);
                    this.workersCount--;
                    this.citizens.get(i).setWorkplace(null);
                    System.out.println("Worker removed");
                    break;
                }
            }
            throw new BuildingException("Worker not found");
        } else {
            throw new BuildingException("No worker to remove");
        }
    }

    public int getNumberofCitizens()
    {
        return this.citizensCount;
    }

    public int getNumberofWorkers()
    {
        return this.workersCount;
    }

}
