 package assignment2;
public class Item {

    private String itemName;
    private int healingPower;
    private double weight;

    public Item (String itemName, int healingPower, double weight) {
    this.itemName = itemName;
    this.healingPower = healingPower;
    this.weight = weight;
    }

    public String getItemName() {
        return itemName;
    }

    public int getHealingPower () {
        return healingPower;
    }

    public double getWeight() {
        return weight;



    }

   /*  enum HealingResult {
        FULL_HP ("%s could not use %s. HP is already full.");
        HEAL_AMOUNT (   )
        CANTUSE (    ) */

}
