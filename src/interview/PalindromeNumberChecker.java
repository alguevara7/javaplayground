package interview;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromeNumberChecker {
	
	public boolean isPalindrome(long number) {
		long reverse = 0;
		
		long temp = number;
		while (temp > 0) {
			reverse = reverse * 10;
			reverse = reverse + (temp % 10);
			temp = temp / 10;
		}
		
		return number == reverse;
	}
		
	public static class PalindromeNumberCheckerTest {
		
		@Test
		public void testIsPalindrome() throws Exception {
			PalindromeNumberChecker checker = new PalindromeNumberChecker ();

			assertTrue(checker.isPalindrome(0));
			assertTrue(checker.isPalindrome(1));
			assertFalse(checker.isPalindrome(10));
			assertTrue(checker.isPalindrome(101));
			assertTrue(checker.isPalindrome(50505));

		}
		
	}

}


