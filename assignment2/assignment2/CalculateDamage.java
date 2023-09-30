package assignment2;

public class CalculateDamage {
    
    private Pokemon attacker;
    private Pokemon defender;
    private String effectString;
    private int totalDamage;
    

    public CalculateDamage(Pokemon attacker, Pokemon defender){
        this.attacker = attacker;
        this.defender = defender;
        EnumEffectiveness effectiveness = TypeEffectiveness.calcEffectiveness(this.attacker.getEnumType(), this.defender.getEnumType());
        this.totalDamage = (int)(attacker.getPokemonSkillAttackPower() * effectiveness.getDamageMultiplier());
        this.effectString = effectiveness.getEffectString();
    }

    public String getEffectString() {
        return effectString;
    }
    public int getTotalDamage() {
        return totalDamage;
    }

}