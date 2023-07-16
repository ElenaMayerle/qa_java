import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    @Before
    public void init(){

        MockitoAnnotations.openMocks(this);
    }
    private final String sex;
    private final String hasMane;

    @Mock
    static Feline feline;
    public LionTest(String sex, Feline feline, String hasMane){
    this.sex = sex;
    LionTest.feline = feline;
    this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"Самец", feline,"true"},
                {"Самка", feline,"false"},
                {"Оно",feline,"Используйте допустимые значения пола животного - самец или самка"}
        };

    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex,feline);
        Assert.assertEquals(hasMane,Boolean.toString(lion.doesHaveMane()));
    }
    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex,feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals("Неправильное количество котят",1,lion.getKittens());
    }
    @Test
    public void getFoodTest() throws Exception{
        Lion lion = new Lion(sex,feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Неправильная еда у льва",List.of("Животные", "Птицы", "Рыба"),lion.getFood());
    }

}
