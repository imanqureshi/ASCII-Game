import java.io.*;
import java.util.*;

public class ICS4U_FP {

	public static void main(String[] args) {
		File doodle;
		Scanner input = new Scanner(System.in);
		char[][] artBoard;
		Designer player;
		int choice;
		FlipperTool ft = new FlipperTool("Flipper Tool", "flipped image!");
		SwapperTool st = new SwapperTool("Swapper Tool", "swapped character(s) in image with another!");
		ReplacerTool rt = new ReplacerTool("Replacer Tool", "replaced character(s) in image!");
		EraserTool et = new EraserTool("Eraser Tool", "erased character(s) from image!");
		SorterTool sortt = new SorterTool("Sorter Tool", "sorted and grouped same elements in the image!");
		System.out
				.println("Welcome to Graphics Jam!\nExplore your graphic designing talents in this music based game!");
		System.out.println("\nPlease enter your designer name: ");
		player = new Designer(input.next());

		System.out.println("\nHello, " + player.getName() + "! Let's get designing!\n");

		System.out.println("1. Create my own Image\n2. Use default image\n\nEnter you Choice:");
		choice = input.nextInt();
		while (true) {
			if (choice == 1 | choice == 2) {
				break;
			} else {
				System.out.println("Please enter a valid input.");
				choice = input.nextInt();
			}
		}
		if (choice == 1) {
			doodle = new File("././GraphicsJam" + player.getName());
			try {
				doodle.createNewFile();
			} catch (IOException err) {
				System.out.println("File could not be created.");
				System.err.println("IOException: " + err.getMessage());
			} finally {
				System.out.println("New Graphics Board being Created...\n");
			}

			System.out.println("Please enter how many rows you would like your image to be");
			int rows = input.nextInt();
			System.out.println("Please enter how many columns you would like you image to be");
			int cols = input.nextInt();

			artBoard = new char[rows][cols];
			System.out.println("Excellent! Let's create your image!");
			fillArray(artBoard, input);
			writeFile(doodle, artBoard);

		} else {
			artBoard = new char[12][14];
			doodle = new File("././GraphicsJamDefault");
			/* create a new file for Image */ // have to add image into text file
			if (!doodle.exists()) {
				try {
					doodle.createNewFile();
				} catch (IOException err) {
					System.out.println("File could not be created.");
					System.err.println("IOException: " + err.getMessage());
				} finally {
					System.out.println("Preparing Default Image...");
				}
			}
//			fillDefault(artBoard);
		}
		System.out.println("\n*** GRAPHICS JAM! ***\n");
		
		readFile(doodle, artBoard);

		System.out.println(
				"\nShown above is the image that needs redesigning! Use the tools below to revamp this design.");

		optionsDisplay();
		System.out.println("Enter a Choice Number: ");
		choice = input.nextInt();

		while (choice != 0) {
			while (true) {
				if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 0) {
					break;
				}
				System.out.println("Please enter a valid input.");
				choice = input.nextInt();
			}
			if (choice == 1) {
				System.out.println("\n1. Flip Upside Down\n2. Flip Sides\n0. <- Back\n\nEnter your Choice: ");
				choice = input.nextInt();
				while (true) {
					if (choice == 1 || choice == 2 || choice == 0) {
						break;
					} else {
						System.out.println("Please enter a valid input.");
						choice = input.nextInt();
					}
				}
					if (choice == 1) {
						ft.verticalFlip(artBoard);
						System.out.println(ft.toString());
					} else if (choice == 2) {
						ft.horizontalFlip(artBoard);
						System.out.println(ft.toString());
					}
			} else if (choice == 2) {
				while (true) {
					System.out
							.println("\n1. Swap Single Locations\n2. Swap All Locations\n0. <- Back\n\nEnter your Choice: ");
					choice = input.nextInt();
					if (choice == 1 || choice == 2 || choice == 0) {
						break;
					} else {
						System.out.println("Please enter a valid input.");
						choice = input.nextInt();
					}
				}
				if (choice == 1) {
					st.SingleSwap(artBoard);
					System.out.println(st.toString());
				} else if (choice == 2) {
					st.fullSwap(artBoard);
					System.out.println(st.toString());
				}
			} else if (choice == 3) {
				System.out.println(
						"\n1. Replace Single Locations\n2. Replace All Locations\n3. Replace a Row\n4. Replace a Column\n0. <- Back\n\nEnter your Choice: ");
				choice = input.nextInt();
				while (true) {
					if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 0) {
						break;
					} else {
						System.out.println("Please enter a valid input.");
						choice = input.nextInt();
					}
				}
				if (choice == 1) {
					rt.replaceSingle(artBoard);
					System.out.println(rt.toString());
				} else if (choice == 2) {
					rt.replaceAll(artBoard);
					System.out.println(rt.toString());
				} else if (choice == 3) {
					rt.replaceRow(artBoard);
					System.out.println(rt.toString());
				} else if (choice == 4) {
					rt.replaceCol(artBoard);
					System.out.println(rt.toString());
				}
			} else if (choice == 4) {
				System.out.println("\n1. Erase Single Character\n2. Erase Entire Image\n3. Erase Entire Row\n4. Erase Entire Column\n0. <- Back\n\nEnter your Choice: ");
				choice = input.nextInt();
				while (true) {
					if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 0) {
						break;
					} else {
						System.out.println("Please enter a valid input.");
						choice = input.nextInt();
					}
				}
				if (choice == 1) {
					et.eraseSingle(artBoard);
					System.out.println(et.toString());
				} else if (choice == 2) {
					et.eraseAll(artBoard);
					System.out.println(et.toString());
				} else if (choice == 3) {
					et.eraseRow(artBoard);
					System.out.println(et.toString());
				} else if (choice == 4) {
					et.eraseCol(artBoard);
					System.out.println(et.toString());
				}
			} else if (choice == 5) {
				System.out.println("1. Sort a Row!\n2. Sort a Column!\n3. Sort all Rows!\n4. Sort all Columns!\n0. <- Back\n\nEnter your Choice:");
				choice = input.nextInt();
				while (true) {
					if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 0) {
						break;
					} else {
						System.out.println("Please enter a valid input.");
						choice = input.nextInt();
					}
				}
				if (choice == 1) {
					sortt.sortRow(artBoard);
					System.out.println(sortt.toString());
				} else if (choice == 2) {
					sortt.sortCol(artBoard);
					System.out.println(sortt.toString());
				} else if (choice == 3) {
					sortt.sortAllRows(artBoard);
					System.out.println(sortt.toString());
				} else if (choice == 4) {
					sortt.sortAllCols(artBoard);
					System.out.println(sortt.toString());
				}
			}
			System.out.println("Returning to Main Menu...");
			writeFile(doodle, artBoard);
			System.out.println();
			readFile(doodle, artBoard);
			optionsDisplay();
			System.out.println("Enter a Choice Number: ");
			choice = input.nextInt();
		}
		if (choice == 0) {
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
			if (i < 9) {
				System.out.print("R" + (i + 1) + ":  ");
			} else
				System.out.print("R" + (i + 1) + ": ");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void fillArray(char[][] arr, Scanner input) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("\nFilling row: " + (i + 1) + "...");
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = input.next().charAt(0);
			}
		}
		System.out.println("\nComplete!");
	}

	/**
	 * prints options display for user pre:none. post: array is printed.
	 */
	public static void optionsDisplay() {
		System.out.println("\n****ARTIST TOOLS****\n" 
				+ "1. Flipper Tool (Flips Image upside down or on it's side)!\n"
				+ "2. Swapper Tool (Swap character(s) with another)!\n"
				+ "3. Replacer Tool (Replace character(s) with characeter of your choosing)!\n"
				+ "4. Eraser Tool (Erase character(s) in image)!\n"
				+ "5. Sorter Tool (Groups same characters in rows, columns, or enitre image)!\n" 
				+ "0. Quit\n");
	}
}
