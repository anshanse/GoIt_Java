package Bin;

import Model.Goods;
import Storage.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GroceryBin implements Bin<Storage, String>{

    private double totalCost=0, cost;

    private Map parseOrder (Storage storage, String orderList){
        Map<Character, Integer> order = new HashMap<>();
        char[] list = orderList.toCharArray();
        for (int i = 0; i < list.length; i++) {
            if (storage.existByID(String.valueOf(list[i]))) {
                int counter = 0;
                for (int j = 0; j < list.length; j++) {
                    if (list[i] == (list[j])) counter++;
                }
                order.put(list[i], counter);
            }
        }
        return order;
    }

    private boolean isTrash (String orderList){
        boolean trash = true;
        if (orderList.isEmpty() || orderList.toUpperCase().matches(".[A-Z]*")) trash = false;
        return trash;
    }

    @Override
    public double calculateTotalCost(Storage storage, String goodsLine) {
        if (isTrash(goodsLine)) totalCost = 0;
        else {
            Map<Character, Integer> order = parseOrder(storage, goodsLine.toUpperCase());

            Iterator<Map.Entry<Character, Integer>> iterator = order.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                Goods item = storage.getGoods(entry.getKey().toString());
                if (item.getSaleable()) {
                    cost = (entry.getValue() / item.getDiscountQty() * item.getDiscountPrice()) +
                            (entry.getValue() % item.getDiscountQty() * item.getPrice());
                } else cost = entry.getValue() * item.getPrice();
                totalCost += cost;
            }
        }
        return totalCost;
    }
}
