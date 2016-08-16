package ch01;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_06 {

    String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(s.charAt(i - 1));
                sb.append(cnt);
                cnt = 1;
            }
        }
        sb.append(s.charAt(s.length() - 1));
        sb.append(cnt);

        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        Chapter01_06 ch = new Chapter01_06();
        System.out.println("a2b1c5a3 = " + ch.compress(s));

        s = "abcde";
        System.out.println("abcde = " + ch.compress(s));

        s = "a";
        System.out.println("a = " + ch.compress(s));
    }
}
