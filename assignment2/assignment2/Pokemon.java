
 package assignment2;
 
 public class Pokemon {

    // EP is short for Energy Points
    // AP is short for Attack Power
    private String name;
    private int maxHealth;
    private int hp;
    private int ep;
    private Skill skill;
    private String type;


    public Pokemon(String name, int maxHealth, String type) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.hp = maxHealth;
        this.ep = 100;
        this.type = type;/*typeConvert(type);*/
        this.skill = null;
    }

  

    public int getEnergy(){
        return ep;
    }

    public int getCurrentHP(){
        return hp;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }


    public String toString() {
    String pokemon; 
    if (skill != null){
    pokemon = (name + " (" + type.toString() + "). Knows " + skill + " - AP: " + skill.getSkillAttackPower() + " EC: " + skill.getSkillEnergyCost());
    }
    else {
    pokemon = (name + " (" + type.toString() + ")");
    }
    return pokemon;
    }

    public int getMAX_HP(){
    return maxHealth;
    }

    









    // ONLY MOVED IT A COUPLE STEPS DOWN TO TRY //DANIEL <3
  


    public boolean knowsSkill(){ 
        return skill != null;
    }



    public void learnSkill(Skill skillName, int skillAttackPower, int skillEnergyCost) {
        this.skill = new Skill(name, skillAttackPower, skillEnergyCost);
       
    }

    public void forgetSkill() {
        skill = null;
    }

  

    public void rest() {
        if (hp > 0){
        hp += 20;
            if (hp > maxHealth) {
                hp = maxHealth;
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
      public void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

   
}

    // public void attac(Pokemon target