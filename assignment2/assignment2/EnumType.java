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

    final String TYPE;

    EnumType(String typeString) {
        this.TYPE = typeString;
    }

    public String toString() {
        return TYPE;
    }
}
