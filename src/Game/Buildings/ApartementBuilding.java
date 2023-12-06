package Game.Buildings;

import Game.Resource;

import java.util.HashMap;

public class ApartementBuilding extends Building
{
    private final String name = "Apartement Building";
    public ApartementBuilding() {
        super("Apartement Building", 0, 60, 6, 1, 4);
        this.setResourcesConsumption(null);
        this.setResourcesNeeded(new HashMap<>(){{
            put(Resource.WOOD, 50);
            put(Resource.STONE, 50);
        }});

        this.setResourcesGenerating(null);
    }

    @Override
    public boolean isAHome()
    {
        return true;
    }
}
