package gospodarka.elektroniczna.util;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {
    
    @Test
    @Parameters
    public void shouldReturnPassedExpectedResult(String value, boolean expectedResult) throws Exception {
        // given
        
        // when
        boolean result = StringUtil.isEmpty(value);

        // then
        assertEquals(expectedResult, result);
    }
    
    public Object[] parametersForShouldReturnPassedExpectedResult() {
        return $(
                    $(null, true),
                    $("", true),
                    $("  ", true),
                    $("         ", true),
                    $("       ", true),
                    $("         ", true),
                    $("       ", true),
                    $(" a ", false),
                    $("     d", false),
                    $("d ", false),
                    $("         d ", false)
                 );
    }

    @Test
    @Parameters
    public void testRemoveWhitespaces(String number, String expected) throws Exception {
        String result = StringUtil.removeWhitespaces(number);
        
        assertEquals(expected, result);
    }
    
    public Object[] parametersForTestRemoveWhitespaces() {
        return $(
                    $("12 3456", "123456"),
                    $("123 4567", "1234567"),
                    $("1234 5678", "12345678"),
                    $("123", "123"),
                    $("1 2345", "12345"),
                    $("05 7712 5419 9761 6253 1932 2422", "05771254199761625319322422"),
                    $(" 0123 ", "0123"),
                    $(" 0\t12\t\t0123 ", "0120123"),
                    $("\t\t0123\t\t", "0123"),
                    $(null, ""),
                    $("", ""),
                    $("\t", ""),
                    $(" \t\t ", "")
                );
    }
}
