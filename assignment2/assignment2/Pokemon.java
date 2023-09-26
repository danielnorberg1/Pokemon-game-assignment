package assignment2;

import java.nio.file.attribute.PosixFilePermission;

public class Pokemon {

    // EP is short for Energy Points
    // AP is short for Attack Power
    private String name;
    private int maxHealth;
    private int hp;
    private int ep;
    private Skill skill;
    private EnumType type;
    private ItemBag itemBag;


    final double SUPER_EFFECTIVE = 2;
    final double NOT_EFFECTIVE = 0.5;

    public Pokemon(String name, int maxHealth, String type) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.hp = maxHealth;
        this.ep = 100;
        PokemonType pokemonType = new PokemonType(type);
        this.type = pokemonType.getEnumType();
        this.skill = null;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public int getEnergy() {
        return ep;
    }

    public int getCurrentHP() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setCurrentHP(int updatedHP) {
        this.hp = updatedHP;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    


    public String getType(){
        return type.toString();
    }
public EnumType getEnumType() {
        return type;
    }

    public String toString() {
        String pokemon;
        if (skill != null) {
            pokemon = (name + " (" + type.toString() + "). Knows " + skill.toString());
        } else {
            pokemon = (name + " (" + type.toString() + ")");
        }
        return pokemon;
    }

    public int getMAX_HP() {
        return maxHealth;
    }

    public void attack(Pokemon defender) {
        
        //EnumEffectiveness effectiveness = New EnumEffectiveness();
        TypeEffectiveness typeEffectiveness = new TypeEffectiveness();
        EnumEffectiveness effectiveness = typeEffectiveness.calcEffectiveness(this.type, defender.type);
        if (defender.getCurrentHP() <= 0) {
            System.out.printf("Attack failed. %s fainted.", defender.name);
                    } else if ((this.getCurrentHP() <= 0)){
            System.out.printf("Attack failed. %s fainted.", this.name);
                    } else if(this.knowsSkill() == false){
            System.out.printf("Attack failed. %s does not know a skill.", this.name);
                    } else if(this.getEnergy() < this.skill.getSkillEnergyCost()){
            System.out.printf("Attack failed. %s lacks energy: %d/%d", this.name, this.getEnergy(), this.skill.getSkillEnergyCost());
                    }
            else{
            this.spendEnergy(this.skill.getSkillEnergyCost());
            System.out.printf("%s uses %s on %s.",this.name, this.skill.getName(), defender.getName());

            switch (effectiveness){
                case SUPEREFFECTIVE:
                    defender.receiveDamage((int)(this.skill.getSkillAttackPower()*SUPER_EFFECTIVE));
                    System.out.print("It is super effective!");
                    break;
                case NOTEFFECTIVE:
                    defender.receiveDamage((int)(this.skill.getSkillAttackPower()*NOT_EFFECTIVE));
                    System.out.print("It is not very effective...");
                default:
                    defender.receiveDamage((int)(this.skill.getSkillAttackPower()));
            }
            System.out.printf("\n%s has %d HP left.", defender.name, defender.getCurrentHP());
            if (defender.getCurrentHP() <= 0){
                System.out.printf("%s faints.", defender.name);
            }

        }
    }

    public boolean equals(Object obj) {

        Pokemon otherPokemon = (Pokemon) obj;
        boolean equalName = this.name.equals(otherPokemon.name);
        boolean equalMaxHealth = this.maxHealth == otherPokemon.maxHealth;
        boolean equalHp = this.hp == otherPokemon.hp;
        boolean equalEp = this.ep == otherPokemon.ep;
        boolean equalType = this.type.equals(otherPokemon.type);

        return equalName && equalMaxHealth && equalHp && equalEp && equalType;
    }

    // Up above is task 1

    public boolean knowsSkill() {
        return skill != null;
    }

    public void learnSkill(String skillName, int skillAttackPower, int skillEnergyCost) {
        this.skill = new Skill(skillName, skillAttackPower, skillEnergyCost);

    }

    public void forgetSkill() {
        skill = null;
    }

    public void rest() {
        if (hp > 0) {
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
        if (ep > 0) {
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
    
    



    public String useItem(Item item) {
        int currentHP = getCurrentHP();
        int maxHP = getMAX_HP();
        int newHP = getCurrentHP() + item.getHealingPower();
                
                
    
        if (this.hp == maxHP) {
           return String.format("%s could not use %s. HP is already full.", this.name, item.getItemName());
        } 
    
        if (newHP >= maxHP) {
                this.hp = maxHP;
                return String.format("%s used %s. It healed %d HP.", this.name, item.getItemName(),maxHP - currentHP);//HealingPower = 30 -? =20
            } else {
                this.hp = newHP;
                return String.format("%s used %s. It healed %d HP.", this.name, item.getItemName(), item.getHealingPower());
            }

            }
        }
// healing power = 30 should be 20
//current hp + healing power = 30+30 = 60
//maxhp + healing power = 50+30 = 80
//


    //public boolean equals(Object objHeal){
   


    

       // System.out.printf("%s used %s. It healed %d HP",this.name, item.getHealingPower());
    //}else {
        //System.out.printf("%s could not use %s. HP is already full.",this.name, item.getItemName());

    







   

// public void attac(Pokemon target