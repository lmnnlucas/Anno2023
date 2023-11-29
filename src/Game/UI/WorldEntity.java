package Game.UI;

public enum WorldEntity
{
    NOTHING('x'),
    WOODEN_CABIN('W'),
    HOUSE('H'),
    APARTMENTBUILDING('A'),
    FARM('F'),
    QUARRY('Q'),
    LUMBERMILL('L'),
    CEMENTPLANT('C'),
    STEELMILL('S'),
    TOOLFACTORY('T');
    private final char code;

    WorldEntity(char code) {
        this.code = code;
    }

}
