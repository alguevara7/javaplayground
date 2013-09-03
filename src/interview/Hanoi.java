package interview;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Hanoi {
	
	public void solve(int n, String from, String to, String via, List<String> solution) {
		if (n > 0) {
			solve(n - 1, from, via, to, solution);
			solution.add(String.format("Move DISK from %s to %s", from, to));
			solve(n - 1, via, to, from, solution);
		}
	}
	
	public static class HanoiTest {
		
		@Test
		public void test1Disk() throws Exception {
			List<String> solution = new ArrayList<String>();
			new Hanoi().solve(1, "A", "B", "C", solution);
			assertEquals(1, solution.size());
			
			assertEquals(solution.get(0), "Move DISK from A to B");
		}

		@Test
		public void test2Disks() throws Exception {
			List<String> solution = new ArrayList<String>();
			new Hanoi().solve(2, "A", "B", "C", solution);
			assertEquals(3, solution.size());
			
			assertEquals(solution.get(0), "Move DISK from A to C");
			assertEquals(solution.get(1), "Move DISK from A to B");
			assertEquals(solution.get(2), "Move DISK from C to B");
		}
		
	}

}
