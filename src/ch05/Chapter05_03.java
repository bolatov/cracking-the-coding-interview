package ch05;

/**
 * Created by almer on 04/09/16.
 */
public class Chapter05_03 {

    static int flipBitToWinBruteForce(int n) {
        int mxCnt = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((n & (1 << i)) <= 0) {
                int cnt = 1;
                for (int j = i + 1; j < Integer.SIZE && (n & (1 << j)) > 0; j++) {
                    cnt++;
                }
                for (int j = i - 1; j >= 0 && (n & (1 << j)) > 0; j--) {
                    cnt++;
                }
                mxCnt = Math.max(cnt, mxCnt);
            }
        }
        return mxCnt > 0 ? mxCnt : Integer.SIZE;
    }

    static int flipBitToWinLinear(int n) {
        int mxCnt = 0;
        int pos = -1, offset = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((n & (1 << i)) <= 0) {
                offset = i - pos;
                pos = i;
            }
            mxCnt = Math.max(mxCnt, i - pos + offset);
        }

        return mxCnt > 0 ? mxCnt : Integer.SIZE;
    }
}
