package ch05;

/**
 * Created by almer on 29/08/16.
 */
public class Chapter05_01 {

    static int insert(int n, int m, int i, int j) {
        if (j < i) {
            throw new IllegalArgumentException("j must be greater than i");
        }
        for (int k = 0; i <= j; i++, k++) {
            // clear bit i in n
            int mask = ~(1 << i);
            n &= mask;

            // set bit i in n
            int value = (m & (1 << k)) > 0 ? 1 : 0;
            n |= (value << i);
        }
        return n;
    }

    static int insert2(int n, int m, int i, int j) {
        if (j < i) {
            throw new IllegalArgumentException("j must be greater than i");
        }
        for (int k = 0; i <= j; i++, k++) {
            boolean bitIs1 = (m & (1 << k)) > 0;
            n = Util.updateBit(n, i, bitIs1);
        }
        return n;
    }

    public static void main(String[] args) {
        int n = 0b10000000000;
        int m = 0b10011;
        System.out.println("n: " + Integer.toBinaryString(n));
        System.out.println("m: " + Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(insert(n, m, 2, 6)).equals(Integer.toBinaryString(insert2(n, m, 2, 6))));
    }
}
