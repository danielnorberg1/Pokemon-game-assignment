package assignment2;

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

    final int maxEP = 100;
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

    public String getType() {
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

    public String attack(Pokemon defender) {

        String message = "";
        // Here is when attacks are "failing"
        if (defender.getCurrentHP() <= 0) {
            message = String.format("Attack failed. %s fainted.", defender.name);
        } else if ((this.getCurrentHP() <= 0)) {
            message = String.format("Attack failed. %s fainted.", this.name);
        } else if (this.knowsSkill() == false) {
            message = String.format("Attack failed. %s does not know a skill.", this.name);
        } else if (this.getEnergy() < this.skill.getSkillEnergyCost()) {
            message = String.format("Attack failed. %s lacks energy: %d/%d", this.name, this.getEnergy(),
                    this.skill.getSkillEnergyCost());
        } else {
            TypeEffectiveness typeEffectiveness = new TypeEffectiveness();
            EnumEffectiveness effectiveness = typeEffectiveness.calcEffectiveness(this.type, defender.type);
            // Here is when the pokemons succed with their attacks
            this.spendEnergy(this.skill.getSkillEnergyCost());
            message = String.format("%s uses %s on %s.", this.name, this.skill.getName(), defender.getName());

            switch (effectiveness) {
                case SUPEREFFECTIVE:
                    defender.receiveDamage((int) (this.skill.getSkillAttackPower() * SUPER_EFFECTIVE));
                    message += (" It is super effective!");
                    break;
                case NOTEFFECTIVE:
                    defender.receiveDamage((int) (this.skill.getSkillAttackPower() * NOT_EFFECTIVE));
                    message += (" It is not very effective...");
                    break;
                default:
                    defender.receiveDamage(this.skill.getSkillAttackPower());
            }
            message += String.format("\n%s has %d HP left.", defender.name, defender.getCurrentHP());
            if (defender.getCurrentHP() <= 0) {
                message += String.format(" %s faints.", defender.name);
            }

        }
        return message;
    }

    public boolean equals(Object otherObject) {

        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }

        Pokemon otherPokemon = (Pokemon) otherObject;
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
            if (ep > maxEP) {
                ep = maxEP;
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
            return String.format("%s used %s. It healed %d HP.", this.name, item.getItemName(), maxHP - currentHP);
        } else {
            this.hp = newHP;
            return String.format("%s used %s. It healed %d HP.", this.name, item.getItemName(), item.getHealingPower());
        }

    }

}
