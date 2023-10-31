import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

 @Test
 public void testEatMeatReturnsCorrectFoodForPredator() throws Exception {
     // Arrange
     Feline feline = new Feline();
     List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");

     // Act
     List<String> actualFoodList = feline.eatMeat();

     // Assert
     assertEquals(expectedFoodList, actualFoodList);
 }

    @Test
    public void testGetFamilyReturnsCorrectFamily() {
        // Arrange
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        // Act
        String actualFamily = feline.getFamily();

        // Assert
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensReturnsCorrectKittenCount() {
        // Arrange
        Feline feline = new Feline();
        int expectedKittensCount = 1;

        // Act
        int actualKittensCount = feline.getKittens();

        // Assert
        assertEquals(expectedKittensCount, actualKittensCount);
    }
    @Test(expected = Exception.class)
    public void testGetFoodThrowsExceptionForUnknownAnimalKind() throws Exception {
        // Arrange
        Feline feline = new Feline();

        // Act
        feline.getFood("Unknown");
    }
}
