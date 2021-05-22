package HWTelegram.HW3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UberShop {
    public void printPrices(float[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]+" jup.");
        }
    }

    public void multiplyPrices(float[] prices){
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<1000) prices[i]=prices[i]*2.0f;
            else prices[i]=prices[i]*1.5f;
        }
    }

    public int[] findMinMaxPrices(int[] prices){
        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;
        if (prices.length == 0){
            int [] extremPrice = {};
            return extremPrice;
        }
        for (int i=0; i<prices.length; i++){
            maxPrice = maxPrice<prices[i] ? prices [i]:maxPrice;
            minPrice = minPrice>prices[i] ? prices[i]:minPrice;
        }
        if (maxPrice == minPrice) {
            int [] extremPrice = {maxPrice};
            return extremPrice;
        }
        else {
            int [] extremPrice = {minPrice, maxPrice};
            return extremPrice;
        }
    }

    public int getMinPriceCount(int[] prices){
        if (prices.length == 0 ) return 0;
        int minPrice = prices[0];
        int count = 0;
        for (int i=0; i<prices.length; i++){
            if (minPrice>=prices[i]){
                if (minPrice == prices[i]) count++;
                else {
                    minPrice = prices[i];
                    count = 1;
                }
            }
        }
        if (count == prices.length) return prices.length;
        else return count;
    }

    public int[] removePrice(int[] prices, int toRemove){
        int count=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == toRemove) count++;
        }
        int [] result = new int[prices.length-count];
        int j=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] != toRemove){
                result[j]=prices[i];
                j++;
            }
        }
        return result;
    }

    public int[] leavePrice9(int[] prices){
        int count=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]%10 == 9) count++;
        }
        int [] result = new int[count];
        int j=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]%10 == 9){
                result[j]=prices[i];
                j++;
            }
        }
        return result;
    }

    public String[] mergeStocks(String[] showcaseStocks, String[] warehouseStocks){
        String [] stock = new String[showcaseStocks.length+ warehouseStocks.length];
        for (int i = 0; i < showcaseStocks.length; i++) {
            stock[i] = showcaseStocks[i];
        }
        for (int i = 0; i < warehouseStocks.length; i++) {
            stock[showcaseStocks.length+i] = warehouseStocks[i];
        }
        return stock;
    }

    public int getPricesSum(int[] prices, int minPrice, int maxPrice){
        int sumPrice=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]>=minPrice && prices[i]<=maxPrice) sumPrice += prices[i];
        }
        return sumPrice;
    }

    //Test output
    public static void main(String[] args) {
        UberShop shop = new UberShop();

        //Should be 100 jup. 23.5 jup. 400 jup. - one price per line
        //float[] prices = new float[] {100f, 23.5f, 400f};
        //shop.printPrices(prices);

        //Should be [200, 2250]
        //float[] prices = new float[] {100f, 1500f};
        //shop.multiplyPrices(prices);
       //System.out.println(Arrays.toString(prices));

        //Should be [50, 1500]
        //int[] prices = new int[] {100, 1500, 300, 50};
        //int[] minMax = shop.findMinMaxPrices(prices);
        //System.out.println(Arrays.toString(minMax));

        /*System.out.println(shop.getMinPriceCount(new int[] {}));
        System.out.println(shop.getMinPriceCount(new int[] {5, 5, 5}));
        System.out.println(shop.getMinPriceCount(new int[] {5, 10, 15, 3, 5}));*/

        /*//Should be [150, 200]
        int[] prices = new int[]{150, 100, 200};
        int toRemove = 100;
        System.out.println(Arrays.toString(shop.removePrice(prices, toRemove)));*/

        //Should be [1599, 399]
        //int[] prices = new int[] {399, 1599, 399, 50, 10, 10, 70};
        //System.out.println(Arrays.toString(shop.leavePrice9(prices)));

        //Final result should be ["gun", "firebow", "firegun"]
        //String[] showcaseStocks = new String[] {"gun", "firebow"};
       //String[] warehouseStocks = new String[] {"firegun"};
        //System.out.println(Arrays.toString(shop.mergeStocks(showcaseStocks, warehouseStocks)));

        //Should be 144 - 20 + 50 + 40 + 34
        int[] prices = new int[] {10, 20, 50, 40, 34, 500};
        System.out.println(shop.getPricesSum(prices, 20, 50));
    }
}
