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
    private final Storage<String> storage = Mockito.mock(GroceryStorage.class);
    private final Bin<Storage, String> groceryBin = new GroceryBin();


    @Test
    public void calculateTotalCost() {
    }

    @Before
    public void setUp() throws Exception {
        Mockito.when(storage.getGoods("A")).thenReturn(itemA);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateTotalCost() {
        String order = "AAAA";
        double totalCost = groceryBin.calculateTotalCost(storage, order);
        assertEquals(4.25d,totalCost,0.01);

    }
}