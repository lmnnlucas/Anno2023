package Game.Buildings;

import java.util.HashMap;

import Game.Resource;

public class Farm extends Building {

    public Farm() {
        super("Farm", 3, 5, 2, 4);

        this.setResourcesConsumption(null);
        this.setResourcesNeeded(new HashMap<>(){{
            put(Resource.WOOD, 5);
            put(Resource.STONE,5);
        }});

        this.setResourcesGenerating( new HashMap<>(){{
            put(Resource.FOOD, 10);
        }});
    }

}
