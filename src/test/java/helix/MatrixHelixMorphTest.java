package helix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {
    private static boolean testEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            return matrix1 == null && matrix2 == null;
        }
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void test(int[][] in, int[][] out) {
        assertTrue(testEqual(out, MatrixHelixMorph.helix(in)));
    }

    @Test
    public void testNull() {
        test(null, null);
    }

    @Test
    public void test1x1() {
        int[][] m = { { 1 } };
        test(m, m);
    }

    @Test
    public void test1x3() {
        int[][] m = { { 1, 2, 3 } };
        test(m, m);
    }

    @Test
    public void test3x1() {
        int[][] m = { { 1 }, { 2 }, { 3 } };
        test(m, m);
    }

    @Test
    public void test2x2() {
        int[][] in = { { 1, 2 }, { 3, 4 } };
        int[][] out = { { 1, 2 }, { 4, 3 } };
        test(in, out);
    }

    @Test
    public void test2x3() {
        int[][] in = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] out = { { 1, 2, 3 }, { 6, 5, 4 } };
        test(in, out);
    }

    @Test
    public void test3x2() {
        int[][] in = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] out = { { 1, 2 }, { 6, 3 }, { 5, 4 } };
        test(in, out);
    }

    @Test
    public void test3x3() {
        int[][] in = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] out = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        test(in, out);
    }

    @Test
    public void test4x4() {
        int[][] in = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[][] out = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
        test(in, out);
    }

    @Test
    public void test4x5() {
        int[][] in = {
                { 1,  2,  3,  4,  5 },
                { 6,  7,  8,  9,  10},
                { 11, 12, 13, 14, 15},
                { 16, 17, 18, 19, 20},
        };
        int[][] out = {
                {1,  2,  3,  4,  5},
                {14, 15, 16, 17, 6},
                {13, 20, 19, 18, 7},
                {12, 11, 10, 9,  8},
        };
        test(in, out);
    }
}
