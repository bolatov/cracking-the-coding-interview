package ch03;

import java.util.NoSuchElementException;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter03_04 {

    static class MyOwnQueue<T> implements IQueue<T> {

        private IStack<T> iStack;

        private IStack<T> jStack;

        public MyOwnQueue() {
            this.iStack = new MyStack<>();
            this.jStack = new MyStack<>();
        }

        @Override
        public void add(T item) {
            this.iStack.push(item);
        }

        @Override
        public T remove() {
            move(iStack, jStack);
            T item = jStack.pop();
            move(jStack, iStack);
            return item;
        }

        @Override
        public boolean isEmpty() {
            return iStack.isEmpty();
        }

        @Override
        public T peek() {
            move(iStack, jStack);
            T item = jStack.peek();
            move(jStack, iStack);
            return item;
        }

        private void move(IStack<T> src, IStack<T> dst) {
            if (src.isEmpty()) {
                throw new NoSuchElementException();
            }

            while (!src.isEmpty()) {
                dst.push(src.pop());
            }
        }
    }
}
