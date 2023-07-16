import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;
    @Test
    public void eatMeatTest() throws Exception{
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Неправильная еда у кошачьих", List.of("Животные", "Птицы", "Рыба"),actual);
    }
    @Test
    public void getFamilyTest(){
        Feline feline = new Feline();
        Assert.assertEquals("Неправильное название семейства", "Кошачьи", feline.getFamily());
    }
    @Test
    public void getKittensWithParamTest(){
        int kittensCount = 2;
        Assert.assertEquals("Неправильное количество котят", kittensCount,feline.getKittens(kittensCount));
    }
    @Test
    public void getKittensTest(){
    feline.getKittens();
    Mockito.verify(feline,Mockito.times(1)).getKittens(1);
    }
}
