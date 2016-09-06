package ch05;

/**
 * Created by almer on 29/08/16.
 */
public class Util {

    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    static int clearBitsMSBitThroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    static int clearBitsIThrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }

    static int updateBit(int num, int i, boolean bitIs1) {
        int mask = ~(1 << i);
        int value = bitIs1 ? 1 : 0;
        return (num & mask) | (value << i);
    }
}
