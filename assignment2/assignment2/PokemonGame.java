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

        System.out.print(porygon.attack(wigglytuff));
        System.out.print(porygon.attack(wigglytuff));
        System.out.print(porygon.attack(wigglytuff));


        Item potion = new Item("Potion", 20, 5.0);
        Item hyperPotion = new Item("Hyper Potion", 50, 10.0);
        Item superPotion = new Item("Super Potion", 40, 8.0);

        ItemBag itemBag = new ItemBag(15.0);
        itemBag.addItem(potion);    //5
        itemBag.addItem(hyperPotion);  //10
        System.out.println(itemBag.addItem(superPotion) + " 1 ");
        System.out.println(itemBag.getCurrentWeight() + " 2 ");
        System.out.println(itemBag.removeItemAt(0) + " 3 ");
        System.out.println(itemBag.removeItemAt(1) + " 4 ");
        System.out.println(itemBag.addItem(superPotion) + " 5 ");
        System.out.println(itemBag.getCurrentWeight() + " 6 ");


    }

}
