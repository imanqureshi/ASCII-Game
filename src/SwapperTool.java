import java.util.Scanner;

public class SwapperTool extends Tool {

	/* constructor */
	public SwapperTool(String stname, String func) {
		super(stname, func);
	}

	/**
	 * returns special sound made by using flipper tool 
	 * pre: none 
	 * post: sound of tool (lyric) is returned
	 */
	String toolSound() {
		return "I'll be...switchin the positions for you!";
	}

	/**
	 * swaps all locations of a character with all locations of another
	 * pre: none
	 * post: all locations of a character are swapped with another. 
	 */
	public char[][] fullSwap(char[][] arr) {
		Scanner input = new Scanner(System.in);
		char char1;
		char char2;

		System.out.println("What is the Character You Would Like to Swap:");
		char1 = input.next().charAt(0);
		while (!charExists(arr, char1)) {
			System.out.println("Your character could not be found. Please try again.");
			char1 = input.next().charAt(0);
			if (charExists(arr, char1)) {
				break;
			}
		}
		System.out.println("What is the Second Character You Would Like to Swap:");
		char2 = input.next().charAt(0);
		while (!charExists(arr, char2)) {
			System.out.println("Your character could not be found. Please try again.");
			char2 = input.next().charAt(0);
			if (charExists(arr, char2)) {
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == char1) {
					arr[i][j] = char2;
				} else if (arr[i][j] == char2) {
					arr[i][j] = char1;
				}
			}
		}
		return arr;
	}
	/**
	 * swaps single location of character in array with another
	 * pre: none
	 * post: locations are swapped. 
	 */
	public char[][] SingleSwap(char[][] arr) {
		Scanner input = new Scanner(System.in);
		int row1, row2, col1, col2;

		System.out.println("\nCHARACTER 1: ");
		System.out.println("Enter the ROW of the First Character You Would Like to Swap:");
		row1 = input.nextInt();
		while (true) {
			if (row1 > 0 && row1 <= arr.length) {
				break;
			} else
				System.out.println("Please enter a valid Row.");
			row1 = input.nextInt();
		}
		System.out.println("\nSelected row... ");
		for (int i = 0; i < arr[0].length; i++) {
			System.out.print(arr[row1 - 1][i] + " ");
		}
		System.out.println("\nEnter the COLUMN of the Character You Would Like to Swap Character 1 With:");
		col1 = input.nextInt();
		while (true) {
			if (col1 > 0 && col1 <= arr[0].length) {
				break;
			} else
				System.out.println("Please enter a valid Column.");
				col1 = input.nextInt();
		}
		System.out.println("Character Chosen: " + arr[row1 - 1][col1 - 1]);

		System.out.println("\nCHARACTER 2: ");
		System.out.println("Enter the ROW of the Character You Would Like to Swap Character 1 With:");
		row2 = input.nextInt();
		while (true) {
			if (row2 > 0 && row2 <= arr.length) {
				break;
			} else
				System.out.println("Please enter a valid Row.");
			row2 = input.nextInt();
		}
		System.out.print("\nSelected Row... ");
		for (int i = 0; i < arr[0].length; i++) {
			System.out.print(arr[row2 - 1][i] + " ");
		}		
		System.out.println("\nEnter the COLUMN of the Character You Would Like to Swap Character 1 With:");
		col2 = input.nextInt();
		while (true) {
			if (col2 > 0 && col2 <= arr[0].length) {
				break;
			} else
				System.out.println("Please enter a valid Column.");
				col2 = input.nextInt();
		}
		System.out.println("Character Chosen: " + arr[row2 - 1][col2 - 1]);

		char temp = arr[row1 - 1][col1 - 1]; // swapping locations
		arr[row1 - 1][col1 - 1] = arr[row2 - 1][col2 - 1];
		arr[row2 - 1][col2 - 1] = temp;
		return arr;
	}

}
