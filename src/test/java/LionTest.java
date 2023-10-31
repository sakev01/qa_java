import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    private String sex;
    private boolean expectedMane;

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        //Arrange
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        // Assert
        assertEquals(expectedMane, lion.doesHaveMane());
    }


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

    @Test(expected = Exception.class)
    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
        Feline mockFeline = mock(Feline.class);
        new Lion("InvalidValue", mockFeline);
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
