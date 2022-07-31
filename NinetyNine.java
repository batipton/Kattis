import java.util.Scanner;

public class NinetyNine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// game counter
		int counter = 0;
		// stage 1 (breaking out of multiple of 3)
		counter += 1;
		System.out.println(counter);
		counter = Integer.parseInt(in.nextLine());
		int losingCount = counter - 1;
		
		// stage 1 (losing position)
		while(counter % 3 == 0) {
			counter += losingCount;
			System.out.println(counter);
			counter = Integer.parseInt(in.nextLine());
		}
		
		// stage 2 (only making it a multiple of 3)
		while(counter < 99) {
			if(counter % 3 == 1) {
				counter += 2;
				System.out.println(counter);
			} else {
				counter += 1;
				System.out.println(counter);
			}
			if(counter != 99) counter = Integer.parseInt(in.nextLine());
		}
		
		in.close();

	}

}
