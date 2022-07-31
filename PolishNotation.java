import java.util.Scanner;

public class PolishNotation {
	
    public static boolean canParseInt(String s) {
        assert s != null : "Violation of: s is not null";
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
	public static String evaluateExpression(Scanner in) {
		String operators = "+-*";
		
		/** 
		 * expr -> O term term
		 * O -> {+-*}
		 * term -> num | var | expr
		 * num -> {-10...10}
		 * var -> !num
		 * 
		 * or something like this
		 */
		
		String result = "";
		while(in.hasNext()) {
			String x = in.next();
			// if x is an operator get next two expressions
				if (operators.contains(x)) {
					if(x.equals("+")) {
						String A = evaluateExpression(in);
						String B = evaluateExpression(in);
						if(canParseInt(A) && canParseInt(B)) {
							return "" + (Integer.parseInt(A) + Integer.parseInt(B));
						} else {
							return "+ " + A + " " + B;
						}
					} else if (x.equals("-")) {
						String A = evaluateExpression(in);
						String B = evaluateExpression(in);
						if(canParseInt(A) && canParseInt(B)) {
							return  "" + (Integer.parseInt(A) - Integer.parseInt(B));
						} else {
							return "- " + A + " " + B;
						}
					} else if (x.equals("*")) {
						String A = evaluateExpression(in);
						String B = evaluateExpression(in);
						if(canParseInt(A) && canParseInt(B)) {
							return "" + (Integer.parseInt(A) * Integer.parseInt(B));
						} else {
							return "* " + A + " " + B;
						}
					} 
				} else {
					// else just return term (either a variable or number)
					return x; 
				} 
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// report n cases
		int i = 1;
		while(in.hasNextLine()) {
			Scanner line = new Scanner(in.nextLine());
			System.out.println("Case " + i + ": " + evaluateExpression(line));
			i++;
		}
		
		in.close();
	}
}
