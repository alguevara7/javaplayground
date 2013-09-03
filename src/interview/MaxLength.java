package interview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaxLength {
	//find the maximum length of consecutive ones in a nxm matrix which has only 0's and 1's.
	
	public int maxLength(int[][] matrix) {
		int max = 0;
		
		int len = 0;
		for (int i = 0; i < matrix.length; i++) {
			int[] col = matrix[i];
			for (int j = 0; j < col.length; j++) {
				int value = col[j];
				if (value == 1) {
					len = len + 1;
					if (len > max) {
						max = len;
					}
				} else {
					len = 0;
				}
			}
		}
		return max;
	}
	
	public static class MaxLengthTest {
		private MaxLength fixture;

		@Before
		public void setUp() {
			fixture = new MaxLength();
		}
		
		@Test
		public void testMaxLengthSameRow() throws Exception {
			assertEquals(3, fixture.maxLength(new int[][] {
					{1, 1, 0},
					{0, 0, 0},
					{1, 1, 1}}));
		}

		
		@Test
		public void testMaxLengthSpanRow() throws Exception {
			assertEquals(6, fixture.maxLength(new int[][] {
					{1, 1, 1, 1, 1},
					{0, 0, 0, 1, 1},
					{1, 1, 1, 1, 0}}));
		}
		
	}
	
	
}
