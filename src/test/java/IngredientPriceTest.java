import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)
public class IngredientPriceTest {

    private Database database;

    private float price;

    public IngredientPriceTest(float price) {
        this.price = price;
    }

    @Before
    public void setUp() {
        database = new Database();
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
    public void getPriceIngredientReturnsCorrectValue (){
        Ingredient ingredient = new Ingredient (database.availableIngredients().get(5).getType(), database.availableIngredients().get(5).getName(), price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
}
