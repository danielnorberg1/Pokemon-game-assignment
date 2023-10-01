package assignment2;

public class CalculateDamage {
    
    private Pokemon attacker;
    private Pokemon defender;
    private String effectString;
    private int totalDamage;
    
    //A object that is made when an attack is sucessfull that contains calculates gets the effectiveness and calculates the totalt damage and also forwards the message. 
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