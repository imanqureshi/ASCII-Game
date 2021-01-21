import java.util.Scanner;

public class ReplacerTool extends Tool {
	
	/* constructor */
	public ReplacerTool(String rtname, String func) {
		super(rtname, func);
	}
	
	
	public char[][] replaceSingle(char[][] arr) {
		int row, col;
		Scanner input = new Scanner(System.in);
		char replacement;
		
		System.out.println("Enter the ROW of the First Character You Would Like to Swap:");
		row = input.nextInt();
		System.out.println(arr[row-1]);
		System.out.println("Enter the COLUMN of the First Character You Would Like to Swap:");
		col = input.nextInt();
		System.out.println("Character Chosen: " + arr[row-1][col-1]);
		
		System.out.println("What character You Would Like to place into the Image: ");
		replacement = input.next().charAt(0);
		
		arr[row-1][col-1] = replacement;
		
		return arr;
	}
	
	public char[][] replaceAll(char[][] arr) {
		Scanner input = new Scanner(System.in);
		char char1 = ' ';
		char char2 = ' ';
		
		while (char1 != '$' || char1 != '-' || char1 != '|' ||char1 != '.' ) {
			System.out.println("What is the Character You Would Like to Remove in the Image:");
			char1 = input.next().charAt(0);
		}
		
		System.out.println("What character You Would Like to place into the Image: ");
		char2 = input.next().charAt(0);
	
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == char1) {
						arr[i][j] = char2;
					}
				}
			}
		return arr;
	}
	
	String toolSound() {
		return "Believe...when I say...I want it replaced!";
	}


}
