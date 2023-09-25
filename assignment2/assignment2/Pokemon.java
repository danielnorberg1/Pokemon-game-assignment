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

    public void attack(Pokemon pokemon) {
        if (pokemon.getCurrentHP() != 0) {
            switch (this.type) {
                case FIRE:
                    if (pokemon.type == EnumType.GRASS) {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower() * SUPER_EFFECTIVE));
                    } else if ((pokemon.type == EnumType.NORMAL)) {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower()));
                    } else {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower() * NOT_EFFECTIVE));
                    }
                    break;
                case WATER:
                    if (pokemon.type == EnumType.FIRE) {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower() * SUPER_EFFECTIVE));
                    } else if ((pokemon.type == EnumType.NORMAL)) {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower()));
                    } else {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower() * NOT_EFFECTIVE));
                    }
                    break;
                case GRASS:
                    if (pokemon.type == EnumType.WATER) {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower() * SUPER_EFFECTIVE));
                    } else if ((pokemon.type == EnumType.NORMAL)) {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower()));
                    } else {
                        pokemon.receiveDamage((int) (this.skill.getSkillAttackPower() * NOT_EFFECTIVE));
                    }
                    break;
                default:
                    pokemon.receiveDamage(this.skill.getSkillAttackPower());
            }
            this.spendEnergy(this.skill.getSkillEnergyCost());
        } else {

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

}

// public void attac(Pokemon target