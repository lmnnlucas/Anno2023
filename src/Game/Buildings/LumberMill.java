package Game.Buildings;

import Game.Resource;

import java.util.HashMap;

public class LumberMill extends Building {
    public LumberMill() {
        super("Lumber Mill", 10, 0, 4, 6);

        this.setResourcesNeeded(new HashMap<>() {{
            put(Resource.WOOD, 50);
            put(Resource.STONE, 50);
        }});

        this.setResourcesConsumption(new HashMap<>() {{
            put(Resource.WOOD, 4);
        }});

        this.setResourcesGenerating(new HashMap<>() {{
            put(Resource.LUMBER, 4);
        }});
    }
}
