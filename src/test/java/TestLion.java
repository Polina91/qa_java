import com.example.Family;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class TestLion {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    String sex;
    Boolean expectedState;

    @Mock
    Family family;


    public TestLion(String sex, Boolean expectedState) {
        this.sex = sex;
        this.expectedState = expectedState;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionMavenStateCorrect() throws Exception {
        Lion lion = new Lion(family, sex);
        Boolean actualState = lion.doesHaveMane();
        Assert.assertEquals(actualState, expectedState);
    }

    @Test
    public void testLionFood() throws Exception {
        Lion lion = new Lion(family, sex);
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(family.getFood()).thenReturn(expectedFoodList);
        Assert.assertEquals(expectedFoodList, lion.getFood());
    }

    @Test
    public void testLionFamily() throws Exception {
        Lion lion = new Lion(family, sex);
        Mockito.when(lion.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals("Кошачьи", lion.getFamily());
    }

    @Test
    public void testLionKittens() throws Exception {
        Lion lion = new Lion(family, sex);
        lion.getKittens();
        Mockito.verify(family, Mockito.times(1)).getYoungs();
    }

    @Test
    public void testLionSexException() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion(family, "");
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void testLionFoodException() throws Exception {
        Mockito.when(family.getFood()).thenThrow(new Exception("Ошибка получения еды"));
        Lion lion = new Lion(family, "Самец");
        Exception exception = Assert.assertThrows(Exception.class, lion::getFood);
        Assert.assertEquals("Ошибка получения еды", exception.getMessage());
    }
}
