package ch05;

/**
 * Created by almer on 05/09/16.
 */
public class Chapter05_05 {

    /**
     * Debugger checks if integer n is a power of 2
     * @param n
     * @return
     */
    static boolean debugger(int n) {
        return (n & (n - 1)) == 0;
    }
}
