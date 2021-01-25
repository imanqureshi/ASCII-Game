import java.util.Scanner;

public class EraserTool extends Tool {

	public EraserTool(String etName, String func) {
		super(etName, func);
	}

	String toolSound() {
		return "Now it's just an image that I used to know";
	}
	
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
		System.out.println(arr[row-1]);
		System.out.println("Enter the COLUMN of the First Character You Would Like to Erase:");
		col = input.nextInt();
		while (true) {
			if (col > 0 && col <= arr[0].length) {
				break;
			} else
				System.out.println("Please enter a valid Column.");
				col = input.nextInt();
		}
		System.out.println("Character Chosen: " + arr[row-1][col-1]);

		arr[row-1][col-1]  = ' ';
		
		return arr;
	}
	
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
		System.out.print("Row Chosen: ");
		System.out.println(arr[row - 1]);

		for (int i = 0; i < arr[row - 1].length; i++) {
			arr[row - 1][i] = ' ';
		}
		return arr;
	}

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
	
	public char[][] eraseAll(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = ' ';
			}
		}
		return arr;
	}
}
