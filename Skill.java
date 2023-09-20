public class Skill {

    private String name;
    private int skillAttackPower;
    private int skillEnergyCost;

    Skill(String name, int skillAttackPower, int skillEnergyCost){
        this.name = name;
        this.skillAttackPower = skillAttackPower;
        this.skillEnergyCost = skillEnergyCost;
    }

    
    public int getSkillAttackPower(){
        return this.skillAttackPower;
    }
    public int getSkillEnergyCost(){
        return this.skillEnergyCost;
    }
    public String toString(){
        return name + " - AP: " + skillAttackPower + " EC: " + skillEnergyCost;
    }



}
