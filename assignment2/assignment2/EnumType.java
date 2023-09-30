package assignment2;

public enum EnumType {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    NORMAL("Normal"),
    ICE("Ice"),
    DRAGON("Dragon"),
    ELECTRIC("Electric"),
    BUG("Bug");

    private final String typeString;

    EnumType(String typeString) {
        this.typeString = typeString;
    }

    public String getTypeString() { return typeString;}
    
}
