import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun {index} -> Name: {0}, Price:{1} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"black bun", ThreadLocalRandom.current().nextInt(1, 1001)},
                {"white bun", ThreadLocalRandom.current().nextInt(1, 1001)},
                {"red bun", ThreadLocalRandom.current().nextInt(1, 1001)}
        };
    }

    @Test
    public void getNameReturnedValidName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnedValidPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("С ценой что-то не так!", price, bun.getPrice(), 0.0f);
    }
}