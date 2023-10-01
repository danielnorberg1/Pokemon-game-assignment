package assignment2;

public class Item {

    // attributes

    private String itemName;
    private int healingPower;
    private double weight;

    // Constructor for creating an Item.

    public Item(String itemName, int healingPower, double weight) {
        this.itemName = itemName;
        this.healingPower = healingPower;
        this.weight = weight;
    }

    // getters

    public String getItemName() {
        return itemName;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public double getWeight() {
        return weight;
    }


   // A tostring that truncates the weight to 2 decimals, by casting to an int and then prints the Stats for an item.
    public String toString() {
        double truncatedWeight = ((int) (this.getWeight() * 100)) / 100.0; //the weight is casted to an int 

        return String.format("%s heals %d HP. (%.2f)", this.getItemName(), this.getHealingPower(), truncatedWeight);
    }

    // A method for checking if two created items are equal. Only if all 3 attributes are the same, an item is equal.

    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }

        Item copyItem = (Item) obj;
        boolean equalitemName = this.itemName.equals(copyItem.itemName);
        boolean equalHealingPower = this.healingPower == (copyItem.healingPower);
        boolean equalWeight = this.weight == (copyItem.weight);

        return equalitemName && equalHealingPower && equalWeight;

    }
}