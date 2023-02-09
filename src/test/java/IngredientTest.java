import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void getNameIngredientReturnsCorrectValue (){
        Ingredient ingredient = new Ingredient (FILLING, "Любой простой продукт - 123", 10.10f);
        Assert.assertEquals("Любой простой продукт - 123", ingredient.getName());
    }

    @Test
    public void getTypeIngredientReturnsCorrectValue (){
        Ingredient ingredient1 = new Ingredient (FILLING, "Любой простой продукт - 123", 10.10f);
        Ingredient ingredient2 = new Ingredient (SAUCE, "Любой простой продукт - 123", 10.10f);
        Assert.assertEquals(FILLING, ingredient1.getType());
        Assert.assertEquals(SAUCE, ingredient2.getType());
    }
}
