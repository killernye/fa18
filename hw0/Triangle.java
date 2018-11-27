public class Triangle {
	public static void printAStar() {
		System.out.print("*");
	}

	public static void printNStar(int n) {
		while (n > 0) {
			printAStar();
			n -= 1;
		}
		aNewLine();
	}

	public static void aNewLine() {
		System.out.println();
	}

	public static void drawTriangle(int N) {
		int k = 1;

		while (k <= N) {
			printNStar(k);
			k++;
		}
	}

	public static void main(String[] args) {
		drawTriangle(10);
	}
}