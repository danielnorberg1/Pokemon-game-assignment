 package assignment2;
public class PokemonType {
    
    private EnumType enumType;

    public PokemonType(String typeString){
        switch (typeString.trim().toUpperCase()) {
            case "FIRE":
                this.enumType = EnumType.FIRE;
                break;
            case "WATER":
                this.enumType = EnumType.WATER;
                break;
            case "GRASS":
                this.enumType = EnumType.GRASS;
                break;
            case "NORMAL":
                this.enumType = EnumType.NORMAL;
                break;
            default:
                this.enumType = null;
    }
}
    public EnumType getEnumType(){
        return enumType;
    }
    public String toString(){
        return "" + enumType;
    }
    /* 
    public EnumType typeConvert(String typeString){
        typeString = typeString.trim().toUpperCase();
        
        switch (typeString) {
            case "FIRE":
                return EnumType.Fire;
            case "WATER":
                return EnumType.WATER;
            case "GRASS":
                return EnumType.GRASS;
            case "NORMAL":
                return EnumType.NORMAL;
            default:
                return null;
        }

        */
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
