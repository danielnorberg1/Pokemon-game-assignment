package assignment2;


//This class is where we declare all the "skill" attributes and import "Skill".

public class Skill {

    private String name;
    private int skillAttackPower;
    private int skillEnergyCost;

    Skill(String name, int skillAttackPower, int skillEnergyCost) {
        this.name = name;
        this.skillAttackPower = skillAttackPower;
        this.skillEnergyCost = skillEnergyCost;
    }

    //Here we are checking the equality between different skills.
    public boolean equal(Object obj) {
        
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Skill)) {
            return false;
        }

        Skill otherSkill = (Skill) obj;
        boolean equalName = this.name.equals(otherSkill.name);
        boolean equalSkillAttackPower = this.skillAttackPower == otherSkill.skillAttackPower;
        boolean equalSkillEnergyCost = this.skillEnergyCost == otherSkill.skillEnergyCost;

        return equalName && equalSkillAttackPower && equalSkillEnergyCost;

    }

    public String getName() { return this.name; }
    public int getSkillAttackPower() { return this.skillAttackPower; }
    public int getSkillEnergyCost() { return this.skillEnergyCost; }

    public String toString() {
        return name + " - AP: " + skillAttackPower + " EC: " + skillEnergyCost;
    }
}
