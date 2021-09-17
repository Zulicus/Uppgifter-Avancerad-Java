package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String path = "src/Materiallista.json";
		String line = "";
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					
					
				}
			}		
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
