import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
	private static Scanner relation;

	public static Boolean isDigit(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}

	public static void printMatrix(String R, int dim, Integer[] arr) {
		StringBuilder str = new StringBuilder(R);
		String[][] matrix = new String[dim][dim];
		int start, end;
		while (str.indexOf("(") != -1) {
			start = str.lastIndexOf("(");
			end = str.indexOf(")", start);
			int x = Integer.parseInt(str.substring(start + 1, str.indexOf(",", start)).trim());
			int y = Integer.parseInt(str.substring(str.indexOf(",", start) + 1, end).trim());
			matrix[x - 1][y - 1] = "X";
			str.replace(start, end + 1, new StringBuilder(str.substring(start + 1, end)).toString());
		}
		System.out.print("R |");
		for (int a : arr) {
			System.out.print(a + "|");
		}
		for (int j = 0; j < dim; j++) {
			System.out.println();
			if (j == 9) {
				System.out.print(arr[j] + "|");
			}
			if (j < 9) {
				System.out.print(arr[j] + " |");
			}
			for (int k = 0; k < dim; k++) {
				if (matrix[j][k] == null) {
					matrix[j][k] = " ";
				}
				System.out.print(matrix[j][k] + "|");
			}
		}
	}

	public static void main(String[] args) {
		relation = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		System.out.print("Input relation : \nR = ");
		String R = relation.nextLine();
		for (int i = 0; i < R.length(); i++) {
			if (isDigit(R.charAt(i))) {
				if (isDigit(R.charAt(i + 1))) {
					set.add(10);
					i += 2;
					continue;
				} else {
					set.add(R.charAt(i) - '0'); // char - '0' to convert char to int.
				}
			}
		}
		int num = 0;
		Integer[] arr = set.toArray(new Integer[set.size()]);
		for (int i = 0; i < R.length(); i++) {
			StringBuilder str = new StringBuilder(R);
			int start, end;
			while (str.indexOf("(") != -1) {
				start = str.lastIndexOf("(");
				end = str.indexOf(")", start);
				int x = Integer.parseInt(str.substring(start + 1, str.indexOf(",", start)).trim());
				int y = Integer.parseInt(str.substring(str.indexOf(",", start) + 1, end).trim());
				if ((x == y) && set.contains(x)) {
					set.remove(x);
					num++;
				}
				str.replace(start, end + 1, new StringBuilder(str.substring(start + 1, end)).toString());
			}
		}
		if (num == arr.length) {
			System.out.println("The Relation is reflexive");
		} else {
			System.out.println("The Relation is not reflexive");
		}
		printMatrix(R, arr.length, arr);
	}
}
