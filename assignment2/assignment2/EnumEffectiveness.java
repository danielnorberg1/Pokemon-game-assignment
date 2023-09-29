package assignment2;

public enum EnumEffectiveness {
    SUPEREFFECTIVE(" It is super effective!", 2),
    NOTEFFECTIVE(" It is not very effective...", 2),
    NORMALEFFECTIVE;

    final String EFFECT_MESSAGE;
    double damageMultiplier; 
    
    public EnumEffectiveness(){
        this.EFFECT_MESSAGE = EFFECT_MESSAGE;
        this.damageMultiplier = damageMultiplier;
    }
}
