package assignment2;

public class Item {

    // attributes - variabler

    private String itemName;
    private int healingPower;
    private double weight;

    // Constructor

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

    // setters

    // the Math.floor was taken from stack overflow When i wrote the code in the way
    // i known how it result
    // 4 rows of code,
    public String toString() {
        double truncatedWeight = ((int) (this.getWeight() * 100)) / 100.0; //the weight is casted to an int

        return String.format("%s heals %d HP. (%.2f)", this.getItemName(), this.getHealingPower(), truncatedWeight);
    }

    // methods

    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null  || !(obj instanceof Item)) {
            return false;
        }

        Item copyItem = (Item) obj;
        boolean equalitemName = this.itemName.equals(copyItem.itemName);
        boolean equalHealingPower = this.healingPower == (copyItem.healingPower);
        boolean equalWeight = this.weight == (copyItem.weight);

        return equalitemName && equalHealingPower && equalWeight;

    }
}