public class PokemonType {

    public EnumType typeConvert(String typeString){
        typeString.trim();
        EnumType type;
        if (typeString.equalsIgnoreCase("fire")){
            type = EnumType.FIRE;
        }
        else if (typeString.equalsIgnoreCase("water")){
            type = EnumType.WATER;
        }
        else if (typeString.equalsIgnoreCase("grass")){
            type = EnumType.GRASS;
        }
        else if (typeString.equalsIgnoreCase("normal")){
            type = EnumType.NORMAL;
        }
        else {
            type = null;
        }
            
        return type;
    }
}