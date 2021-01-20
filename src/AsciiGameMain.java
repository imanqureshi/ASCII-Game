import java.io.*;

public class AsciiGameMain {

	public static void main(String[] args) {
		File doodle = new File("./DoodleGame");
		char[][] artBoard = new char[12][14];

		/* create a new file for Image */ 					// have to add image into text file
		if (!doodle.exists()) {
			try {
				doodle.createNewFile();
				System.out.println("File Created.");
			} catch (IOException err) {
				System.out.println("File could not be created.");
				System.err.println("IOException: " + err.getMessage());
			} finally {
				System.out.println("Finished.");
			}
		}
		readFile(doodle, artBoard);

	}

	/**
	 * reads text file into a 2D array
	 * pre: file must only contain strings
	 * post: contents of text file are stored into 2D array
	 */
	public static void readFile(File file, char[][] arr) {
		FileReader reader;
		BufferedReader br;
		String strRows;

		if (file.exists()) {
			try {
				reader = new FileReader(file);
				br = new BufferedReader(reader);
				for (int i = 0; i < arr.length; i++) {		//iterates through rows of array
					strRows = br.readLine();				//reads each row as a string
					arr[i] = strRows.toCharArray();			//converts string into char 2D array rows
				}
				br.close(); 
				reader.close();
			} catch (IOException err) {
				System.err.println("IOException: " + err.getMessage());
			} finally {
				printArray(arr);
			}
		}
	}

	/**
	 * writes image onto created text file
	 * pre: contents of 2D array must be
	 * strings only 
	 * post: 2D array is written to file
	 */
//	public static void writeFile(File file, char[][] arr) {
//		FileWriter writer;
//		BufferedWriter bw;
//		if (file.exists()) {
//			try {
//				writer = new FileWriter(file);
//				bw = new BufferedWriter(writer);
//				bw.write("placeholder");
//				bw.newLine();
//				bw.write("placeholder");
//				bw.close();
//				writer.close();
//				System.out.println("\nData Written to File.");
//			} catch (IOException err) {
//				System.err.println("IOException: " + err.getMessage());
//			}
//		}
//	}

	/**
	 * prints 2D array of the art txt file. pre:none. post: array is printed.
	 */
	public static void printArray(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * prints options display for user pre:none. post: array is printed.
	 */
	public static void optionsDisplay() {

	}
}
