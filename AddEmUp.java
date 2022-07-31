import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddEmUp {
	
	 @SuppressWarnings("serial")
	final static Map<Integer, Integer> flippedValues = new HashMap<>() {{
		put(0,0);
		put(1,1);
		put(2,2);
		put(5,5);
		put(6,9);
		put(8,8);
		put(9,6);
	}};
	
	public static boolean canFlip(int card) {
		boolean canFlip = true;
		while(canFlip && card != 0) {
			int dig = card % 10;
			card = card / 10;
			if(!flippedValues.containsKey(dig)) {
				canFlip = false;
			}
		}
		return canFlip;
	}
	
	
	public static int flip(int card) {
		int newCard = 0;
		while(card != 0) {
			int dig = card % 10;
			card = card / 10;
			int newDig = flippedValues.get(dig);
			newCard = newCard * 10 + newDig;
		}
		return newCard;
	}
	
	public static void main(String[] args) {
		String input = "3 66\r\n"
				+ "15 21 22";
		Scanner in = new Scanner(input);
		
		
		int N = in.nextInt();
		int sum = in.nextInt();
		List<Integer> cards = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			int card = in.nextInt();
			for(int j = 0; j < cards.size(); j++) {
				int possibleSum = cards.get(j) + card;
				if(possibleSum == sum) {
					System.out.println("YES");
					in.close();
					return;
				}
			}
			if(canFlip(card)) {
				int flippedCard = flip(card);
				
				for(int j = 0; j < cards.size(); j++) {
					int possibleSum = cards.get(j) + flippedCard;
					if(possibleSum == sum) {
						System.out.println("YES");
						in.close();
						return;
					}
				}
				
				cards.add(flippedCard);
			}
			cards.add(card);
		}
		
		System.out.println("NO");
		
		in.close();
	}
}
