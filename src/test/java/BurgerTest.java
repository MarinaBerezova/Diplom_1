import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun1;

    @Mock
    Bun bun2;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Mock
    Ingredient ingredient3;

    @Mock
    Ingredient ingredient4;

    @Spy
    private Burger burger1 = new Burger();

    @Test
    public void createNewBurgerBunIsNull(){
        Burger burger = new Burger();
        Assert.assertNull(burger.bun);
    }

    @Test
    public void createNewBurgerIngredientsListIsEmpty(){
        Burger burger = new Burger();
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void setBunsBurgerAddBurgerBunValue(){
        Burger burger = new Burger();
        burger.setBuns(bun1);
        Assert.assertEquals(bun1, burger.bun);
    }

    @Test
    public void setBunsBurgerUpdateBurgerBunValue(){
        Burger burger = new Burger();
        burger.setBuns(bun1);
        burger.setBuns(bun2);
        Assert.assertEquals(bun2, burger.bun);
    }

    @Test
    public void addIngredientBurgerUpdateEmptyIngredientsList(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void addIngredientBurgerUpdateNotEmptyIngredientsList(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient3);
        burger.ingredients.add(ingredient4);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(ingredient2, burger.ingredients.get(3));
    }

    @Test
    public void addIngredientBurgerAddDoubleIngredient(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient3);
        Assert.assertEquals(ingredient3, burger.ingredients.get(0));
        Assert.assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientBurgerRemoveFirstIngredient(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient4);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(0);
        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertEquals(ingredient4, burger.ingredients.get(0));
        Assert.assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientBurgerRemoveLastIngredient(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient4);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(2);
        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
        Assert.assertEquals(ingredient4, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientBurgerRemoveMiddleIngredient(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient4);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(1);
        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertEquals(ingredient1, burger.ingredients.get(0));
        Assert.assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientBurgerRemoveSingleIngredient(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientBurgerTwoIngredientsInList(){
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
    }
/*
    @Test
    public void getPriceBurgerReturnZeroPriceForEmptyBurger(){
        Burger burger = new Burger();
        Assert.assertEquals(0, burger.getPrice(), 0);
    }
*/
    @Test
    public void getPriceBurgerShouldMultiplyBunPrice(){
        Burger burger = new Burger();
        burger.bun = bun1;
        Mockito.when(bun1.getPrice()).thenReturn(10.50f);
        Assert.assertEquals(21f, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBurgerShouldSumBunAndIngredientPrice(){
        Burger burger = new Burger();
        burger.bun = bun1;
        burger.ingredients.add(ingredient1);
        Mockito.when(bun1.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        Assert.assertEquals(250f, burger.getPrice(), 0);
    }

    @Test
    public void getPriceBurgerShouldCalcPriceWhenManyIngredients(){
        Burger burger = new Burger();
        burger.bun = bun1;
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient4);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient3);
        Mockito.when(bun1.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        Mockito.when(ingredient4.getPrice()).thenReturn(999.90f);
        Mockito.when(ingredient3.getPrice()).thenReturn(0.10f);
        Assert.assertEquals(1300f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptBurgerReturnBun(){
        burger1.bun = bun1;
        Mockito.when(bun1.getName()).thenReturn("Тостовый хлеб");
        Mockito.when(burger1.getPrice()).thenReturn(200f);
        String expected = String.format("(==== Тостовый хлеб ====)%n(==== Тостовый хлеб ====)%n%nPrice: 200,000000%n");
        Assert.assertEquals(expected, burger1.getReceipt());
    }

    @Test
    public void getReceiptBurgerReturnIngredient(){
        burger1.bun = bun1;
        burger1.ingredients.add(ingredient1);
        Mockito.when(bun1.getName()).thenReturn("Тостовый хлеб");
        Mockito.when(ingredient1.getName()).thenReturn("Коктейльный соус");
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(burger1.getPrice()).thenReturn(2220f);
        String expected = String.format("(==== Тостовый хлеб ====)%n= sauce Коктейльный соус =%n(==== Тостовый хлеб ====)%n%nPrice: 2220,000000%n");
        Assert.assertEquals(expected, burger1.getReceipt());
    }

    @Test
    public void getReceiptBurgerReturnManyIngredients(){
        burger1.bun = bun1;
        burger1.ingredients.add(ingredient1);
        burger1.ingredients.add(ingredient2);
        burger1.ingredients.add(ingredient3);
        Mockito.when(bun1.getName()).thenReturn("Тостовый хлеб");
        Mockito.when(ingredient1.getName()).thenReturn("Коктейльный соус");
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("Овощи микс");
        Mockito.when(ingredient2.getType()).thenReturn(FILLING);
        Mockito.when(ingredient3.getName()).thenReturn("Котлета 1");
        Mockito.when(ingredient3.getType()).thenReturn(FILLING);
        Mockito.when(burger1.getPrice()).thenReturn(2220f);
        String expected = String.format("(==== Тостовый хлеб ====)%n= sauce Коктейльный соус =%n= filling Овощи микс =%n= filling Котлета 1 =%n(==== Тостовый хлеб ====)%n%nPrice: 2220,000000%n");
        Assert.assertEquals(expected, burger1.getReceipt());
    }
/*
    @Test
    public void getReceiptBurgerReturnPriceInPriceFormatInReceipt(){
        burger1.bun = bun1;
        Mockito.when(bun1.getName()).thenReturn("Тостовый хлеб");
        Mockito.when(burger1.getPrice()).thenReturn(100.95f);
        String expected = String.format("(==== Тостовый хлеб ====)%n(==== Тостовый хлеб ====)%n%nPrice: 100.95%n");
        Assert.assertEquals(expected, burger1.getReceipt());
    }

 */

}
