import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private String sex;
    private boolean expectedMane;

    public LionParametrizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
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
}
