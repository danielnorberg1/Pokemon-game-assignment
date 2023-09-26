package assignment2;
public class TypeEffectivenessOLD{
    public TypeEffectivenessOLD(){
            
        }

    public EnumEffectiveness calcEffectiveness(EnumType attType, EnumType defType){
        
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