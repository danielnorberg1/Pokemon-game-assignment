package assignment2;

public class TypeEffectiveness {
    //public TypeEffectiveness() {}
    //The class for determening the Effectivness for the different types.
    public static EnumEffectiveness calcEffectiveness(EnumType attType, EnumType defType) {

        switch (attType) {
            case BUG:
                switch (defType) {
                    case GRASS:
                        return EnumEffectiveness.SUPEREFFECTIVE; // For example here we are the enum grass Suppereffective to enum bug.
                    case FIRE:
                        return EnumEffectiveness.NOTEFFECTIVE;
                    default:
                        return EnumEffectiveness.NORMALEFFECTIVE;
                }
            case DRAGON:
                switch (defType) {
                    case DRAGON:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    default:
                        return EnumEffectiveness.NORMALEFFECTIVE;
                }
            case ELECTRIC:
                switch (defType) {
                    case WATER:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case DRAGON, ELECTRIC, GRASS:
                        return EnumEffectiveness.NOTEFFECTIVE;
                    default:
                        return EnumEffectiveness.NORMALEFFECTIVE;
                }
            case FIRE:
                switch (defType) {
                    case GRASS, BUG, ICE:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case WATER, FIRE, DRAGON:
                        return EnumEffectiveness.NOTEFFECTIVE;
                    default:
                        return EnumEffectiveness.NORMALEFFECTIVE;
                }
            case GRASS:
                switch (defType) {
                    case WATER:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case BUG, DRAGON, FIRE, GRASS:
                        return EnumEffectiveness.NOTEFFECTIVE;
                    default:
                        return EnumEffectiveness.NORMALEFFECTIVE;
                }
            case ICE:
                switch (defType) {
                    case DRAGON, GRASS:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case FIRE, ICE, WATER:
                        return EnumEffectiveness.NOTEFFECTIVE;
                    default:
                        return EnumEffectiveness.NORMALEFFECTIVE;
                }
            case WATER:
                switch (defType) {
                    case FIRE:
                        return EnumEffectiveness.SUPEREFFECTIVE;
                    case DRAGON, GRASS, WATER:
                        return EnumEffectiveness.NOTEFFECTIVE;
                    default:
                        return EnumEffectiveness.NORMALEFFECTIVE;
                }

            default:
                return EnumEffectiveness.NORMALEFFECTIVE;
        }
    }
}