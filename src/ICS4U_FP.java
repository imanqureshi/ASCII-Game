import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Iman Qureshi 
 * January 26 2021 
 * ICS4U 
 * This program allows users to create and/or edit an ASCII image using a variety of tools
 */
public class ICS4U_FP {

	public static void main(String[] args) {
		/* variable declaration */
		File doodle;
		char[][] artBoard;
		Designer player;
		int choice;
		Scanner input = new Scanner(System.in);
		FlipperTool ft = new FlipperTool("Flipper Tool", "Flip Image Upside Down or on it's Side");
		SwapperTool st = new SwapperTool("Swapper Tool", "Swap Character(s) within the Image");
		ReplacerTool rt = new ReplacerTool("Replacer Tool", "Replace Character(s) in Image with any Character");
		EraserTool et = new EraserTool("Eraser Tool", "Erase Character(s) in Image");
		SorterTool sortt = new SorterTool("Sorter Tool", "Group Same Characters in Image");
		ArrayList<String> options = new ArrayList<String>();
		String art;

		System.out
				.println("Welcome to Graphics Jam!\nExplore your graphic designing talents in this music based game!");
		System.out.println("\nHi, Designer! Please enter your first name: ");
		player = new Designer(input.next());

		System.out.println("\nHello, " + player.getName() + "! Let's get designing!\n");

		/* creating Graphic Jam files to store art */
		System.out.println("1. Create my own Image\n2. Use default image\n\nEnter your Choice:");
		choice = input.nextInt();
		while (true) {
			if (choice == 1 | choice == 2) {
				break;
			} else {
				System.out.println("Please enter a valid input.");
				choice = input.nextInt();
			}
		}
		System.out.println("What would you like to call your Art?");
		art = input.next();
		
		if (choice == 1) {
			doodle = new File("././My Graphics Jam - " + art + " by " + player.getName());
			try {
				doodle.createNewFile();
			} catch (IOException e) {
				System.out.println("File could not be created.");
				System.err.println("IOException: " + e.getMessage());
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

			doodle = new File("././Graphics Jam - " + art + " by " + player.getName());
			File originalFile = new File("././GraphicsJamDefault");

			if (!doodle.exists()) {
				try {
					Files.copy(originalFile.toPath(), doodle.toPath());
				} catch (IOException e) {
					System.out.println("Oops! It seems like the default drawing is missing!");
					System.err.print("IOException: " + e.getMessage());
				} finally {
					System.out.println("Excellent! Let's get to Work!");
				}
			} else {
				System.out.println("Looks like you've already created an art piece! Let's load it up!");
			}
		}
		System.out.println("\n*** GRAPHICS JAM! ***\n");

		readFile(doodle, artBoard);

		System.out.println(
				"\nShown above is the image that needs redesigning! Use the tools below to revamp this design.");

		options.add(ft.toString());
		options.add(st.toString());
		options.add(rt.toString());
		options.add(et.toString());
		options.add(sortt.toString());
		options.add("Quit");
		System.out.println("\n\t------- ARTIST TOOLS -------\n");
		optionsDisplay(options);

		System.out.println("Enter your Choice: ");
		choice = input.nextInt();

		/* options display controls */
		while (choice != options.size()) {
			while (true) {
				if (choice > 0 && choice < options.size() || choice == options.size()) {
					break;
				}
				System.out.println("Please enter a valid input.");
				choice = input.nextInt();
			}
			if (choice == 1) { // flipper tool
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
					System.out.println(ft.toolSound());
				} else if (choice == 2) {
					ft.horizontalFlip(artBoard);
					System.out.println(ft.toolSound());
				}
			} else if (choice == 2) { // swapper tool
				while (true) {
					System.out.println(
							"\n1. Swap Single Locations\n2. Swap All Locations\n0. <- Back\n\nEnter your Choice: ");
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
					System.out.println(st.toolSound());
				} else if (choice == 2) {
					st.fullSwap(artBoard);
					System.out.println(st.toolSound());
				}
			} else if (choice == 3) { // replacer tool
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
					System.out.println(rt.toolSound());
				} else if (choice == 2) {
					rt.replaceAll(artBoard);
					System.out.println(rt.toolSound());
				} else if (choice == 3) {
					rt.replaceRow(artBoard);
					System.out.println(rt.toolSound());
				} else if (choice == 4) {
					rt.replaceCol(artBoard);
					System.out.println(rt.toolSound());
				}
			} else if (choice == 4) { // eraser tool
				System.out.println(
						"\n1. Erase Single Character\n2. Erase Entire Image\n3. Erase Entire Row\n4. Erase Entire Column\n0. <- Back\n\nEnter your Choice: ");
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
					System.out.println(et.toolSound());
				} else if (choice == 2) {
					et.eraseAll(artBoard);
					System.out.println(et.toolSound());
				} else if (choice == 3) {
					et.eraseRow(artBoard);
					System.out.println(et.toolSound());
				} else if (choice == 4) {
					et.eraseCol(artBoard);
					System.out.println(et.toolSound());
				}
			} else if (choice == 5) { // sorter tool
				System.out.println(
						"1. Sort a Row!\n2. Sort a Column!\n3. Sort all Rows!\n4. Sort all Columns!\n0. <- Back\n\nEnter your Choice:");
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
					System.out.println(sortt.toolSound());
				} else if (choice == 2) {
					sortt.sortCol(artBoard);
					System.out.println(sortt.toolSound());
				} else if (choice == 3) {
					sortt.sortAllRows(artBoard);
					System.out.println(sortt.toolSound());
				} else if (choice == 4) {
					sortt.sortAllCols(artBoard);
					System.out.println(sortt.toolSound());
				}
			}
			System.out.println("Returning to Main Menu...");
			writeFile(doodle, artBoard);
			System.out.println();
			readFile(doodle, artBoard);
			System.out.println("\n\t------- ARTIST TOOLS -------\n");
			optionsDisplay(options);
			System.out.println("Enter your Choice: ");
			choice = input.nextInt();
		}
		if (choice == options.size()) { // quit
			input.close();
			System.out.println("\nThanks for Playing! Here is your final design work!");
			System.out.println(player.toString() + "\n");
			readFile(doodle, artBoard);
			System.out.println("\nPretty Neat, huh?");
		}
	}

	/**
	 * reads text file into a 2D array 
	 * pre: none 
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

	/**
	 * writes contents of a char array into a file 
	 * pre: none 
	 * post: file is overwritten with content from array
	 */
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
	 * prints 2D array of image from text file
	 * pre: none 
	 * post: array is printed
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

	/**
	 * allows users to fill char array character by character 
	 * pre: none 
	 * post: all incices of array are filled
	 * 
	 */
	public static char[][] fillArray(char[][] arr, Scanner input) {
		System.out.println("\nPlease fill each row, character by character:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Filling row: " + (i + 1));
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = input.next().charAt(0);
			}
		}
		System.out.println("\nComplete!");
		return arr;
	}

	/**
	 * prints options display for user 
	 * pre:none 
	 * post: array is printed
	 */
	public static void optionsDisplay(ArrayList<String> options) {
		for (int i = 0; i < options.size(); i++) {
			System.out.println("(" + (i + 1) + ") " + options.get(i) + " ");
		}

	}
}
