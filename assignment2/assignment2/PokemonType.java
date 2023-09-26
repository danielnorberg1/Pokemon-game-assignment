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

}
