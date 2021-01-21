import java.util.Scanner;

public class SwapperTool extends Tools {

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
	public void fullSwap(char[][] arr) {
//		Scanner input = new Scanner(System.in);
//		char oldChar;
//		char newChar;
//		
//		System.out.println("What is the First Character You Would Like to Swap:");
//		
//		for (int i = 0; i < arr.length; i++) {
//			 
//			for (int j = 0; j < arr[0].length; j++) {
//				
//			}
//		}
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
		row1 += 1;
		System.out.println("Enter the COLUMN of the First Character You Would Like to Swap:");
		col1 = input.nextInt();
		col1 += 1;
		System.out.println("CHARACTER 2: ");
		System.out.println("Enter the ROW of the Character You Would Like to Swap Character 1 With:");
		row2 = input.nextInt();
		row2 += 1;
		System.out.println("Enter the COLUMN of the Character You Would Like to Swap Character 1 With:");
		col2 = input.nextInt();
		col2 += 1;
		
		char temp = arr[row1][col1]; // swapping locations
		arr[row1][col1] = arr[row2][col2];
		arr[row2][col2] = temp;
		return arr;
	}

	public String toString() {
		String info;
		info = "\nThe " + super.getName() + " " + super.getFunction();
		info += "\n***** " + toolSound() + " *****\n";
		return info;
	}
}
