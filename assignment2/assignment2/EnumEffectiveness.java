package assignment2;

public enum EnumEffectiveness {
    SUPEREFFECTIVE(" It is super effective!", 2),
    NOTEFFECTIVE(" It is not very effective...", 0.5),
    NORMALEFFECTIVE("",1);

    private final String effectString;
    private final double damageMultiplier; 
    
    private EnumEffectiveness(String effectString, double damageMultiplier){
        this.effectString = effectString;
        this.damageMultiplier = damageMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }
    public String getEffectString() {
        return effectString;
    }
}
