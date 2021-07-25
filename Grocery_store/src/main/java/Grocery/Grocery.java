package Grocery;

import Bin.*;
import Storage.GroceryStorage;
import Storage.Storage;

public class Grocery {

    public static void main(String[] args) {
        //String goods = "ABCDABA";
        String goods = "ASDF45AADEW";

        Storage goodsStorage = new GroceryStorage();
        Bin<Storage, String> order = new GroceryBin();
        double total = order.calculateTotalCost(goodsStorage, goods);
        System.out.println("Total cost: " + total);
    }
}
