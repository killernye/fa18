import static org.junit.Assert.*;
import org.junit.Test;

public class TestOffByN {
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testCharsEqual() {
        assertTrue(offBy5.equalChars('a', 'f'));
    }
}
