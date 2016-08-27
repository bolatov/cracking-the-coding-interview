package ch03;

import java.util.EmptyStackException;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter03_01 {

    static class ThreeInOne {
        private Object[] arr = new Object[3];
        private int len0;
        private int len1;
        private int len2;

        private void resize() {
            Object[] tmp = new Object[arr.length * 2];
            System.arraycopy(arr, 0, tmp, 0, getBoundary(0, arr.length));
            System.arraycopy(arr, getBoundary(0, arr.length), tmp, getBoundary(0, tmp.length), len1);
            System.arraycopy(arr, getBoundary(1, arr.length), tmp, getBoundary(1, tmp.length), len2);
            this.arr = tmp;
        }

        private int getBoundary(int i, int length) {
            if (i == 0) {
                return length / 3;
            } else if (i == 1) {
                return (length / 3) * 2;
            } else {
                return length;
            }
        }

        public Object popFrom0() {
            if (len0 == 0) {
                throw new EmptyStackException();
            }
            return arr[--len0];
        }

        public void pushTo0(Object obj) {
            if (len0 >= getBoundary(0, arr.length)) {
                resize();
            }
            arr[len0++] = obj;
        }

        public Object peekFrom0() {
            if (len0 <= 1) {
                throw new EmptyStackException();
            }
            return arr[len0 - 1];
        }

        public boolean isEmpty0() {
            return len0 == 0;
        }

        public int size0() {
            return len0;
        }

        public Object popFrom1() {
            if (len1 == 0) {
                throw new EmptyStackException();
            }
            return arr[getBoundary(0, arr.length) + --len1];
        }

        public void pushTo1(Object obj) {
            if (getBoundary(0, arr.length) + len1 >= getBoundary(1, arr.length)) {
                resize();
            }
            arr[getBoundary(0, arr.length) + len1++] = obj;
        }

        public Object peekFrom1() {
            if (len1 <= 0) {
                throw new EmptyStackException();
            }
            return arr[getBoundary(0, arr.length) + len1 - 1];
        }

        public boolean isEmpty1() {
            return len1 == 0;
        }

        public int size1() {
            return len1;
        }

        public Object popFrom2() {
            if (len2 <= 0) {
                throw new EmptyStackException();
            }
            return arr[getBoundary(1, arr.length) + --len2];
        }

        public void pushTo2(Object obj) {
            if (getBoundary(1, arr.length) + len2 >= getBoundary(2, arr.length)) {
                resize();
            }
            arr[getBoundary(1, arr.length) + len2++] = obj;
        }

        public Object peekFrom2() {
            if (len2 <= 0) {
                throw new EmptyStackException();
            }
            return arr[getBoundary(1, arr.length) + len2 - 1];
        }

        public boolean isEmpty2() {
            return len2 == 0;
        }

        public int size2() {
            return len2;
        }
    }
}
