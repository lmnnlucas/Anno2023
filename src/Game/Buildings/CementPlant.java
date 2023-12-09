package Game.Buildings;

import Game.Resource;

import java.util.HashMap;

public class CementPlant extends Building
{
    public CementPlant() {
        super("Cement Plant", 10, 0, 4, 4);
        this.setResourcesConsumption(new HashMap<>()
         {{
             put(Resource.COAL, 4);
             put(Resource.STONE, 4);
         }}
        );
        this.setResourcesNeeded(new HashMap<>(){{
            put(Resource.WOOD, 50);
            put(Resource.STONE, 50);
        }});

        this.setResourcesGenerating( new HashMap<>(){{
            put(Resource.CEMENT, 4);
        }});
    }
}
