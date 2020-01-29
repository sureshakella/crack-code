import fornow.NonRepeatCharInString;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonRepeatCharInStringTest {

    private NonRepeatCharInString classToTest = new NonRepeatCharInString();

    @Test
    public void test()  {
        assertEquals('u', classToTest.getFirstNonRepeatChar("suresh"));
        assertEquals('0', classToTest.getFirstNonRepeatChar("suusrertet"));
        assertEquals(' ', classToTest.getFirstNonRepeatChar("tis isoverstock"));
    }

}