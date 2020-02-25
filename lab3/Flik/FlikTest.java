import org.junit.Assert;
import org.junit.Test;

public class FlikTest {

    @Test
    public void testFlik() {

        int first = 127;
        int second = 127;
        Assert.assertTrue(Flik.isSameNumber(first, second));
    }
}
