package interview;

import static org.junit.Assert.*;

import org.junit.Test;

public class Quicksort {
	
	public static class QuicksortTest {
		
		public void sort(int[] arr) {
			
			doSort(arr, 0, arr.length);
			
		}
		
		private void doSort(int[] arr, int start, int end) {
			
		}


		@Test
		public void testSort() throws Exception {
			Quicksort fixture = new Quicksort();
			
			fixture.sort(new int[] {1, 2, 3});
			
			
		}
		
	}

}
