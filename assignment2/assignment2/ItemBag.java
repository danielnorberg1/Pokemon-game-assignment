
package assignment2;

import java.util.ArrayList;
import java.util.List;

public class ItemBag {

    //variabler
    private double maxWeight;
    private double currentWeight;
    private List <Item> itemsInBag;

    //Constructor

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
 


    public Item removeItemAt (int index) {
        if(index < 0 || index >= itemsInBag.size()) {
            return null;
        }
        currentWeight -= itemsInBag.get(index).getWeight();
        return itemsInBag.remove(index);
    }

    public String peekItemAt (int index) {
        if (index < 0 || index >= itemsInBag.size()) {
            return "";
        }
        Item item = itemsInBag.get(index);
                return item.toString(); 
    }

    public Item popItem() {
        if (!itemsInBag.isEmpty()) {
            currentWeight -= itemsInBag.get(0).getWeight();
            return itemsInBag.remove(0);
        }
        return null;
    }
}