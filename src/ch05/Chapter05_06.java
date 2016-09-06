package ch05;

/**
 * Created by almer on 05/09/16.
 */
public class Chapter05_06 {

    static int conversion(int a, int b) {
        int c = a ^ b;
        return Integer.bitCount(c);
    }
}
