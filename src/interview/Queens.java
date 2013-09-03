package interview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Queens {

	public List<List<Integer>> solve(int n) {
		ArrayList<Integer> solution = new ArrayList<Integer>();
		return solve(n, solution, new ArrayList<List<Integer>>());
	}
	
//	private boolean solve(int n, List<Integer> board) {
//		if (solved(n, board)) {
//			return true;
//		} else if (board.size() < n) {
//			for (int row=0; row<n; row++) {
//				if (!attacks(board, row)) {
//					board.add(row);
//					boolean solved = solve(n, board);
//					if (solved) {
//						return true;
//					} else {
//						board.remove(board.size()-1);
//					}
//				}
//			}
//		}

	private List<List<Integer>> solve(int n, List<Integer> board, List<List<Integer>> solutions) {
		if (solved(n, board)) {
			solutions.add(board);
		} else if (board.size() < n) {
			for (int row=0; row<n; row++) {
				if (!attacks(board, row)) {
					board.add(row);
					solve(n, board, solutions);
					board.remove(board.size() - 1);
				}
			}
		}
		return solutions;
	}
	
	private boolean attacks(List<Integer> board, int row) {
		if (board.contains(row)) {
			return true;
		} else {
			int y2 = row;
			int x2 = board.size();
			for (int x1 = 0; x1 < board.size(); x1++) {
				int y1 = board.get(x1);
				double slope = (double) (y2 - y1) / (x2 - x1);
				if (Math.abs(slope) == 1) {
					return true; 
				}
			}
			return false;
		}
	}

	private boolean solved(int n, List<Integer> board) {
		return n == board.size();
	}

	public static class QueensTest {
		
		@Test
		public void testN3HasNoSolution() throws Exception {
			assertEquals(0, new Queens().solve(3).size());
		}
		
		@Test
		public void testN4HasSolution() throws Exception {
			assertEquals(2, new Queens().solve(4).size());
		}
		
		@Test
		public void testN8HasSolution() throws Exception {
			assertEquals(92, new Queens().solve(8).size());
		}

		@Test
		public void testAttacks() throws Exception {
			Queens queens = new Queens();
			assertFalse(queens.attacks(Arrays.asList(1, 7, 5, 0), 2));
		}
		
	}
}
