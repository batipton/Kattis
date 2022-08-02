import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sorts first two letters only "stable sort"
 */
public class SortOfSorting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		while(n != 0) {
			ArrayList<String> sorted = new ArrayList<String>();
			for(int i = 0; i < n; i++) {
				String x = in.nextLine();
				String pre = x.substring(0,2);
				boolean inserted = false;
				int j = 0;
				while(!inserted && j < sorted.size()) {
					if(sorted.get(j).substring(0,2).compareTo(pre) > 0) {
						sorted.add(j, x);
						inserted = true;
					}
					j++;
				}
				
				if(!inserted) {
					sorted.add(x);
				}
			}
			for(int i = 0; i < sorted.size(); i++) {
				System.out.println(sorted.get(i));
			}
			n = Integer.parseInt(in.nextLine());
			System.out.println();
		}
		
		in.close();
	}

}
