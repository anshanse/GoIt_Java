package Storage;

import Model.Goods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroceryStorageTest {
    Storage <String>storage = new GroceryStorage();
    Goods itemA = Goods.builder().id("A").saleable(true).price(1.25d).discountQty(3).discountPrice(3.0d).build();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getGoods() {
        Goods storageGoods = storage.getGoods("A");
        assertEquals(itemA,storageGoods);
    }
}