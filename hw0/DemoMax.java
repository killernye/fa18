public class DemoMax {
	/** Returns the maximum value from m. **/
	public static int max(int[] m) {
		//create a varible to keep the max index
		int maxIndex = 0;

		//loop from the beignning 
		for(int i = 0, j = m.length; i < j; i++) {
			// cmp each item to the max so far
			if (m[i] > m[maxIndex]) {
				maxIndex = i;
			}
		}

		return m[maxIndex];
	}

	public static void main(String[] args) {
		int[] numbers = new int[]{0,5, 1, 22, 19, 21};
		System.out.println(max(numbers));
	}
}