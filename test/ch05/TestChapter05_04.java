package ch05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by almer on 05/09/16.
 */
public class TestChapter05_04 {

    @Test
    public void testNextLargest() {
        for (int i = 1; i < 5000; i++) {
            assertEquals(String.format("Next largest for %d (%s).", i, Integer.toBinaryString(i)),
                    Chapter05_04.nextLargestBruteForce(i), Chapter05_04.nextLargestClever(i));
        }
    }
}
