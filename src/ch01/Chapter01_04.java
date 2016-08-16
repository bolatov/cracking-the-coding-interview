package ch01;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_04 {

    boolean isPalindromePermutation(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String argument is null");
        }

        if (s.length() <= 1) {
            return true;
        }

        s = s.toLowerCase();
        char[] bucket = new char[256];
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                bucket[ch]++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] % 2 == 1) {
                cnt++;
            }
        }
        return !(cnt > 1);
    }

    public static void main(String[] args) {
        String s = "Tact Coa";
        Chapter01_04 ch = new Chapter01_04();
        System.out.println(ch.isPalindromePermutation(s));
    }
}
