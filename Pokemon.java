public class Pokemon {


   

    // EP is short for Energy Points
    // AP is short for Attack Power
    private String name;
    private int maxHP;
    private int hp;
    private int ep;
    private Skill skill;
    private PokemonType type;
    private ItemBag itemBag;

    public Pokemon(String name, int maxHealth, String type) {
        this.name = name;
        this.maxHP = maxHealth;
        this.hp = maxHealth;
        this.ep = 100;
        this.type = type.typeConvert(type);
        this.skill = null;
        
      

    }


    public void changeName(String newName) {
        this.name = newName;
    }


    public boolean knowsSkill(){ 
        return skill != null;
    }

    public String toString() {
        String pokemon;
        if (skill != null){
            pokemon = (name + " (" + type + "). Knows " + skill + " - AP: " + skill.getSkillAttackPower() + " EC: " + skill.getSkillEnergyCost());
        }
        else {
            pokemon = ("No skill learned: " + name + " (" + type + ") ");
        }
        return pokemon;
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
        if (hp > 0){
        hp += 20;
            if (hp > maxHP) {
                hp = maxHP;
        }
        }
    }

    public void spendEnergy(int cost) {
        ep -= cost;
        if (ep < 0) {
            ep = 0;
        }
    }

    public void recoverEnergy() {
    if (ep > 0){    
        ep += 25;
        if (ep > 100) {
            ep = 100;
        }
    }
    }

   
}

    // public void attac(Pokemon target