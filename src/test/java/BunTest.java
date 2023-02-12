import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

public class BunTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void getNameBunReturnsCorrectValue (){
        Bun bun = new Bun (database.availableBuns().get(1).getName(), database.availableBuns().get(1).getPrice());
        Assert.assertEquals(database.availableBuns().get(1).getName(), bun.getName());
    }
}
