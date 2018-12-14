import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testSizePrint() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        assertEquals(0, ad1.size());

        ArrayDeque<String> ad2 = new ArrayDeque<>("front");
        assertEquals(1, ad2.size());
        ad2.printDeque();
    }

    @Test
    public void testAddRemove() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ad1.addFirst("one");
        ad1.addLast("two");
        ad1.addLast("three");
        ad1.addLast("four");
        ad1.addLast("five");
        ad1.addLast("six");
        ad1.addLast("seven");
        ad1.addFirst("zero");
        assertEquals(8, ad1.size());
        String rm1 = ad1.removeLast();
        assertEquals("seven", rm1);
        ad1.printDeque();

        ArrayDeque<String> ad2 = new ArrayDeque<>("zero");
        String removed2 = ad2.removeFirst();
        assertEquals("zero", removed2);
        assertEquals(0, ad2.size());
        ad2.printDeque();
    }

    @Test
    public void testResize() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(0);
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);

        assertEquals(9, ad1.size());
        ad1.printDeque();
    }
}
