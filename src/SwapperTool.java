import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SwapperTool extends Tools {

	/*constructor*/
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
	 * writes upside down image onto created text file 
	 * pre: contents of 2D array
	 * must be strings only 
	 * post: 2D array is written to file
	 */
	public void fullSwap(char[][] arr, char old, char newChar) {
	

	}

	public void writetoFile(File file, char[][] arr) {
		FileWriter writer;
		BufferedWriter bw;

		if (file.exists()) {
			try {
				writer = new FileWriter(file);
				bw = new BufferedWriter(writer);
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[0].length; j++) {
						bw.write(arr[i][j]);
					}
					bw.newLine();
				}
				bw.close();
				writer.close();
			} catch (IOException err) {
				System.err.println("IOException: " + err.getMessage());
			}
		}
	}

	public void writeSingleSwap(File file, char[][] arr) {

		
	}

	public String toString() {
		String info;
		info = "\nThe " + super.getName() + " " + super.getFunction();
		info += "\n***** " + toolSound() + " *****\n";
		return info;
	}
}


