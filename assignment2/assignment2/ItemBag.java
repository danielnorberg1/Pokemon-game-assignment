 package assignment2;

import java.util.ArrayList;
import java.util.List;

public class ItemBag {

    private double maxWeight;
    private List <Item> items;

    ItemBag(double maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0.0;
        this.items = new ArrayList<>();
        }

        public double getMaxWeight() {
            return maxWeight;
    }


}
