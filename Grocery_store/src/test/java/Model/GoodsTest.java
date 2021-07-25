package Model;

import Storage.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class GoodsTest {

    private Storage storage = new GroceryStorage();


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetPrice() {
        Double itemPrice = storage.getGoods("A").getPrice();
        assertEquals(1.25d,itemPrice,0.001);
    }

    @Test
    public void testGetIsSaleable() {
        Boolean itemSaleable = storage.getGoods("A").getSaleable();
        assertTrue(itemSaleable);
    }

    @Test
    public void testGetDiscountQty() {
        int itemDiscountQty = storage.getGoods("A").getDiscountQty();
        assertEquals(3,itemDiscountQty);
    }

    @Test
    public void testGetDiscountPrice() {
        Double itemDiscountPrice = storage.getGoods("C").getDiscountPrice();
        assertEquals(5.0d,itemDiscountPrice,0.001);
    }
}