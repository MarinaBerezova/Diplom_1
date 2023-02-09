import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private String item;

    public IngredientTypeTest(String item) {
        this.item = item;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void checkIngredientTypeListContainsItem (){
        List<IngredientType> ingredientTypes = new ArrayList<>(List.of(IngredientType.values()));
        boolean isFound = ingredientTypes.contains(IngredientType.valueOf(item));
        Assert.assertTrue(isFound);
    }
}
