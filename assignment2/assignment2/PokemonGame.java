 package assignment2;

import java.io.DataInputStream;

public class PokemonGame {
    public static void main(String[] args){
        Pokemon Erik = new Pokemon("Erik",180, "Water");
        Pokemon Hans = new Pokemon("Erik",150, "Grass");

        Erik.learnSkill("Dansa", 60, 10);

        Erik.attack(Hans);


    }

}
