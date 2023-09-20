public class PokemonType {

    public enum Type {
        WATER,
        FIRE,
        GRASS,
        NORMAL,
    }
    public Type typeConvert(String typeString){
        typeString.trim();
        Type type;
        if (typeString.equalsIgnoreCase("fire")){
            type = Type.FIRE;
        }
        else if (typeString.equalsIgnoreCase("Water")){
            type = Type.WATER;
        }
        else if (typeString.equalsIgnoreCase("Grass")){
            type = Type.GRASS;
        }
        else if (typeString.equalsIgnoreCase("Normal")){
            type = Type.NORMAL;
        }
        else {
            type = null;
        }
            
        return type;
    }
}