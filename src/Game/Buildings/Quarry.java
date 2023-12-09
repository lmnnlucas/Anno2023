package Game.Buildings;

import java.util.HashMap;

import Game.Resource;

public class Quarry extends Building {
    public Quarry(){
        super("Quarry", 30, 2, 2, 4);

        this.setResourcesConsumption(null);
        this.setResourcesNeeded(new HashMap<>(){{
            put(Resource.WOOD, 50);
        }});

        this.setResourcesGenerating( new HashMap<>(){{
            put(Resource.STONE, 4);
            put(Resource.IRON,4);
            put(Resource.COAL,4);
            put(Resource.GOLD,2);
        }});
    }
}
