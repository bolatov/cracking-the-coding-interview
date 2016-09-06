package ch03;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter03_05 {

    static void sort(MyStack<Integer> s) {
        MyStack<Integer> t = new MyStack<>(); // temporary stack
        int i; // variable for temporary integer;
        while (true) {
            while (!s.isEmpty() &&
                    (t.isEmpty() || t.peek() < s.peek())) {
                t.push(s.pop());
            }

            // Stack is sorted!
            if (s.isEmpty()) {
                while (!t.isEmpty()) {
                    s.push(t.pop());
                }
                return;
            }

            i = s.pop();
            while (!t.isEmpty() && t.peek() > i) {
                s.push(t.pop());
            }
            t.push(i);
        }
    }
}
