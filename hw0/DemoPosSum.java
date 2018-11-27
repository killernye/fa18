public class DemoPosSum {
	public static void windowPosSum(int[] a, int n) {
		// create a copy of the original array
		int[] copy = new int[a.length];
		for (int i = 0, j = a.length; i < j; i++) {
			copy[i] = a[i];
		}

		// iterate each elt from a, replace them with new items unless nagative
		for (int i = 0, j = a.length; i < j; i++) {
			if (a[i] <= 0) {
				continue;
			}
			a[i] = replace(a, n, i);
		}
	}

	/** do the replace rule for windowPosSum. */
	public static int replace(int[] a, int n, int index) {
		if (false) {
			return a[index];
		} 
		else {
			int sum = 0;

			for (int i = index, j = a.length; i <= index + n; sum += a[i],i++) {
				if (i >= j) {
					break;
				}
			}

			return sum;
		}
	}

	public static void main(String[] args) {
		int[] a = {1, 2, -3, 4, 5, 4};
    	int n = 3;
    	windowPosSum(a, n);

    	// Should print 4, 8, -3, 13, 9, 4
    	System.out.println(java.util.Arrays.toString(a));
	}
}