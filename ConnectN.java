import java.util.Scanner;

class Node {
	// node stores color and path sizes
	String color;
	int pathLeft = 1;
	int pathUpLeft = 1;
	int pathUp = 1;
	int pathUpRight = 1;
}

public class ConnectN {
	
	public static void main(String[] args) {
		 // input
		 Scanner in = new Scanner(System.in);
		 
		 // board
		 Node[][] board = new Node[in.nextInt()][in.nextInt()];
		 int N = in.nextInt();
		 
		 // winning data
		 String winner = "O";
		 boolean winnerFound = false;
		 
		 for(int i = 0; i < board.length && !winnerFound; i++) {
			 for(int j = 0; j < board[0].length; j++) {
				 String color = in.next();
				 Node x = new Node(); 
				 x.color = color;
				 // left
				 if(!color.equals("O")) {
					 if(j - 1 >= 0 && board[i][j-1].color.equals(color)) {
						 x.pathLeft = board[i][j-1].pathLeft + 1;
					 }
					 if(x.pathLeft >= N) {
						 winner = color;
						 winnerFound = true;
						 break;
					 }
					 // left and up
					 if(j-1 >= 0 && i-1 >= 0 && board[i-1][j-1].color.equals(color)) {
						 x.pathUpLeft = board[i-1][j-1].pathUpLeft + 1;
					 }
					 if(x.pathUpLeft >= N) {
						 winner = color;
						 winnerFound = true;
						 break;
					 }
					 // up
					 if(i-1 >= 0 && board[i-1][j].color.equals(color)) {
						 x.pathUp = board[i-1][j].pathUp + 1;
					 }
					 if(x.pathUp >= N) {
						 winner = color;
						 winnerFound = true;
						 break;
					 }
					 // up and right
					 if(i-1 >= 0 && j + 1 < board[0].length && board[i-1][j+1].color.equals(color)) {
						 x.pathUpRight = board[i-1][j+1].pathUpRight + 1;
					 }
					 if(x.pathUpRight >= N) {
						 winner = color;
						 winnerFound = true;
						 break;
					 }
				 }
				 board[i][j] = x;
			 }
		 }
		 
		 // output
		 if(winner.equals("B")) {
			 System.out.println("BLUE WINS");
		 } else if (winner.equals("R")) {
			 System.out.println("RED WINS");
		 } else {
			 System.out.println("NONE");
		 }
		 
		 in.close();
		 
	}
}
