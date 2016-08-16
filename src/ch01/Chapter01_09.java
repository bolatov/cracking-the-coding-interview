package ch01;

/**
 * Created by almer on 16/08/16.
 */
public class Chapter01_09 {

    boolean isSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        return s1.contains(s2);
    }

    boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        return isSubstring(s2 + s2, s1);
    }

    public static void main(String[] args) {
        Chapter01_09 ch = new Chapter01_09();
        System.out.println(ch.isRotation("waterbottle", "erbottlewat"));
    }
}
