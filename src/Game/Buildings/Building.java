package Game.Buildings;
import Game.Resource;

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

    public Building(String name, int workersCapacity, int citizensCapacity, int buildingTime, int level, int goldCost) {
        this.name = name;
        this.workersCapacity = workersCapacity;
        this.citizensCapacity = citizensCapacity;
        this.buildingTime = buildingTime;
        this.level = level;
        this.goldCost = goldCost;
        this.resourcesConsumption = new HashMap<>();
        this.resourcesNeeded = new HashMap<>();
        this.resourcesGenerating= new HashMap<>();
    }
}
