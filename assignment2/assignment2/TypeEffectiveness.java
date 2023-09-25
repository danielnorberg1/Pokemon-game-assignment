package assignment2;
public class TypeEffectiveness{
    public TypeEffectiveness(){
            
        }

    public EnumEffectiveness calcEffectiveness(EnumType attType, EnumType defType){


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
    }
}