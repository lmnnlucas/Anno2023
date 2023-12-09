package Game.Buildings;

import Game.Resource;

import java.util.HashMap;

public class WoodenCabin extends Building{

    public WoodenCabin() {
        super("Wooden Cabin", 2, 2, 2, 1);
        this.setResourcesConsumption(null);
        this.setResourcesNeeded(new HashMap<>(){{
            put(Resource.WOOD, 1);
        }});

        this.setResourcesGenerating( new HashMap<>(){{
            put(Resource.FOOD, 2);
            put(Resource.WOOD, 2);
        }});
    }
}
