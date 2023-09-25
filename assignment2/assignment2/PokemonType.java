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
    public static EnumEffectiveness calcEffectiveness(EnumType attType, EnumType defType){

        //EnumType attType = attacker.getEnumType();
        //EnumType defType = defender.getEnumType();
        
        switch (attType) {
            case FIRE:
                switch (defType){
                    case GRASS:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case NORMAL: 
                        return EnumEffectiveness.NORMALEFFECTIVE;
                    default:
                        return EnumEffectiveness.NOTEFFECTIVE;
                }
            case WATER:
                switch (defType){
                    case FIRE:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case NORMAL: 
                        return EnumEffectiveness.NORMALEFFECTIVE;
                    default:
                        return EnumEffectiveness.NOTEFFECTIVE;
                }
            case GRASS:
                switch (defType){
                    case WATER:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case NORMAL: 
                        return EnumEffectiveness.NORMALEFFECTIVE;
                    default:
                        return EnumEffectiveness.NOTEFFECTIVE;
                }
            default:
                return EnumEffectiveness.NORMALEFFECTIVE;
        }
    }*/
}
