package ch03;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter03_03 {

    static class SetOfStacks<T> {

        private List<MyStack<T>> stacks;

        private final int threshold;

        public SetOfStacks(int threshold) {
            this.stacks = new ArrayList<>();
            this.threshold = threshold;
        }

        public T pop() {
            MyStack<T> active = getActiveStack();
            T item = active.pop();
            if (active.isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }
            return item;
        }

        public  void push(T item) {
            MyStack<T> active = getActiveStack();
            if (active.getSize() >= threshold) {
                active = new MyStack<>();
                stacks.add(active);
            }
            active.push(item);
        }

        private MyStack<T> getActiveStack() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stacks.get(stacks.size() - 1);
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stacks.get(stacks.size() - 1).peek();
        }

        public boolean isEmpty() {
            return stacks.isEmpty();
        }

        public T popAt(int i) {
            if (i >= stacks.size()) {
                throw new EmptyStackException();
            }

            MyStack<T> stack = stacks.get(i);
            T item = stack.pop();
            if (stack.isEmpty()) {
                for (int j = i; j < stacks.size() - 1; j++) {
                    stacks.set(j, stacks.get(j + 1));
                }
                stacks.remove(stacks.size() - 1);
            }
            return item;
        }
    }
}
