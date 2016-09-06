package ch03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by almer on 27/08/16.
 */
public class TestChapter03_05 {

    @Test
    public void testSortStackWithSequentialInts() {
        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        testIfSorted(stack);
    }

    void testIfSorted(MyStack<Integer> stack) {
        Chapter03_05.sort(stack);
        List<Integer> lst = new ArrayList<>();
        while (!stack.isEmpty()) {
            lst.add(stack.pop());
        }
        for (int i = 1; i < lst.size(); i++) {
            assertTrue(lst.get(i) >= lst.get(i - 1));
        }
    }

    @Test
    public void testSortStackWithRandomInts() {
        MyStack<Integer> stack = new MyStack<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            stack.push(random.nextInt());
        }
        testIfSorted(stack);
    }
}
