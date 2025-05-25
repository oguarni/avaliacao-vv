import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {
    
    @Test
    void testSimplePalindrome() {
        assertTrue(PalindromeChecker.isPalindrome("ana"));
        assertTrue(PalindromeChecker.isPalindrome("arara"));
    }
    
    @Test
    void testPalindromeWithSpaces() {
        assertTrue(PalindromeChecker.isPalindrome("a man a plan a canal panama"));
    }
    
    @Test
    void testPalindromeWithMixedCase() {
        assertTrue(PalindromeChecker.isPalindrome("Ana"));
        assertTrue(PalindromeChecker.isPalindrome("RaDaR"));
    }
    
    @Test
    void testNonPalindrome() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("java"));
    }
    
    @Test
    void testEmptyString() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }
    
    @Test
    void testNullString() {
        assertThrows(IllegalArgumentException.class, 
            () -> PalindromeChecker.isPalindrome(null));
    }
    
    @Test
    void testSingleCharacter() {
        assertTrue(PalindromeChecker.isPalindrome("a"));
    }
}