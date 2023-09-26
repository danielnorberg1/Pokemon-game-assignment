package assignment2;
public enum EnumTypeOLD {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    NORMAL("Normal");

    final String TYPE;

    EnumTypeOLD(String typeString){
    this.TYPE = typeString;
    }

    public String toString(){
        return TYPE;
    }

}


