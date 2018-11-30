public class IntListTest {

	public static void main(String[] args) {
		
		// create a list 5 -> 10 -> 15
		IntList l = new IntList(3, null);
		l = new IntList(2, l);
		l = new IntList(1, l);
		l = new IntList(1, l);

		l.addAdjacent();
		System.out.println(l);
	}
}