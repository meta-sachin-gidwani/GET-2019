import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

	@Test
	public void transposeTest() {
		assertArrayEquals(new int[][]{{1, 3}, {2, 4}}, new SparseMatrix(
				new int[][]{{1, 2}, {3, 4}}).transpose());
		assertArrayEquals(new int[][]{{6, 3, 1}, {2, 10, 5}}, new SparseMatrix(
				new int[][]{{6, 2}, {3, 10}, {1, 5}}).transpose());
	}

	@Test
	public void symmetricalTest() {
		assertTrue(new SparseMatrix(new int[][]{{1, 2}, {2, 1}})
				.isSymmetrical());
		assertFalse(new SparseMatrix(new int[][]{{1, 3}, {2, 1}})
				.isSymmetrical());
	}

	@Test
	public void addMatrixTestWithoutError() {
		assertArrayEquals(new int[][]{{1, 3}, {2, 4}}, new SparseMatrix(
				          new int[][]{{0, 2}, {1, 2}}).addMatrix(new SparseMatrix(
				          new int[][]{{1, 1}, {1, 2}})));
		assertArrayEquals(new int[][]{{2, 4, 6}, {2, 3, 4}}, new SparseMatrix(
				          new int[][]{{1, 2, 3}, {1, 2, 3}}).addMatrix(new SparseMatrix(
				          new int[][]{{1, 2, 3}, {1, 1, 1}})));
	}

	@Test(expected = AssertionError.class)
	public void addMatrixTestWithError() {
		new SparseMatrix(new int[][]{{0, 2, 5}, {1, 2, 9}}).addMatrix(new SparseMatrix(new int[][]{{1, 1}, {1, 2}}));
	}

	@Test
	public void multiplyMatrixTestWithoutError() {
		assertArrayEquals(new int[][]{{2, 4}, {3, 5}}, new SparseMatrix(
				          new int[][]{{0, 2}, {1, 2}}).multiplyMatrix(new SparseMatrix(
				          new int[][]{{1, 1}, {1, 2}})));
		assertArrayEquals(new int[][]{{7, 11}}, new SparseMatrix(
				          new int[][]{{3, 4}}).multiplyMatrix(new SparseMatrix(
				          new int[][]{{1, 1}, {1, 2}})));
	}
	
	@Test(expected = AssertionError.class)
	public void multiplyMatrixTestWithError() {
		new SparseMatrix(new int[][]{{0, 2}, {1, 2}}).addMatrix(new SparseMatrix(new int[][]{{1, 1, 4}, {1, 2, 6}}));
	}

}
