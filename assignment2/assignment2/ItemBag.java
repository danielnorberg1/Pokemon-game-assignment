
package assignment2;

import java.util.ArrayList;
import java.util.List;

public class ItemBag {

    //attributes

    private double maxWeight;
    private double currentWeight;
    private List <Item> itemsInBag; //A list of object Item.

    //Constructor for creating the Itembag.

    public ItemBag(double maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0.0;
        this.itemsInBag = new ArrayList<Item>();
        }

     //getters

   public int getNumOfItems() {
        return itemsInBag.size();
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getMaxWeight(){
        return maxWeight;
    }

    
    //Methods
    //First a method to add an item to the bag.
    //it iterates through the list checking wheter or not the added item is
    //the heaviest. Start at index 0 working its way up. When it finds an item that weighs less,
    // it places itself an index below that.

    public double addItem(Item item){
        int index = 0;
        if ((getCurrentWeight() + item.getWeight() > this.maxWeight)) {
            return -1;
        }  
   
            while (index < itemsInBag.size() && item.getWeight() < itemsInBag.get(index).getWeight()) {
                index++;
            }
            itemsInBag.add(index, item);
            currentWeight += item.getWeight();
            return index;   
        }
 

        //A method to remove an item from the itembag.
        //If the item referenced to be removed is not accepted

    public Item removeItemAt (int index) {
        if(index < 0 || index >= itemsInBag.size()) {
            return null;
        }
        currentWeight -= itemsInBag.get(index).getWeight();
        return itemsInBag.remove(index);
    }

    //The method below is used to peek at an item by a specific Index.
    //If the index is out of bounds it returns an empty string

    public String peekItemAt (int index) {
        if (index < 0 || index >= itemsInBag.size()) {
            return "";
        }
        Item item = itemsInBag.get(index);
                return item.toString(); 
    }

    //popItem is a method that pops an item.
    //It subtracts and returns the current weight, if the weight is not empty, then null.

    public Item popItem() {
        if (!itemsInBag.isEmpty()) {
            currentWeight -= itemsInBag.get(0).getWeight();
            return itemsInBag.remove(0);
        }
        return null;
    }
}
