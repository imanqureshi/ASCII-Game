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
		System.out.println(arr[row-1]);
		System.out.println("Enter the COLUMN of the First Character You Would Like to Erase:");
		col = input.nextInt();
		System.out.println("Character Chosen: " + arr[row-1][col-1]);

		arr[row][col]  = ' ';
		
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
