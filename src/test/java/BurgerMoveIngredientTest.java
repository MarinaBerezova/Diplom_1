import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class BurgerMoveIngredientTest {

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Mock
    Ingredient ingredient3;

    @Mock
    Ingredient ingredient4;

    @Mock
    Ingredient ingredient5;

    private int newIndex;

    public BurgerMoveIngredientTest(int newIndex) {
        this.newIndex = newIndex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0},
                {1},
                {3},
                {4},
        };
    }

    @Test
    public void moveIngredientBurgerSuccess() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient4);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.ingredients.add(ingredient5);
        burger.moveIngredient(2, newIndex);
        Assert.assertEquals(ingredient2, burger.ingredients.get(newIndex));
        Assert.assertEquals(5, burger.ingredients.size());

    }
}
