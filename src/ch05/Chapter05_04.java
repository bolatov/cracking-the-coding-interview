package ch05;

/**
 * Created by almer on 05/09/16.
 */
public class Chapter05_04 {

    static int nextLargestBruteForce(int n) {
        int bitCount = Integer.bitCount(n);
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (Integer.bitCount(i) == bitCount) {
                return i;
            }
        }
        return n;
    }

    static int nextSmallestBruteForce(int n) {
        int bitCount = Integer.bitCount(n);
        for (int i = n - 1; i >= 0; i--) {
            if (Integer.bitCount(i) == bitCount) {
                return i;
            }
        }
        return n;
    }

    static int nextLargestClever(int n) {
//        int lowestBitSet = -1;
//        for (int i = 0; i < Integer.SIZE; i++) {
//            if ((n & (1 << i)) > 0) {
//                lowestBitSet = i;
//                break;
//            }
//        }
//        if (lowestBitSet < 0) {
//            return n;
//        }
//        for (int i = lowestBitSet + 1; i < Integer.SIZE; i++) {
//            if ((n & (1 << i)) == 0) {
//                n |= 1 << i;
//                n ^= 1 << lowestBitSet;
//                return n;
//            }
//        }
        return n;
    }

//    static int nextSmallestClever(int n) {
//
//    }
}
