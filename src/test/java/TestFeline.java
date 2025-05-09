import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {

    @Spy
    Feline feline;

    @Test
    public void testFelineFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testFelineGetFood() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood());
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testFelineYoungs() {
        feline.getYoungs();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testFelineKittensCount() {
        Assert.assertEquals(1, feline.getKittens(1));
    }

}


