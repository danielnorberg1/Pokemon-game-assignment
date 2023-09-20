public class Pokemon {


    private final String SKILL_FIRE_BLAST = "Fire Blast";
    private final String SKILL_WATER_GUN = "Water Gun";
    private final String SKILL_SOLAR_BEAM = "Solar Beam";
    private final String SKILL_TACKLE = "Tackle";

    // EP is short for Energy Points
    // AP is short for Attack Power
    private String name;
    private int maxHP;
    private int hp;
    private int ep;
    private Skill skill;
    private PokemonType type;
    private ItemBag itemBag;

    public Pokemon(String name, int maxHealth, PokemonType type, Skill skill) {
        this.name = name;
        this.maxHP = maxHealth;
        this.hp = maxHealth;
        this.ep = 100;
        this.type = type;
        this.skill = null;
        
      

    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void knowSkill() {
        if (skill != null){
            System.out.println(name + " (" + type + "). Knows " + skill + " - AP: " + skillAttackPower + " EC: " + skillEnergyCost);
        }
        else {
            System.out.println("No skill learned: " + name + " (" + type + ") ");
        }
    }

    public void learnSkill(Skill skillName, int skillAttackPower, int skillEnergyCost) {
        this.skill = new Skill(name, skillAttackPower, skillEnergyCost);
       
    }

    public void forgetSkill() {
        skill = null;
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void rest() {
        hp += 20;
        if (hp > maxHP) {
            hp = maxHP;
        }

    }

    public void spendEnergy(int cost) {
        ep -= cost;
        if (ep < 0) {
            ep = 0;
        }
    }

    public void recoverEnergy() {
        ep += 25;
        if (ep > 100) {
            ep = 100;
        }
    }

    // public void attac(Pokemon target)

    public void printPokemonStats() {
        if (skill == null) {
            System.out.println(name + " (" + type + ") ");
        } else {
            System.out.println(name + " (" + type + "). Knows " + skill + " - AP: " + skillAttackPower + " EC: " + " EC: "
                    + skillEnergyCost);
        }
    }
}
