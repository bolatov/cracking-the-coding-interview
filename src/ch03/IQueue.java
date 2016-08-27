package ch03;

/**
 * Created by almer on 27/08/16.
 */
public interface IQueue<T> {

    void add(T item);

    T remove();

    boolean isEmpty();

    T peek();
}
