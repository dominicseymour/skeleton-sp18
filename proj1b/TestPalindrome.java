import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(palindrome.isPalindrome("aabbcbbaa"));
        Assert.assertFalse(palindrome.isPalindrome("abcdefgh"));
    }

    @Test
    public void testIsPalindromeSingleCharacter() {
        Assert.assertTrue(palindrome.isPalindrome("a"));
        Assert.assertTrue(palindrome.isPalindrome("b"));
    }

    @Test
    public void testIsPalindromeEmptyString() {
        Assert.assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testOverloadedIsPalindrome() {

        OffByOne offByOne = new OffByOne();
        Assert.assertTrue(palindrome.isPalindrome("flake", offByOne));
        Assert.assertFalse(palindrome.isPalindrome("aabbcbbaa", offByOne));
    }

    @Test
    public void testOverloadedIsPalindromeSingleCharacter() {
        OffByOne offByOne = new OffByOne();
        Assert.assertTrue(palindrome.isPalindrome("a", offByOne));
        Assert.assertTrue(palindrome.isPalindrome("b", offByOne));
    }

    @Test
    public void testOverloadedIsPalindromeEmptyString() {
        OffByOne offByOne = new OffByOne();
        Assert.assertTrue(palindrome.isPalindrome("", offByOne));
    }
}
