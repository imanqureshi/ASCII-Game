import java.io.*;

public class FlipperTool extends Tools {

	/*constructor*/
	public FlipperTool(String ftname, String func) {
		super(ftname, func);
	}
	
	/**
	 * returns special sound made by using flipper tool
	 * pre: none
	 * post: sound of tool (lyric) is returned 
	 */
	String toolSound() {
		return "I just flipped the switch...Flip Flip";
	}

	/**
	 * vertically flips image
	 * pre: 2D array must exist
	 * post: 2D array is flipped upside down.
	 */
	public void verticalFlip(char[][] arr) {
		char[][] temp = new char[arr.length][arr[0].length];

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print("\n");
			for (int j = arr[i].length - 1; j >= 0; j--) {
				temp[i][j] = arr[i][j];
			}
		}
	}
	
	/**
	 * horizontally flips image
	 * pre: 2D array must exist
	 * post: 2D array is flipped horizontally
	 */
	public void horizontalFlip(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int start = 0;
			int end = arr.length - 1;
			while (start < end) { // while start < end, we swap the elements
				// Swap the element
				char temp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = temp;
				start++;
				end--;
			}
		}
	}

	/**
	 * prints information about flipper tool
	 * pre: none
	 * post: flipper tool info is returned.
	 */
	public String toString() {
		String info;
		info = "\nThe " + super.getName() + " " + super.getFunction();
		info += "\n***** " + toolSound() + " *****\n";
		return info;
	}
}
