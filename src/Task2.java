import java.util.Scanner;

public class Task2 {
	private static Scanner relation;

	public static Boolean isSubstring(String S, String sub) {
		if (S.indexOf(sub) >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		relation = new Scanner(System.in);
		System.out.print("Input two relation separated with ';' : \nR = ");
		String R = relation.nextLine();
		String R1 = "", R2 = "";
		String Result = "";
		int ind = R.indexOf(";");
		for (int i = 0; i < R.length(); i++) {
			if (i < ind) {
				R1 += R.charAt(i);
			}
			if (i > ind) {
				R2 += R.charAt(i);
			}
		}
		StringBuilder str = new StringBuilder(R);
		int start, end;
		while (str.indexOf("(") != -1) {
			start = str.lastIndexOf("(");
			end = str.indexOf(")", start);
			if (!(isSubstring(R2, str.substring(start, end)) && isSubstring(R1, str.substring(start, end)))) {
				Result += str.substring(start, end + 1) + " ,";
			}
			str.replace(start, end + 1, new StringBuilder(str.substring(start + 1, end)).toString());
		}
		StringBuilder res = new StringBuilder(Result); // the following three line just to make it look better.
		res.replace(Result.lastIndexOf(" ,"), Result.length(), ""); // replacing the last comma with empty space
		Result = res.toString();
		System.out.println("{" + Result + "}");
	}
}
