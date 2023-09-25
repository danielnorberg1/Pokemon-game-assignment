 package assignment2;
public class PokemonGame {
    public static void main(String[] args){
        Pokemon Erik = new Pokemon("Erik",180, "Water");
        Pokemon Hans = new Pokemon("Hans",150, "Grass");

        Pokemon wigglytuff = new Pokemon("Wigglytuff",130,"Normal");
        wigglytuff.learnSkill("Slam", 60, 35);

        Pokemon porygon = new Pokemon("Porygon", 120, "Normal");
        porygon.learnSkill("Hyper beam", 100, 50);

        Erik.learnSkill("Dansa", 30, 10);

        porygon.attack(wigglytuff);
        porygon.attack(wigglytuff);

    }

}
