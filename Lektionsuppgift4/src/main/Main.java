package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String path = "src/Materiallista.csv";
		String line = "";
		// ArrayListMatrix
		ArrayList<ArrayList<String>> listX = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < 3; i++) {
			ArrayList<String> listY = new ArrayList<String>();
			listX.add(listY);
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					// Checks for empty cells
					if (line.split(",").length == 3) {
						for (int i = 0; i < 3; i++) {
							listX.get(i).add(line.split(",")[i]);
						}
					} else {
						listX.get(0).add(line.split(",")[0]);
						listX.get(1).add("0");
						listX.get(2).add("0");
					}
				}
			}
			System.out.println("Pre change");
			Printout(listX);
			for (int i = 2; i < listX.get(0).size(); i++) {
				String[] amount = listX.get(1).get(i).split(" ");
				listX.get(2).set(i, String.valueOf(
						Integer.parseInt(amount[0]) * Integer.parseInt(amount[1].split("x")[1].split("\\)")[0])));
			}
			System.out.println("Post change");
			Printout(listX);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Prints out the document
	private static void Printout(ArrayList<ArrayList<String>> listX) {
		for (int i = 0; i < listX.get(0).size(); i++) {
			System.out.println(listX.get(0).get(i) + ", " + listX.get(1).get(i) + ", " + listX.get(2).get(i));
		}
	}
}
