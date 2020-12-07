package model;

import java.util.Map;

public class Order {

    private Map<String,Integer> itemAndQuantity;

    public Map<String, Integer> getItemAndQuantity() {
        return itemAndQuantity;
    }

    public void setItemAndQuantity(Map<String, Integer> itemAndQuantity) {
        this.itemAndQuantity = itemAndQuantity;
    }
}
