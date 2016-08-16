package ch01;

import java.util.Arrays;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_01 {

    /**
     * O(NlogN) where N is a size of string s
     */
    boolean isUnique(String s) {
        if (s == null) {
            return false;
        } else if (s.length() <= 1) {
            return true;
        }

        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == chs[i-1]) {
                return false;
            }
        }
        return true;
    }
}
