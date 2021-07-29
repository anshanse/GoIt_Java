package Bin;

import Model.Goods;
import Storage.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class GroceryBinTest {
    private final Goods itemA = Goods.builder().id("A").price(1.25d).discountQty(3).discountPrice(3.0d).saleable(true).build();
    private Storage<String> storage = Mockito.mock(GroceryStorage.class);
    private Bin<Storage, String> groceryBin = new GroceryBin();


    @Test
    public void calculateTotalCost() {
    }

    @Before
    public void setUp() throws Exception {
        Mockito.when(storage.getGoods("A")).thenReturn(itemA);
        Mockito.when(storage.existByID("A")).thenReturn(true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateTotalCostSale() {
        String order = "AAAA";
        double totalCost = groceryBin.calculateTotalCost(storage, order);
        assertEquals(4.25d,totalCost,0.01);
    }

    @Test
    public void testCalculateTotalCost() {
        String order = "AA";
        double totalCost = groceryBin.calculateTotalCost(storage, order);
        assertEquals(2.5d,totalCost,0.01);
    }

    @Test
    public void testCalculateTotalCostWrong() {
        String order = "EEE";
        double totalCost = groceryBin.calculateTotalCost(storage, order);
        assertEquals(0.0d,totalCost,0.01);
    }

    @Test
    public void testCalculateTotalCostWrong1() {
        String order = "#124DAB+=";
        double totalCost = groceryBin.calculateTotalCost(storage, order);
        assertEquals(0.0d,totalCost,0.0);
    }
}