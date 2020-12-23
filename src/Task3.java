import java.util.Scanner;

public class Task3 {
	private static Scanner predicate;
	
	public static void main(String[] args) {
		predicate = new Scanner(System.in);
		System.out.println("Input two predicates :");
		String Pr = predicate.nextLine();
		StringBuilder str = new StringBuilder(Pr.trim());      
		
		// Let  X = {x1, x2},  Y={y1, y2}
		Boolean[] P11 = {false, false, false, false, false, false, false, false,true,  true, true,  true, true,  true,  true, true};
		Boolean[] P12 = {false, false, false, false, true,  true,  true,  true, false, false,false, false,true,  true,  true, true};
		Boolean[] P21 = {false, false, true,  true,  false, false, true,  true, false, false,true,  true, false, false, true, true};
		Boolean[] P22 = {false, true,  false, true,  false, true,  false, true, false, true, false, true, false, true,  false,true};
		Boolean[] Q11 = {false, false, false, false, false, false, false, false,true,  true, true,  true, true,  true,  true, true};
		Boolean[] Q12 = {false, false, false, false, true,  true,  true,  true, false, false,false, false,true,  true,  true, true};
		Boolean[] Q21 = {false, false, true,  true,  false, false, true,  true, false, false,true,  true, false, false, true, true};
		Boolean[] Q22 = {false, true,  false, true,  false, true,  false, true, false, true, false, true, false, true,  false,true};
		Boolean left = null, right=null, result = null;
		int op_ind = str.indexOf(")")+1;
		int i = 0;
			while(i < 16) {
		////////////////--left side cases--//////////////////////////////////////////
			if(str.charAt(0) == '\u2200' && str.charAt(2) == '\u2203') {  // '\u2200' is unicode for ∀ (for all)
				left = (P11[i] || P12[i])&&(P21[i] || P22[i]);           // '\u2203' is unicode for ∃     (Exist)
			}
			if(str.charAt(0) == '\u2203' && str.charAt(2) == '\u2200') {
				left = (P11[i] && P12[i])||(P21[i] && P22[i]);
			}
			if(str.charAt(0) == '\u2200' && str.charAt(2) == '\u2200') {
				left = (P11[i] && P12[i])&&(P21[i] && P22[i]);
			}
			if(str.charAt(0) == '\u2203' && str.charAt(2) == '\u2203') {
				left = (P11[i] || P12[i])||(P21[i] || P22[i]);
			}
        ////////////////--Right side cases--////////////////////////////////////////
			if(str.charAt(op_ind + 1) == '\u2203' && str.charAt(op_ind + 3) == '\u2200') {
				right = (Q11[i] && Q12[i])||(Q21[i] && Q22[i]);
			}
			if(str.charAt(op_ind + 1) == '\u2200' && str.charAt(op_ind + 3) == '\u2203') {
				right = (Q11[i] || Q12[i])&&(Q21[i] || Q22[i]);
			}
			if(str.charAt(op_ind + 1) == '\u2200' && str.charAt(op_ind + 3) == '\u2200') {
				right = (P11[i] && P12[i])&&(P21[i] && P22[i]);
			}
			if(str.charAt(op_ind + 1) == '\u2203' && str.charAt(op_ind + 3) == '\u2203') {
				right = (P11[i] || P12[i])||(P21[i] || P22[i]);
			}
        ////////////////--Result cases--//////////////////////////////////////////
			if(str.charAt(op_ind) == '\u2228') {        /// \u2228 is unicode for logical OR (∨)
				result = left || right;
				if(result == false) {
					System.out.println("Result = " + result + " at:\n" + "Px1y1 = " + P11[i] + ", Px1y1= "+ P12[i] + ", Px2y1 " + P21[i] + ", Px2y2= "+ P22[i]
		                       + ", Qx1y1 = " + Q11[i] + ", Qx1y1= "+ Q12[i] + ", Qx2y1 " + Q21[i] + ", Qx2y2= "+ Q22[i]);
					break;
				}
			}
			if(str.charAt(op_ind) == '\u2227') {       /// \u2227 is unicode for logical AND (∧)
				result = left && right;
				if (result == false) {
					System.out.println("Result = " + result + " at:\n" + "Px1y1 = " + P11[i] + " Px1y1= "+ P12[i] + " Px2y1 " + P21[i] + " Px2y2= "+ P22[i]
		                       + "Qx1y1 = " + Q11[i] + " Qx1y1= "+ Q12[i] + " Qx2y1 " + Q21[i] + " Qx2y2= "+ Q22[i]);
					break;
				}
			}
			i++;
		}
			if(result == false) {
					System.out.println("The predicate is Not valid");
					
			}else {
				System.out.println("The predicate is valid");
			}
		
	}
}