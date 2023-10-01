package assignment2;

public class Pokemon {

    private String name;
    private int maxHealth;
    private int hp; //Health Points
    private int ep; //Energy Points
    private Skill skill; 
    private EnumType type;

    //Energy finals
    final int minEP = 0;
    final int maxEP = 100;
    final int recoverEP = 25;

    //Health finals
    final int restHP = 20;
    final int minHP = 0;

    //Effect finals
    final double SUPER_EFFECTIVE = 2;
    final double NOT_EFFECTIVE = 0.5;

    //CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Pokemon(String name, int maxHealth, String typeString) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.hp = maxHealth;
        this.ep = 100;
        PokemonType pokemonType = new PokemonType(typeString);
        this.type = pokemonType.getEnumType();
        this.skill = null;
    }

    // EQUALOVERRIDE -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean equals(Object otherObject) {

        //checks if they are the same object
        if (this == otherObject) {
            return true;
        }
        //checks if the object is null, or even a pokemon. 
        if (otherObject == null || !(otherObject instanceof Pokemon)) {
            return false;
        }

        Pokemon otherPokemon = (Pokemon) otherObject;
        boolean equalSkill;
        boolean equalName = this.name.equals(otherPokemon.name);
        boolean equalMaxHealth = this.maxHealth == otherPokemon.maxHealth;
        boolean equalHp = this.hp == otherPokemon.hp;
        boolean equalEp = this.ep == otherPokemon.ep;
        boolean equalType = this.type == otherPokemon.type;

        //if the pokemon has no skill we will get an error with .equals
        if ((this.skill == null) || (otherPokemon.skill == null)){
            equalSkill = this.skill == otherPokemon.skill;
        } else {
            equalSkill = this.skill.equal(otherPokemon);
        }

        return equalName && equalMaxHealth && equalHp && equalEp && equalType && equalSkill;
    }
    //Here we got all the setter and getters in a "short list". 
    //To be easier to access.
    //GET/SET-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void setName(String newName) { this.name = newName; }

    public int getEnergy() { return ep; }
    public int getCurrentHP() { return hp; }
    public int getMAX_HP() { return maxHealth; }
    public String getName() { return name; }
    public String getType() { return type.getTypeString(); }
    public EnumType getEnumType() { return type; }
    public int getPokemonSkillAttackPower(){return skill.getSkillAttackPower();}
    

    public String toString() {
        String message = (name + " (" + getType() + ")");
        if (this.skill != null){
           message += ". Knows " + skill.toString();
        }
        return message;
        
        }
        
    //ATTACK SEQUENCE ------------------------------------------------------------------------------------------------------------------------------------------------------

    public String attack(Pokemon defender) {

        String message = "Attack failed. ";
        //------------------------------------------------------ Fail scenarios

            if (defender.getCurrentHP() <= minHP) { //defender is fainted
                message = String.format("%s fainted.", defender.name);
            } 
            else if ((this.getCurrentHP() <= minHP)) { //attacker is fainted
                message = String.format("%s fainted.", this.name);
            } 
            else if (this.knowsSkill() == false) {  //attacker does not know skill
                message = String.format("%s does not know a skill.", this.name);
            } 
            else if (this.getEnergy() < this.skill.getSkillEnergyCost()) {  //does not have enough EP
                message = String.format("%s lacks energy: %d/%d", this.name, this.getEnergy(), this.skill.getSkillEnergyCost());


        //---------------------------------------------------sucessfull attack        
        } else {  
            
            this.spendEnergy(this.skill.getSkillEnergyCost());


            message = String.format("%s uses %s on %s.", this.name, this.skill.getName(), defender.getName()); //this always prints

            CalculateDamage calculateDamage = new CalculateDamage(this, defender);
            defender.receiveDamage(calculateDamage.getTotalDamage());
            message += calculateDamage.getEffectString(); //adds effect message. is empty if normal. 
    
            message += String.format("\n%s has %d HP left.", defender.name, defender.getCurrentHP()); //

            if (defender.getCurrentHP() <= minHP) {//if the pokemon faints 
                message += String.format(" %s faints.", defender.name);
            }
        }
        return message;
    }

  
    //SKILLS --------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public boolean knowsSkill() { return skill != null; } //checks if pokemon knows a skill

    public void learnSkill(String skillName, int skillAttackPower, int skillEnergyCost) {
        this.skill = new Skill(skillName, skillAttackPower, skillEnergyCost);
    }

    public void forgetSkill() { skill = null; }

    //POKEMON AFFECTS -------------------------------------------------------------------------------------------------------------------------------------------------------

    public void spendEnergy(int cost) { //Setting a function that the EP never gets below minEP
        ep -= cost;
        if (ep < minEP) {
            ep = minEP;
        }
    }
    public void recoverEnergy() {       //Setting a fixed value of ep to recover, and also impleminting the maxEP that it wont exceed.
        if (ep > minEP) {
            ep += recoverEP;
            if (ep > maxEP) {
                ep = maxEP;
            }
        }
    }
    public void receiveDamage(int damage) {     
        hp -= damage;
        if (hp < minHP) {
            hp = minHP;
        }
    }
    public void rest() {
        if (hp > minHP) {
            hp += restHP;
            if (hp > maxHealth) {
                hp = maxHealth;
            }
        }
    }

//ITEMS ------------------------------------------------------------------------------------------------------------------------------------------------------------

    public String useItem(Item item) {
        int currentHP = getCurrentHP();
        int maxHP = getMAX_HP();
        int newHP = getCurrentHP() + item.getHealingPower();

        if (this.hp == maxHP) {
            return String.format("%s could not use %s. HP is already full.", this.name, item.getItemName());
        }

        if (newHP >= maxHP) {
            this.hp = maxHP;
            return String.format("%s used %s. It healed %d HP.", this.name, item.getItemName(), maxHP - currentHP);
        } else {
            this.hp = newHP;
            return String.format("%s used %s. It healed %d HP.", this.name, item.getItemName(), item.getHealingPower());
        }

    }

}
