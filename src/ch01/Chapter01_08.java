package ch01;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_08 {

    void zeroMatrix(int[][] m) {
        if (m == null) {
            return;
        }
        boolean[] rows = new boolean[m.length];
        boolean[] cols = new boolean[m.length > 0 ? m[0].length : 0];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (m[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (rows[i] || cols[j]) {
                    m[i][j] = 0;
                }
            }
        }
    }
}
