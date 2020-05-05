package powerHungry;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import powerHungry.Solution;

public class TestSolution {
    private Solution a;

    @Before
    public void setUp() {
        a = new Solution();
    }

    @Test
    public void test1() {
        assertEquals("8", a.solution(new int[] { 2, 0, 2, 2, 0 }));
    }

    @Test
    public void test2() {
        assertEquals("60", a.solution(new int[] { -2, -3, 4, -5 }));
    }

    @Test
    public void test3() {
        assertEquals("30", a.solution(new int[] { 0, -1, -2, -3, 5 }));
    }

    @Test
    public void test4() {
        assertEquals("60", a.solution(new int[] { 0, 2, 2, 3, 5 }));
    }

    @Test
    public void test5() {
        assertEquals("0", a.solution(new int[] { 0, 0, 0, 0, -5 }));
    }

    @Test
    public void test6() {
        assertEquals("1000000000000000000000000000000000000000000000000000000000", a.solution(new int[] { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000 }));
    }

    @Test
    public void test7() {
        assertEquals("40", a.solution(new int[] { 2, 2, 2, -2, -5 }));
    }

    @Test
    public void test8() {
        assertEquals("5", a.solution(new int[] { 0, 0, 0, 0, 5 }));
    }

    @Test
    public void test9() {
        assertEquals("80", a.solution(new int[] { -10, -2, 3, 4 }));
    }

    @Test
    public void test11() {
        assertEquals("0", a.solution(new int[] { 1, 1, 1, 0, 0 }));
    }

    @Test
    public void test12() {
        assertEquals("1", a.solution(new int[] { 1, 1, 1, 1, 0 }));
    }

    @Test
    public void test13() {
        assertEquals("0", a.solution(new int[] { -1, 0, 0 }));
    }

    @Test
    public void test14() {
        assertEquals("-1", a.solution(new int[] { -1 }));
    }

    @Test
    public void test15() {
        assertEquals("1", a.solution(new int[] { 1 }));
    }
}
