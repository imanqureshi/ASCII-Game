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
		while (true) {
			if (row > 0 && row <= arr.length) {
				break;
			} else
				System.out.println("Please enter a valid Row.");
			row = input.nextInt();
		}
		System.out.println(arr[row - 1]);
		System.out.println("Enter the COLUMN of the First Character You Would Like to Swap:");
		col = input.nextInt();
		while (true) {
			if (col > 0 && col <= arr[0].length) {
				break;
			} else
				System.out.println("Please enter a valid Column.");
			col = input.nextInt();
		}
		System.out.println("Character Chosen: " + arr[row - 1][col - 1]);

		System.out.println("What character You Would Like to place into the Image: ");
		replacement = input.next().charAt(0);

		arr[row - 1][col - 1] = replacement;

		return arr;
	}

	public char[][] replaceAll(char[][] arr) {
		Scanner input = new Scanner(System.in);
		char char1 = ' ';
		char char2 = ' ';
		String str;

		System.out.println("What is the Character You Would Like to Remove in the Image:");
		char1 = input.next().charAt(0);
		while (!charExists(arr, char1)) {
			System.out.println("Character could not be found. Please try again.");
			char1 = input.next().charAt(0);
			if (charExists(arr, char1)) {
				break;
			}
		}
		System.out.println("What character You Would Like to place into the Image: ");
		char2 = input.next().charAt(0);
		while (!charExists(arr, char2)) {
			System.out.println("Character could not be found. Please try again.");
			char2 = input.next().charAt(0);
			if (charExists(arr, char2)) {
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			str = String.valueOf(arr[i]);
			str = (changeXY(str, char1, char2));
			arr[i] = str.toCharArray();
		}
		return arr;
	}

	public String changeXY(String str, char c1, char c2) {
		char ch;
		if (str.length() == 0)
			return str;
		ch = str.charAt(0);
		if (ch == c1)
			return c2 + changeXY(str.substring(1), c1, c2);
		return ch + changeXY(str.substring(1), c1, c2);
	}

	public char[][] replaceRow(char[][] arr) {
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

		System.out.println("What character You Would Like to place into the Image: ");
		replacement = input.next().charAt(0);

		for (int i = 0; i < arr[row - 1].length; i++) {
			arr[row - 1][i] = replacement;
		}
		return arr;
	}

	public char[][] replaceCol(char[][] arr) {
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
		System.out.println("What character You Would Like to place into the Image: ");
		replacement = input.next().charAt(0);

		for (int i = 0; i < arr.length; i++) {
			arr[i][col - 1] = replacement;
		}
		return arr;
	}

	String toolSound() {
		return "Believe...when I say...I want it replaced!";
	}

}
