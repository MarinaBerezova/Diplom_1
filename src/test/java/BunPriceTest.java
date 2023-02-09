import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunPriceTest {

    private float price;

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

    @Test
    public void getPriceBunReturnsCorrectValue (){
        Bun bun = new Bun ("Любой простой продукт - 123", price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
