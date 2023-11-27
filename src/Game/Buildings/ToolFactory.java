package Game.Buildings;

import java.util.HashMap;

import Game.Resource;

public class ToolFactory extends Building {
    public ToolFactory(){
        super("Tool Factory", 12, 0, 8, 1, 8);
        this.setResourcesNeeded(new HashMap<>() {{
            put(Resource.WOOD, 100);
            put(Resource.STONE, 50);
        }});

        this.setResourcesConsumption(new HashMap<>() {{
            put(Resource.STEEL, 4);
            put(Resource.COAL,4);
        }});

        this.setResourcesGenerating(new HashMap<>() {{
            put(Resource.TOOLS, 4);
        }});
    }
}
