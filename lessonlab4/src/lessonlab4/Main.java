package lessonlab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static boolean meetsThreshold(double threshold, double actual) {
		// System.out.println(threshold + "," + actual);
		if (actual >= threshold) {
			return true;
		} else {
			return false;
		}
	}

	private static Plants processFile(File newfile) throws ParseException {
		Plants plants = new Plants();

		// https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
		try (BufferedReader reader = new BufferedReader(new FileReader(newfile))) {
			String line;

			// reading line 1
			line = reader.readLine();
			if (line != null && !line.isEmpty()) {
				plants.setNameOfSoil(line);
			} else {
				throw new ParseException("file is empty: " + newfile.getName(), 1);
			}
			// reading line 2
			line = reader.readLine();
			if (line != null && !line.isEmpty()) {
				plants.setMultiplier(Integer.parseInt(line));
			} else {
				throw new ParseException("missing multiplier from file: " + newfile.getName(), 2);
			}
			// reading line 3
			line = reader.readLine();
			if (line != null && !line.isEmpty()) {
				plants.setHeightThreshold(Double.parseDouble(line));
			} else {
				throw new ParseException("Missing the hieght threshold: " + newfile.getName(), 3);
			}
			// reading line 4
			line = reader.readLine();
			if (line != null && !line.isEmpty()) {
				plants.setLeaveThreshold(Integer.parseInt(line));
			} else {
				throw new ParseException("Missing the amount of leaves: " + newfile.getName(), 4);
			}
			System.out.println(plants);

			line = reader.readLine();
			if (line == null || line.isEmpty()) {
				System.out.println("There were no plants grown in soil: " + plants.getNameOfSoil());
			} else {
				while (line != null && !line.isEmpty()) {
					PlantRecord record = new PlantRecord();
					// reading line with the plants number
					// line = reader.readLine();
					if (line != null && !line.isEmpty()) {
						record.setNumberSample(Integer.parseInt(line));
					} else {
						throw new ParseException("There is no plant number: " + newfile.getName(), 1);
					}
					// reading line 1
					line = reader.readLine();
					if (line != null && !line.isEmpty()) {
						record.setHeight(Double.parseDouble(line));
					} else {
						throw new ParseException("the plant height is not given: " + newfile.getName(), 2);
					}
					// reading line 1
					line = reader.readLine();
					if (line != null && !line.isEmpty()) {
						record.setNumLeaves(Integer.parseInt(line));
					} else {
						throw new ParseException("they did not say the amount of leaves given: " + newfile.getName(),
								3);
					}

					if (meetsThreshold(plants.getHeightThreshold(), record.getHeight())) {
						System.out.println(record);
						plants.addRecord(true);
					} else {
						plants.addRecord(false);
					}

					line = reader.readLine();
				}
				double percentage;
				double total;
				total = plants.getMeetsThresholdCounter() + plants.getDoesNotMeetThresholdCounter();
				percentage = (plants.getMeetsThresholdCounter()/total) * 100.0;
				System.out.println("% Meets Threshold: " + percentage);
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		return plants;
	}

	public static void main(String[] args) {
		// String filename = "doesnotexist.txt";
		// String filename = "header-and-multiple-records.txt";
		// String filename = "empty-file.txt";
		// String filename = "header-only.txt";
		String filename;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("what is the name of the file? ");
		filename = keyboard.next();

		File newfile = new File(filename);

		try {
			if (newfile.exists()) {
				System.out.println("processing file: " + newfile.getName());
				Plants plants = processFile(newfile);

			} else {
				System.out.println("File was not found: " + newfile.getName());
			}
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

	}

}
