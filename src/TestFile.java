import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TestFile {

	public static void main(String[] args) {
		File f = new File("./testimage");
		char[][] arr = new char[12][14];
		int choice;
		Scanner input = new Scanner(System.in);

		if (!f.exists()) {
			try {
				f.createNewFile();
				System.out.println("File Created.");
			} catch (IOException err) {
				System.out.println("File could not be created.");
				System.err.println("IOException: " + err.getMessage());
			} finally {
				System.out.println("Finished.");
			}
		}
		readFile(f, arr);
		
		System.out.println("Enter a Choice Number: ");
		choice = input.nextInt();

		while (choice != 8) {
			if (choice == 1) {
				System.out.println("Working the Flipper Tool...");
				FlipperTool ft = new FlipperTool("Flipper Tool", "flips image upside down!");
				ft.verticalFlip(arr);
				writeFile(f, arr);
				readFile(f, arr);
				System.out.println(ft.toString());
			} else if (choice == 2) {
				FlipperTool ft = new FlipperTool("Flipper Tool", "flips image horizontally!");
				ft.horizontalFlip(arr);
				System.out.println(ft.toString());
			} else if (choice == 3) {
				SwapperTool st = new SwapperTool("Swapper Tool", "swaps single characters in image");
				st.SingleSwap(arr);
			} else if (choice == 4) {

			} else if (choice == 5) {

			} else if (choice == 6) {

			} else if (choice == 7) {

			}
			writeFile(f, arr);
			System.out.println();
			readFile(f, arr);
			System.out.println("Enter a Choice Number: ");
			choice = input.nextInt();
		}

	}

public static char[][] readFile(File file, char[][] arr) {
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
		return arr;
	}

	public static void printArray(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
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
}
