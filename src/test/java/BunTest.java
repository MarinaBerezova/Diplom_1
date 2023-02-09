import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameBunReturnsCorrectValue (){
        Bun bun = new Bun ("Любой простой продукт - 123", 10.10f);
        Assert.assertEquals("Любой простой продукт - 123", bun.getName());
    }
}
