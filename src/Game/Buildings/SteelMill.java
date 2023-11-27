package Game.Buildings;

import Game.Resource;

import java.util.HashMap;

public class SteelMill extends Building{
    private final String name = "Steel Mill";
    public SteelMill() {
        super("Wooden Cabin", 40, 0, 2, 1, 6);
        this.setResourcesConsumption(new HashMap<>()
         {{
             put(Resource.COAL, 2);
             put(Resource.IRON, 4);
         }}
        );        this.setResourcesNeeded(new HashMap<>(){{
            put(Resource.WOOD, 100);
            put(Resource.STONE, 50);
        }});

        this.setResourcesGenerating( new HashMap<>(){{
            put(Resource.STEEL, 4);
        }});
    }
}
