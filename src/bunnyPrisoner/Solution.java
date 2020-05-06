package bunnyPrisoner;

public class Solution {

    public static String solution(long x, long y) {
        return String.valueOf(findId(y, x));
    }

    private static long findId(long y, long x) {

        long starterY = returnStarterY(y);
        long sum = starterY;

        for (long z=1; z<x; z++) {
            sum = (y+z)+sum;
        }

        return sum;
    }


    private static long returnStarterY(long position) {
        long sum = 1;
        long counter = 0;

        for (long x=1; x<=position; x++) {
            sum = counter+sum;
            counter++;
        }

        return sum;
    }

}
