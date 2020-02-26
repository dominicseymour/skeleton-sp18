import org.junit.Assert;
import org.junit.Test;

public class TestOffByN {

    @Test
    public void testEqualChars() {

        CharacterComparator offBy1 = new OffByN(1);
        Assert.assertTrue(offBy1.equalChars('a', 'b'));

        CharacterComparator offBy2 = new OffByN(2);
        Assert.assertTrue(offBy2.equalChars('p', 'r'));

        CharacterComparator offBy3 = new OffByN(3);
        Assert.assertTrue(offBy3.equalChars('d', 'g'));

        CharacterComparator offBy4 = new OffByN(4);
        Assert.assertTrue(offBy4.equalChars('l', 'p'));

        CharacterComparator offBy5 = new OffByN(5);
        Assert.assertTrue(offBy5.equalChars('c', 'h'));
    }
}
