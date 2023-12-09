package Game.Buildings;

import Game.Resource;

import java.util.HashMap;

public class House extends Building {
    public House() {
        super("House", 0, 4, 4, 1);

        this.setResourcesNeeded(new HashMap<>() {{
            put(Resource.WOOD, 2);
            put(Resource.STONE, 2);
        }});

        this.setResourcesGenerating(null);
        this.setResourcesConsumption(null);
    }
}
