package ch01;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_05 {

    boolean isOneAway(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        if (s.equals(t)) {
            return true;
        }

        // TODO: 16/08/16 Implement

        return false;
    }
}
