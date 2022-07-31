import java.util.Scanner;

public class Game2048 {
	/**
	 * Given an array pushes all the non zero elements to the front
	 * 
	 * @param array
	 */
	public static int[] condenseZeros(int array[]) {
		int j = 0;
		int newArr[] = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				newArr[j] = array[i];
				j++;
			}
		}
		return newArr;
	}
	
	/**
	 * Given an array pushes consecutive numbers that are the same together
	 *
	 * @param args
	 */
	public static int[] combineNumbers(int array[]) {
		int j = 0;
		int newArr[] = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			if(i != array.length-1 && array[i] == array[i+1]) {
				newArr[j] = 2 * array[i];
				i++;
			} else {
				newArr[j] = array[i];
			}
			j++;
		}
		return newArr;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] board = new int[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				board[i][j] = in.nextInt();
			}
		}
		
		int direction = in.nextInt();
		
		
		if(direction == 0) {
			for(int i = 0; i < 4; i++) {
				board[i] = condenseZeros(board[i]);
				board[i] = combineNumbers(board[i]);
			}
		} else if (direction == 1) {
			for(int i = 0; i < 4; i++) {
				int[] column = {board[0][i], board[1][i], board[2][i], board[3][i]};
				column = condenseZeros(column);
				column = combineNumbers(column);
				board[0][i] = column[0];
				board[1][i] = column[1];
				board[2][i] = column[2];
				board[3][i] = column[3];
			}
		} else if (direction == 2) {
			for(int i = 0; i < 4; i++) {
				int[] column = {board[i][3], board[i][2], board[i][1], board[i][0]};
				column = condenseZeros(column);
				column = combineNumbers(column);
				board[i][3] = column[0];
				board[i][2] = column[1];
				board[i][1] = column[2];
				board[i][0] = column[3];
			}
		} else {
			for(int i = 0; i < 4; i++) {
				int[] column = {board[3][i], board[2][i], board[1][i], board[0][i]};
				column = condenseZeros(column);
				column = combineNumbers(column);
				board[3][i] = column[0];
				board[2][i] = column[1];
				board[1][i] = column[2];
				board[0][i] = column[3];
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		in.close();
	}
}
