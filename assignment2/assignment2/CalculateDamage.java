package assignment2;

public class CalculateDamage {
    
    private Pokemon attacker;
    private Pokemon defender;
    private String effectString;
    private int totalDamage;
    

    public CalculateDamage(Pokemon attacker, Pokemon defender){
        this.attacker = attacker;
        this.defender = defender;
        TypeEffectiveness typeEffectiveness = new TypeEffectiveness();
        EnumEffectiveness effectiveness = typeEffectiveness.calcEffectiveness(this.attacker.getEnumType(), this.defender.getEnumType());
        this.totalDamage = calcTotalDamage(effectiveness);
        this.effectString = effectiveness.getEffectString();
    }
    public int calcTotalDamage(EnumEffectiveness effectiveness){
        return (int)(attacker.getPokemonSkillAttackPower() * effectiveness.getDamageMultiplier());
    }

    public String getEffectString() {
        return effectString;
    }
    public int getTotalDamage() {
        return totalDamage;
    }

}