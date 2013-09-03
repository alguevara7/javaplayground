package interview;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Fibonacci {

	public List<Integer> seriesTo(int n) {
		if (n == 0) {
			return new ArrayList<Integer>(asList(0));
		} else if (n == 1) {
			return new ArrayList<Integer>(asList(0, 1));
		} else {
			List<Integer> seriesToNMinus1 = seriesTo(n - 1);
			Integer next = seriesToNMinus1.get(seriesToNMinus1.size() - 1) + seriesToNMinus1.get(seriesToNMinus1.size() - 2);
			seriesToNMinus1.add(next);
			return seriesToNMinus1;
		}
	}

	public List<Integer> seriesToIter(int n) {
		List<Integer> fibSeq = new ArrayList<Integer>(n + 1);
		
		int fib1 = 0;
		fibSeq.add(fib1);
		
		int fib2 = 1;
		for (int i=1; i<=n; i++) {
			int tmp = fib2;
			fib2 = fib1 + fib2;
			fib1 = tmp;
			fibSeq.add(fib1);
		}
		return fibSeq;
	}
	
	public int nth(int n) {
		if (n==0 || n == 1) {
			return n;
		} else {
			return nth(n - 1) + nth(n - 2);
		}
	}
	
	public int nthIter(int n) {
		int fib1 = 0;
		int fib2 = 1;
		for (int i=1; i<=n; i++) {
			int tmp = fib2;
			fib2 = fib1 + fib2;
			fib1 = tmp;
		}
		return fib1;
	}
	
	public static class FibonacciTest {
		
		@Test
		public void testSeriesTo() throws Exception {
			Fibonacci fibonacci = new Fibonacci();
			
			assertEquals(asList(0), fibonacci.seriesTo(0));
			assertEquals(asList(0, 1), fibonacci.seriesTo(1));
			assertEquals(asList(0, 1, 1), fibonacci.seriesTo(2));
			assertEquals(asList(0, 1, 1, 2), fibonacci.seriesTo(3));
			assertEquals(asList(0, 1, 1, 2, 3), fibonacci.seriesTo(4));
			assertEquals(asList(0, 1, 1, 2, 3, 5), fibonacci.seriesTo(5));
			assertEquals(asList(0, 1, 1, 2, 3, 5, 8), fibonacci.seriesTo(6));
		}
		
		@Test
		public void testSeriesToIter() throws Exception {
			Fibonacci fibonacci = new Fibonacci();
			
			assertEquals(asList(0), fibonacci.seriesToIter(0));
			assertEquals(asList(0, 1), fibonacci.seriesToIter(1));
			assertEquals(asList(0, 1, 1), fibonacci.seriesToIter(2));
			assertEquals(asList(0, 1, 1, 2), fibonacci.seriesToIter(3));
			assertEquals(asList(0, 1, 1, 2, 3), fibonacci.seriesToIter(4));
			assertEquals(asList(0, 1, 1, 2, 3, 5), fibonacci.seriesToIter(5));
			assertEquals(asList(0, 1, 1, 2, 3, 5, 8), fibonacci.seriesToIter(6));
		}
		
		@Test
		public void testNth() throws Exception {
			Fibonacci fibonacci = new Fibonacci();
			
			assertEquals(0, fibonacci.nth(0));
			assertEquals(1, fibonacci.nth(1));
			assertEquals(1, fibonacci.nth(2));
			assertEquals(2, fibonacci.nth(3));
			assertEquals(3, fibonacci.nth(4));
			assertEquals(5, fibonacci.nth(5));
			assertEquals(8, fibonacci.nth(6));
		}

		@Test
		public void testNthIter() throws Exception {
			Fibonacci fibonacci = new Fibonacci();
			
			assertEquals(0, fibonacci.nthIter(0));
			assertEquals(1, fibonacci.nthIter(1));
			assertEquals(1, fibonacci.nthIter(2));
			assertEquals(2, fibonacci.nthIter(3));
			assertEquals(3, fibonacci.nthIter(4));
			assertEquals(5, fibonacci.nthIter(5));
			assertEquals(8, fibonacci.nthIter(6));
		}
		
	}


}
