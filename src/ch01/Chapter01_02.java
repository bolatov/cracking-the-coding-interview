package ch01;

import java.util.Arrays;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_02 {

    /**
     * O(NlogN) solution.
     */
    boolean checkPermutation(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != cht[i]) {
                return false;
            }
        }
        return true;
    }
}
