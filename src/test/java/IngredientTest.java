import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Database;
import praktikum.Ingredient;

public class IngredientTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void getNameIngredientReturnsCorrectValue (){
        Ingredient ingredient = new Ingredient (database.availableIngredients().get(3).getType(), database.availableIngredients().get(3).getName(), database.availableIngredients().get(3).getPrice());
        Assert.assertEquals(database.availableIngredients().get(3).getName(), ingredient.getName());
    }

    @Test
    public void getTypeIngredientReturnsCorrectValue (){
        Ingredient ingredient1 = new Ingredient (database.availableIngredients().get(3).getType(), database.availableIngredients().get(3).getName(), database.availableIngredients().get(3).getPrice());
        Ingredient ingredient2 = new Ingredient (database.availableIngredients().get(0).getType(), database.availableIngredients().get(0).getName(), database.availableIngredients().get(0).getPrice());
        Assert.assertEquals(database.availableIngredients().get(3).getType(), ingredient1.getType());
        Assert.assertEquals(database.availableIngredients().get(0).getType(), ingredient2.getType());
    }
}
