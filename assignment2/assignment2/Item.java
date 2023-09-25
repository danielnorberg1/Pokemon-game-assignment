package assignment2;
public class Item {

   //attributes - variabler

    private String itemName;
    private int healingPower;
    private double weight;

    //Constructor

    public Item (String itemName, int healingPower, double weight) {
    this.itemName = itemName;
    this.healingPower = healingPower;
    this.weight = weight;
    }

    //getters

    public String getItemName() {
        return itemName;
    }

    public int getHealingPower () {
        return healingPower;
    }

    public double getWeight() {
        return weight;
    }

    //setters

    public void setItemName(String newItemName){
        this.itemName = newItemName;
    }

    public void setHealingPower(int newHealingPower){
        this.healingPower = newHealingPower;
    }

    public void getWeight(double newWeight){
        this.weight=newWeight;
    }


    public String toString() {
        double truncatedWeight = Math.floor(this.getWeight() * 100) / 100;

        return String.format("%s heals %d HP. (%.2f)", this.getItemName(), this.getHealingPower(), truncatedWeight);
    }
    if ()
    
    }
    
    //methods

    




    




    //enum HealingResult {
        // Vulpix’s HP cannot go beyond 50
    //FULL_HP ("%s could not use %s. HP is already full.",String name, String itemName);
    //HEAL_AMOUNT ("%s used %s. It healed %d HP",String name, int healingPower);
    //