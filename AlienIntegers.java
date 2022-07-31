import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AlienIntegers {
	
	public static String findNumberFast(String N) {
		/**
		 * Put all the digits in a set and a queue
		 */
		Set<Integer> digits = new HashSet<Integer>();
		getDigits(digits, N);
		
		int max = 9;
		while(max >= 0) {
			if(!digits.contains(max)) {
				break;
			} 
			max--;
		}
		
		if(max == -1) {
			return "IMPOSSIBLE";
		}
		
		int min = 0;
		while(min < 10) {
			if(!digits.contains(min)) {
				break;
			} 
			min++;
		}
		
		
		/**
		 * Lower solution first
		 */
		BigInteger lowerSolution = new BigInteger("0");
		int startingDigit = Integer.parseInt(N.substring(0,1));
		startingDigit--;
		while(startingDigit >= 0) {
			if(!digits.contains(startingDigit)) {
				break;
			}
			startingDigit--;
		}
		if(startingDigit == -1) startingDigit = 0;
		lowerSolution = lowerSolution.add(new BigInteger("" + startingDigit));
		
		for(int i = 0; i < N.length() - 1; i++) {
			lowerSolution = lowerSolution.multiply(new BigInteger("10"));
			lowerSolution = lowerSolution.add(new BigInteger("" + max));
		}
		
		
		
		/**
		 * Higher solution second
		 */
		BigInteger higherSolution = new BigInteger("0");
		startingDigit = Integer.parseInt(N.substring(0,1));
		startingDigit++;
		while(startingDigit < 10) {
			if(!digits.contains(startingDigit)) {
				break;
			}
			startingDigit++;
		}
		if(startingDigit == 10) {
			 startingDigit = 1;
			while(startingDigit < 10) {
				if(!digits.contains(startingDigit)) {
					break;
				}
				startingDigit++;
			}
			startingDigit = startingDigit * 10;
			int startingDigit2 = 0;
			while(startingDigit2 < 10) {
				if(!digits.contains(startingDigit2)) {
					break;
				}
				startingDigit2++;
			}
			startingDigit += startingDigit2;
		}
		higherSolution = new BigInteger("" + startingDigit);
		for(int i = 0; i < N.length() - 1; i++) {
			higherSolution = higherSolution.multiply(new BigInteger("10"));
			higherSolution = higherSolution.add(new BigInteger("" + min));
		}

		BigInteger n = new BigInteger(N);
		BigInteger difLower = n.subtract(lowerSolution); 
		BigInteger difHigher = higherSolution.subtract(n);
		if(difLower.compareTo(difHigher) < 0) {
			return lowerSolution.toString();
		} else if (difLower.compareTo(difHigher) > 0) {
			return higherSolution.toString();
		} else {
			return lowerSolution.toString() + " " + higherSolution.toString();
		}
	}
	
	public static boolean isValid(Set<Integer> digits, BigInteger lower) {
		boolean isValid = true;
		for(int i = 0; i < lower.toString().length(); i++) {
			if(digits.contains(Integer.parseInt(lower.toString().substring(i, i+1)))) {
				isValid = false;
				i = lower.toString().length();
			}
		}
		return isValid;
	}
	
	public static void getDigits(Set<Integer> digits, String N) {
		/**
		 * Put all the digits in a set and a queue
		 */
		for(int i = 0; i < N.length(); i++) {
			int x = Character.digit(N.charAt(i), 10);
			digits.add(x);
		}
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		System.out.println(findNumberFast(n));
		in.close();
	}
}
