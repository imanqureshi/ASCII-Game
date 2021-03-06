import java.util.Scanner;

/**
 * Iman Qureshi 
 * January 26 2021 
 * ICS4U 
 * This program creates the characteristics for a sorter tool.
 */
public class SorterTool extends Tool {

	/* constructor */
	public SorterTool(String tName, String func) {
		super(tName, func);
	}

	/**
	 * returns special sound made by using sorter tool 
	 * pre: none 
	 * post: sound of tool (lyric) is returned
	 */
	String toolSound() {
		String sound;
		sound = "____________________________________________";
		sound += "\n\n\tA B C...As easy as 1 2 3";
		sound += "\n____________________________________________\n";
		return sound;
	}

	/**
	 * sorts single row of the array from least to greatest ASCII value
	 * pre: none
	 * post: chosen row in array is sorted 
	 */
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
	/**
	 * sorts single column of the array from greatest to least ASCII value
	 * pre: none
	 * post: chosen column in array is sorted 
	 */
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
				if (arr[j][col] < arr[j + 1][col]) {
					// swapping of elements
					char temp = arr[j][col];
					arr[j][col] = arr[j + 1][col];
					arr[j + 1][col] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * sorts all rows in array based on the lowest to greatest ASCII value. 
	 * pre: none 
	 * post: all rows are sorted
	 */
	public char[][] sortAllRows(char[][] arr) {
		for (int i = 0; i < arr.length; i++) { // loops through rows of array
			for (int j = 0; j < arr[i].length; j++) { // loops column of array
				for (int k = 0; k < arr[i].length - j - 1; k++) { // loop to compare all elements
					if (arr[i][k] > arr[i][k + 1]) {
						char temp = arr[i][k]; // swapping
						arr[i][k] = arr[i][k + 1];
						arr[i][k + 1] = temp;
					}
				}
			}
		}
		return arr;

	}
	/**
	 * sorts all columns in array based on the greatest to lowest ASCII value. 
	 * pre: none 
	 * post: all columns are sorted
	 */
	public char[][] sortAllCols(char[][] arr) {
		for (int i = 0; i < arr[0].length; i++) { // loops through rows of array
			for (int j = 0; j < arr.length; j++) { // loops column of array
				for (int k = 0; k < arr.length - j - 1; k++) { // loop to compare all elements
					if (arr[k][i] < arr[k +1][i]) {
						char temp = arr[k][i]; // swapping
						arr[k][i] = arr[k + 1][i];
						arr[k + 1][i] = temp;
					}
				}
			}
		}
		return arr;

	}
}
