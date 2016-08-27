package ch03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by almer on 27/08/16.
 */
public class TestChapter03_01 {

    private Chapter03_01.ThreeInOne stack;

    @Before
    public void setUp() {
        this.stack = new Chapter03_01.ThreeInOne();
    }

    @After
    public void tearDown() {
        this.stack = null;
    }

    @Test
    public void isEmptyStackReturnsTrue() {
        assertTrue(this.stack.isEmpty0());
        assertTrue(this.stack.isEmpty1());
        assertTrue(this.stack.isEmpty2());
    }

    @Test
    public void sizeReturnsCorrectValuesForEachStack() {
        int targetSize0 = 5;
        int targetSize1 = 10;
        int targetSize2 = 15;

        for (int i = 0; i < targetSize0; i++) {
            stack.pushTo0(i + 1);
        }

        for (int i = 0; i < targetSize1; i++) {
            stack.pushTo1(i + 1);
        }

        for (int i = 0; i < targetSize2; i++) {
            stack.pushTo2(i + 1);
        }

        assertEquals("Stack 1 is expected to hold " + targetSize0 + " values", targetSize0, stack.size0());
        assertEquals("Stack 2 is expected to hold " + targetSize1 + " values", targetSize1, stack.size1());
        assertEquals("Stack 3 is expected to hold " + targetSize2 + " values", targetSize2, stack.size2());
    }

    @Test(expected = EmptyStackException.class)
    public void pushTo0popFrom0() {
        stack.pushTo0(1);
        stack.pushTo0(2);
        stack.pushTo0(3);

        // [1 2 3 - - - - - - - - -]

        assertEquals(3, stack.peekFrom0());
        assertEquals(3, stack.popFrom0());
        assertEquals(2, stack.peekFrom0());
        assertEquals(2, stack.popFrom0());
        assertEquals(1, stack.peekFrom0());
        assertEquals(1, stack.popFrom0());
        stack.popFrom0();
    }

    @Test(expected = EmptyStackException.class)
    public void pushTo1popFrom1() {
        stack.pushTo1(1);
        stack.pushTo1(2);
        stack.pushTo1(3);

        // [- - - - 1 2 3 - - - - -]

        assertEquals(3, stack.peekFrom1());
        assertEquals(3, stack.popFrom1());
        assertEquals(2, stack.peekFrom1());
        assertEquals(2, stack.popFrom1());
        assertEquals(1, stack.peekFrom1());
        assertEquals(1, stack.popFrom1());
        stack.popFrom1();
    }

    @Test(expected = EmptyStackException.class)
    public void pushTo2popFrom2() {
        stack.pushTo2(1);
        stack.pushTo2(2);
        stack.pushTo2(3);

        // [- - - - - - - - 1 2 3 - ]

        assertEquals(3, stack.peekFrom2());
        assertEquals(3, stack.popFrom2());
        assertEquals(2, stack.peekFrom2());
        assertEquals(2, stack.popFrom2());
        assertEquals(1, stack.peekFrom2());
        assertEquals(1, stack.popFrom2());
        stack.popFrom2();
    }
}
