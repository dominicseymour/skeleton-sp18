import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {

        Assert.assertTrue(offByOne.equalChars('a', 'b'));
        Assert.assertTrue(offByOne.equalChars('r', 'q'));
        Assert.assertTrue(offByOne.equalChars('u', 'v'));

        Assert.assertFalse(offByOne.equalChars('a', 'e'));
        Assert.assertFalse(offByOne.equalChars('z', 'a'));
        Assert.assertFalse(offByOne.equalChars('a', 'a'));
    }
}
