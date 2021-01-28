import java.util.Scanner;

/**
 * Iman Qureshi 
 * January 26 2021 
 * ICS4U 
 * This program creates the characteristics for a eraser tool.
 */
public class EraserTool extends Tool {

	/*constructor*/
	public EraserTool(String etName, String func) {
		super(etName, func);
	}
	/**
	 * returns special sound made by using eraser tool
	 * pre: none 
	 * post: sound of tool (lyric) is returned
	 */
	String toolSound() {
		String sound;
		sound = "______________________________________________";
		sound += "\n\nNow you're just an image that I used to know.";
		sound += "\n______________________________________________";
		return sound;
	}
	/**
	 * allows user to erase single character from image 
	 * pre: none
	 * post: chosen character is replaced with empty space 
	 */
	public char[][] eraseSingle(char[][] arr) {
		int row, col;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the ROW of the First Character You Would Like to Erase:");
		row = input.nextInt();
		while (true) {
			if (row > 0 && row <= arr.length) {
				break;
			} else
				System.out.println("Please enter a valid Row.");
			row = input.nextInt();
		}
		System.out.println("\nSelected Row... ");
		for (int i = 0; i < arr[0].length; i++) {
			System.out.print(arr[row - 1][i] + " ");
		}
		System.out.println("\nEnter the COLUMN of the First Character You Would Like to Erase:");
		col = input.nextInt();
		while (true) {
			if (col > 0 && col <= arr[0].length) {
				break;
			} else
				System.out.println("Please enter a valid Column.");
			col = input.nextInt();
		}
		System.out.println("Character Chosen: " + arr[row - 1][col - 1]);

		arr[row - 1][col - 1] = ' ';

		return arr;
	}
	/**
	 * allows user to erase single row from image 
	 * pre: none
	 * post: columns in chosen row are replaced with empty spaces 
	 */
	public char[][] eraseRow(char[][] arr) {
		Scanner input = new Scanner(System.in);
		int row;
		char replacement;

		System.out.println("Which row would you like to replace?");
		row = input.nextInt();
		while (true) {
			if (row > 0 && row <= arr.length) {
				break;
			} else
				System.out.println("Please enter a valid Row.");
			row = input.nextInt();
		}
		System.out.println("\nSelected Row... ");
		for (int i = 0; i < arr[0].length; i++) {
			System.out.print(arr[row - 1][i] + " ");
		}
		for (int i = 0; i < arr[row - 1].length; i++) {
			arr[row - 1][i] = ' ';
		}
		return arr;
	}
	/**
	 * allows user to erase single column from image 
	 * pre: none
	 * post: rows in chosen column are replaced with empty spaces 
	 */
	public char[][] eraseCol(char[][] arr) {
		Scanner input = new Scanner(System.in);
		int col;
		char replacement;

		System.out.println("Which Column would you like to replace?");
		col = input.nextInt();
		while (true) {
			if (col > 0 && col <= arr[0].length) {
				break;
			} else
				System.out.println("Please enter a valid Column.");
			col = input.nextInt();
		}
		System.out.print("Column Chosen: \n");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][col - 1]);
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i][col - 1] = ' ';
		}
		return arr;
	}
	/**
	 * allows user to erase all characters from image 
	 * pre: none
	 * post: whole array is filled with empty spaces
	 */
	public char[][] eraseAll(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = ' ';
			}
		}
		return arr;
	}
}
