package ch03;

import java.util.EmptyStackException;

/**
 * Created by almer on 24/08/16.
 */
public class MyStack<T> implements IStack<T> {

    private static class StackNode<T> {
        private T data;

        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    private int size = 0;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        size++;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}
