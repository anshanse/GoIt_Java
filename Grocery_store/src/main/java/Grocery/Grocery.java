package Grocery;

import Bin.*;
import Storage.GroceryStorage;
import Storage.Storage;

public class Grocery {

    public static void main(String[] args) {
        Storage goodsStorage = new GroceryStorage();
        Bin<Storage, String> order = new GroceryBin();
        double total = order.calculateTotalCost(goodsStorage, "ABCDABA");
        System.out.println("Total cost: " + total);
    }
}
