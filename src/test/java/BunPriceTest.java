import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

@RunWith(Parameterized.class)
public class BunPriceTest {

    private float price;
    private Database database;

    public BunPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {22222.99f},
                {8888},
                {321.3f},
                {98.80f},
                {8},
                {0.01f},
                {0.90f},
                {0},
        };
    }

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void getPriceBunReturnsCorrectValue (){
        Bun bun = new Bun (database.availableBuns().get(0).getName(), price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
