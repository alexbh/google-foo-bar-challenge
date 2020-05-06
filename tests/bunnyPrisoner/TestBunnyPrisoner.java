package bunnyPrisoner;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBunnyPrisoner {

    Solution a;

    public void setUp() {
         a = new Solution();
    }

    @Test
    public void test1() {
        assertEquals(a.solution(3,2),"9");
    }

    @Test
    public void test2() {
        assertEquals(a.solution(5,10),"96");
    }

    @Test
    public void test3() {
        assertEquals(a.solution(4,5),"32");
    }


}
