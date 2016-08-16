package ch01;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_03 {

    void URLify(char[] s, int len) {
        boolean is = false;
        int n = s.length - 1;
        for (int i = n; i >= 0 && n >= 0; --i) {
            if (!is && s[i] == ' ') {
                continue;
            }
            is = true;
            if (s[i] == ' ') {
                s[n--] = '0';
                s[n--] = '2';
                s[n--] = '%';
            } else {
                s[n--] = s[i];
            }
        }
    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        char[] chs = s.toCharArray();
        Chapter01_03 ch = new Chapter01_03();
        ch.URLify(chs, 13);
        String t = new String(chs);
        System.out.println("'" + t + "'");
    }
}
