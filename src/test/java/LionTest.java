import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LionTest {

    @Test
    public void testGetKittensMock() throws Exception {
        //Arrange
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", mockFeline);
        int expectedResult = 1;
        //Act
        int actualResult = lion.getKittens();
        // Assert
        assertEquals(expectedResult, actualResult);
    }

//    @Test(expected = Exception.class)
//    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
//        Feline mockFeline = mock(Feline.class);
//        new Lion("InvalidValue", mockFeline);
//    }

    @Test
    public void testLionConstructorThrowsExceptionForInvalidSex() {
        Feline mockFeline = mock(Feline.class);
        try {
            new Lion("InvalidValue", mockFeline);
            fail("Expected an Exception to be thrown"); // Если исключение не было выброшено, тест должен упасть
        } catch (Exception e) {
            // Здесь проверяется сообщение исключения
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }


    @Test
    public void testGetFoodReturnsCorrectFoodList() throws Exception {
        // Arrange
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFoodList = Arrays.asList("Животные", "Птицы", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFoodList);
        Lion lion = new Lion("Самец", mockFeline);
        // Act
        List<String> actualFoodList = lion.getFood();
        // Assert
        assertEquals(expectedFoodList, actualFoodList);
    }
}
