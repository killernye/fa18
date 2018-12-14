import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {

    @Test
    public void testIsSameNumber() {
        assertTrue("28 and 28 are not a same number.", Flik.isSameNumber(28, 28));
        assertTrue("127 and 127 are not a same number.", Flik.isSameNumber(127, 127));
        assertTrue("129 and 129 are not a same number.", Flik.isSameNumber(129, 129));
        assertTrue("128 and 128 are not a same number.", Flik.isSameNumber(128, 128));
    }
}
