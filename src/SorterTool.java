import java.util.Arrays;
import java.util.Scanner;

public class SorterTool extends Tool {

	public SorterTool(String tName, String func) {
		super(tName, func);
	}

	String toolSound() {
		return "A B C...As easy as 1 2 3";
	}

	public char[][] sortRow(char[][] arr) {
		Scanner input = new Scanner(System.in);
		int row;

		System.out.println("Please enter the ROW you would like to sort: ");
		row = input.nextInt();
		while (true) {
			if (row > 0 && row <= arr.length) {
				break;
			} else
				System.out.println("Please enter a valid Row.");
			row = input.nextInt();
		}
		row -= 1;
			// loop for column of matrix
			for (int j = 0; j < arr[row].length; j++) {
				// loop for comparison and swapping
				for (int k = 0; k < arr[row].length - j - 1; k++) {
					if (arr[row][k] > arr[row][k + 1]) {
						// swapping of elements
						char temp = arr[row][k];
						arr[row][k] = arr[row][k + 1];
						arr[row][k + 1] = temp;
					}
				}
			}
		return arr;
	}
	public char[][] sortCol(char[][] arr) {
		Scanner input = new Scanner(System.in);
		int col;

		System.out.println("Please enter the COLUMN you would like to sort: ");
		col = input.nextInt();
		while (true) {
			if (col > 0 && col <= arr[0].length) {
				break;
			} else
				System.out.println("Please enter a valid Column.");
				col = input.nextInt();
		}
		col -= 1;
			// loop for column of matrix
			for (int i = 0; i < arr.length; i++) {
				// loop for comparison and swapping
				for (int j = 0; j < arr.length - i - 1; j++) {
					if (arr[j][col] > arr[j+1][col]) {
						// swapping of elements
						char temp = arr[j][col];
						arr[j][col] = arr[j+1][col];
						arr[j+1][col] = temp;
					}
				}
			}
		return arr;
	}
	public char[][] sortAll(char[][] arr) {

		// loop for rows of matrix
		for (int i = 0; i < arr.length; i++) {
			// loop for column of matrix
			for (int j = 0; j < arr[i].length; j++) {
				// loop for comparison and swapping
				for (int k = 0; k < arr[i].length - j - 1; k++) {
					if (arr[i][k] > arr[i][k + 1]) {
						// swapping of elements
						char temp = arr[i][k];
						arr[i][k] = arr[i][k + 1];
						arr[i][k + 1] = temp;
					}
				}
			}
		}
		return arr;

	}
}
