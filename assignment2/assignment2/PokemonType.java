package assignment2;

public class PokemonType {

    private EnumType enumType;



    public PokemonType(String typeString) {
        switch (typeString.trim().toUpperCase()) {      //A function to match the "end user's" input with our Enum.
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
            case "ICE":
                this.enumType = EnumType.ICE;
                break;
            case "BUG":
                this.enumType = EnumType.BUG;
                break;
            case "DRAGON":
                this.enumType = EnumType.DRAGON;
                break;
            case "ELECTRIC":
                this.enumType = EnumType.ELECTRIC;
                break;

            default:
                this.enumType = null;

        }
    }

    public EnumType getEnumType() { return enumType; }

    public String toString() {
        return enumType.toString();
    }

}
