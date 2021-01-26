public class FlipperTool extends Tool {

	/* constructor */
	public FlipperTool(String ftname, String func) {
		super(ftname, func);
	}

	/**
	 * returns special sound made by using flipper tool pre: none post: sound of
	 * tool (lyric) is returned
	 */
	String toolSound() {
		String sound;
		sound = "____________________________________________";
		sound += "\n\nI just flipped the switch...Flip, Flip!";
		sound += "\n____________________________________________";
		return sound;
	}

	/**
	 * vertically flips image pre: 2D array must exist post: 2D array is flipped
	 * upside down.
	 */
	public char[][] verticalFlip(char[][] arr) {
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length / 2; i++) {
				char temp = arr[i][j];
				arr[i][j] = arr[arr.length - i - 1][j];
				arr[arr.length - i - 1][j] = temp;
			}
		}
		return arr;
	}

	/**
	 * horizontally flips image pre: 2D array must exist post: 2D array is flipped
	 * horizontally
	 */
	public char[][] horizontalFlip(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				char temp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length - j - 1];
				arr[i][arr[i].length - j - 1] = temp;
			}
		}
		return arr;
	}
}
