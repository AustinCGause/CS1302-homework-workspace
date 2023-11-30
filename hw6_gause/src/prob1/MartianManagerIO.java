package prob1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import prob2.*;

public class MartianManagerIO {

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static void writeMartians(String fileName, MartianManager mm) {
		File file = new File(fileName);
        try {
			writeMartiansFile(file, mm);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error writing file");
			e.printStackTrace();
		}
	}
	
	/**
	 *  YOU  WRITE THIS METHOD.
	 *  
	 *  Write the martians in the MartianManager to the file. The format is exactly the same
	 *  as specified in the homework document for reading valid data: G I V or R I V T.
	 */
	private static void writeMartiansFile(File file, MartianManager mm) throws FileNotFoundException {

		try(PrintWriter printWriter = new PrintWriter(file)) {
			for (Martian martian : mm.getSortedMartians()) {

				if (martian instanceof GreenMartian) {
					printWriter.printf("G %d %d%n", martian.getId(), martian.getVolume());
				} else if (martian instanceof RedMartian) {
					printWriter.printf("R %d %d %d%n", martian.getId(), martian.getVolume(), ((RedMartian)martian).getTenacity());
				}

			}
		}
		
	}

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static ReadReport readMartians(String fileName) {
		File file = new File(fileName);
		ReadReport report = null;
        try {
			report = readMartiansFile(file);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		return report;
	}
	
	/**
	 * YOU WRITE THIS METHOD.
	 * 
	 * Reads a text file that contains Martian data and returns a ReadReport object. Details
	 * are in the homework document. 
	 * 
	 * @param file
	 * @return
	 * @throws RuntimeException
	 * @throws FileNotFoundException
	 */
	private static ReadReport readMartiansFile(File file) throws RuntimeException, FileNotFoundException {
		String filename = file.getName();
		
		int numLinesRead = 0;
		int numSuccessfullyAdded = 0;
		int numAlreadyExist = 0;
		int numIllFormed = 0;

		MartianManager mm = new MartianManager();

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(" ");

				numLinesRead++;

				if (isValidGreenMartian(parts)) {

					if (mm.addMartian(new GreenMartian(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])))) {
						numSuccessfullyAdded++;
					} else { numAlreadyExist++; }

				} else if (isValidRedMartian(parts)) {

					if (mm.addMartian(new RedMartian(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])))) {
						numSuccessfullyAdded++;
					} else { numAlreadyExist++; }

				} else { 
					numIllFormed++; 
				}
			}
		}

		return new ReadReport(mm, filename, numLinesRead, numSuccessfullyAdded, numAlreadyExist, numIllFormed);
	}

	// utility methods
	private static boolean isValidGreenMartian(String[] parts) {
		if (parts.length != 3) return false;
		if (!parts[0].equals("G")) return false;
		return isInteger(parts[1]) && isInteger(parts[2]);
	}

	private static boolean isValidRedMartian(String[] parts) {
		if (parts.length != 4) return false;
		if (!parts[0].equals("R")) return false;
		return isInteger(parts[1]) && isInteger(parts[2]) && isInteger(parts[3]);
	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
