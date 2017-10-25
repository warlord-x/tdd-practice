import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.test.Calc;

import static org.junit.Assert.assertEquals;

public class CalcTests {

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void add0Return0() throws Exception {
        Calc c = new Calc();
        assertEquals(0, c.addInt(""));
    }

    @Test
    public void add1ReturnSame() throws Exception {
        Calc c = new Calc();
        int passed = 1;
        assertEquals(passed, c.addInt(String.valueOf(passed)));
    }

    @Test
    public void addMultipleNums() throws Exception {
        Calc c = new Calc();

        assertEquals(6, c.addInt(String.valueOf("1,2,3")));
        assertEquals(10, c.addInt(String.valueOf("1,2,3,4")));
        assertEquals(15, c.addInt(String.valueOf("1,2,3,4,5")));
    }

    @Test
    public void addWithNewLine() throws Exception {
        Calc c = new Calc();

        assertEquals(6, c.addInt(String.valueOf("1\n2,3")));
        assertEquals(10, c.addInt(String.valueOf("1,2\n3,4")));
        assertEquals(15, c.addInt(String.valueOf("1,2,3,4,5")));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWithNegativeNumber() throws Exception {
        Calc c = new Calc();
            c.addInt(String.valueOf("1,-3,3,-3"));
        exception.expectMessage("Negative not allowed:-3-3");
    }

}
