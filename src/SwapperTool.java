import java.util.Scanner;

public class SwapperTool extends Tool {

	/* constructor */
	public SwapperTool(String stname, String func) {
		super(stname, func);
	}

	/**
	 * returns special sound made by using flipper tool pre: none post: sound of
	 * tool (lyric) is returned
	 */
	String toolSound() {
		return "I'll be...switchin the positions for you!";
	}

	/**
	 * writes upside down image onto created text file pre: contents of 2D array
	 * must be strings only post: 2D array is written to file
	 */
	public char[][] fullSwap(char[][] arr) {
		Scanner input = new Scanner(System.in);
		char char1;
		char char2;

		System.out.println("What is the Character You Would Like to Swap:");
		char1 = input.next().charAt(0);

		System.out.println("What is the Second Character You Would Like to Swap:");
		char2 = input.next().charAt(0);
	
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

//	public boolean charSearch(char[][] arr, int row, char c) {
//		boolean check = false;
//		for (int i = row; i < arr.length;) {
//			check = false;
//			for (int j = 0; j < arr[0].length; j++) {
//				if (c == arr[i][j]) {
//					check = true;
//				}
//			}
//		}
//		return check;
//	}

	public char[][] SingleSwap(char[][] arr) {
		Scanner input = new Scanner(System.in);
		int row1, row2, col1, col2;
		
		System.out.println("\nCHARACTER 1: ");
		System.out.println("Enter the ROW of the First Character You Would Like to Swap:");
		row1 = input.nextInt();
		System.out.println(arr[row1-1]);
		System.out.println("Enter the COLUMN of the First Character You Would Like to Swap:");
		col1 = input.nextInt();
		System.out.println("Character Chosen: " + arr[row1-1][col1-1]);
		System.out.println("CHARACTER 2: ");
		System.out.println("Enter the ROW of the Character You Would Like to Swap Character 1 With:");
		row2 = input.nextInt();
		System.out.println(arr[row2-1]);
		System.out.println("Enter the COLUMN of the Character You Would Like to Swap Character 1 With:");
		col2 = input.nextInt();
		System.out.println("Character Chosen: " + arr[row2-1][col2-1]);

		char temp = arr[row1-1][col1-1]; // swapping locations
		arr[row1-1][col1-1] = arr[row2-1][col2-1];
		arr[row2-1][col2-1] = temp;
		return arr;
	}
}
