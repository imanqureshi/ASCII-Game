import java.io.*;
import java.util.Scanner;

public class ICS4U_FP {

	public static void main(String[] args) {
		File doodle = new File("./DoodleGame");
		Scanner input = new Scanner(System.in);
		char[][] artBoard = new char[12][14];
		Designer player;
		int choice;
		FlipperTool ft = new FlipperTool("Flipper Tool", "flips image upside down!");
		SwapperTool st = new SwapperTool("Swapper Tool", "swaps a single character in image with another!");
		

		System.out
				.println("Welcome to Graphics Jam!\nExplore your graphic designing talents in this music based game!");
		System.out.println("\nPlease enter your designer name: ");
		player = new Designer(input.next());

		System.out.println("\nExcellent! Let's get designing!");

		/* create a new file for Image */ // have to add image into text file
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
		
		System.out.println(
				"\nShown above is the image that needs redesigning! Use the tools below to revamp this design.");

		optionsDisplay();
		System.out.println("Enter a Choice Number: ");
		choice = input.nextInt();

		while (choice != 8) {
			if (choice == 1) {
				System.out.println("Working the Flipper Tool...");
				ft.verticalFlip(artBoard);
				System.out.println(ft.toString());
			} else if (choice == 2) {
				ft.horizontalFlip(artBoard);
				System.out.println(ft.toString());
			} else if (choice == 3) {
				st.SingleSwap(artBoard);
				System.out.println(st.toString());
			} else if (choice == 4) {

			} else if (choice == 5) {

			} else if (choice == 6) {

			} else if (choice == 7) {
			}
			
			writeFile(doodle, artBoard);
			System.out.println();
			readFile(doodle, artBoard);
			optionsDisplay();
			System.out.println("Enter a Choice Number: ");
			choice = input.nextInt();
		}

		if (choice == 8) {
			input.close();
			System.out.println("Thanks for Playing! Here is your final design work!");
			System.out.println(player.toString());
			readFile(doodle, artBoard);
			System.out.println("\nPretty Neat, huh?");
		}
	}

	/**
	 * reads text file into a 2D array pre: file must only contain strings post:
	 * contents of text file are stored into 2D array
	 */
	public static void readFile(File file, char[][] arr) {
		FileReader reader;
		BufferedReader br;
		String strRows;

		if (file.exists()) {
			try {
				reader = new FileReader(file);
				br = new BufferedReader(reader);
				for (int i = 0; i < arr.length; i++) { // iterates through rows of array
					strRows = br.readLine(); // reads each row as a string
					arr[i] = strRows.toCharArray(); // converts string into char 2D array rows
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
	
	public static void writeFile(File file, char[][] arr) {
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
		System.out.println("\n****ARTIST TOOLS****\n" 
				+ "1. Flipper Tool (Flips Image upside down!)\n"
				+ "2. Flipper Tool (Flip Image Horizontally!)\n"
				+ "3. Single Swapper Tool (Swap a character in file with character of your choice!\n"
				+ "4. Full Swapper Tool(Swap all locations of a character in file with character of your choice!\n"
				+ "5. Sort Tools Alphabetically\n"
				+ "6. Eraser Tool\n"
				+ "7. Reset Image\n" 
				+ "8. Quit\n");

	}
}
