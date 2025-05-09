import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;

public class TestCat {

    Feline feline = new Feline();
    Cat cat = new Cat(feline);

    @Test
    public void testCatSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatFood() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

}
