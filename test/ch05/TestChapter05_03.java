package ch05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by almer on 04/09/16.
 */
public class TestChapter05_03 {

    @Test
    public void testFlipBitToWin() {
        assertEquals("Must be equal to 8", 8, Chapter05_03.flipBitToWinBruteForce(1775));
    }

    @Test
    public void testFlipBitToWin_Returns32() {
        assertEquals("Must be equal to 32", Integer.SIZE, Chapter05_03.flipBitToWinBruteForce(-1));
    }

    @Test
    public void testFlipBitToWin_Returns1() {
        assertEquals("Must be equal to 1", 1, Chapter05_03.flipBitToWinBruteForce(0));
    }

    @Test
    public void testFlipToWin_BruteForceEqualsLinear() {
        for (int i = -10000; i < 10000; i++) {
            assertEquals(Chapter05_03.flipBitToWinBruteForce(i), Chapter05_03.flipBitToWinLinear(i));
        }
    }
}
