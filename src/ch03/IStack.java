package ch03;

/**
 * Created by almer on 27/08/16.
 */
public interface IStack<T> {

    T pop();

    void push(T item);

    T peek();

    boolean isEmpty();
}
