public class PokemonType {

    public enum EnumType {
        WATER,
        FIRE,
        GRASS,
        NORMAL,
    }
    
    public EnumType typeConvert(String typeString){
        typeString = typeString.trim().toUpperCase();
        
        switch (typeString) {
            case "FIRE":
                return EnumType.FIRE;
            case "WATER":
                return EnumType.WATER;
            case "GRASS":
                return EnumType.GRASS;
            case "NORMAL":
                return EnumType.NORMAL;
            default:
                return null;
        }
        /* 
        if (typeString.equalsIgnoreCase("fire")){
            type = enumType.FIRE;
        }
        else if (typeString.equalsIgnoreCase("water")){
            type = enumType.WATER;
        }
        else if (typeString.equalsIgnoreCase("grass")){
            type = enumType.GRASS;
        }
        else if (typeString.equalsIgnoreCase("normal")){
            type = enumType.NORMAL;
        }
        else {
            type = null;
        }
            
        return type;
        */
    }
}