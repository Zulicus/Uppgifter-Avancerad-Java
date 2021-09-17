package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Main {
	static ArrayList<Row> list = new ArrayList<Row>();
	static String path = "src/sample.csv";

	public static void main(String[] args) {
		ReadFile();
		StartUi();
	}

	// reads the file
	private static void ReadFile() {
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					// Sends the line to the Row Class
					Row row = new Row(line);
					list.add(row);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Creates and handles the UI
	public static void StartUi() {
		JFrame frame = new JFrame("Reader");
		// Converts the Rows into a matrix of ArrayLists
		ArrayList<ArrayList<String>> mainList = new ArrayList<ArrayList<String>>();
		for (int i = 1; i < list.size(); i++) {
			ArrayList<String> itemList = new ArrayList<String>();
			itemList.add(list.get(i).getOrderDate());
			itemList.add(list.get(i).getRegion());
			itemList.add(list.get(i).getRep1());
			itemList.add(list.get(i).getRep2());
			itemList.add(list.get(i).getItem());
			itemList.add(list.get(i).getUnits());
			itemList.add(list.get(i).getUnitCost());
			itemList.add(list.get(i).getTotal());
			mainList.add(itemList);
		}
		// This line of code converts the ArrayList matrix into a String matrix
		String[][] data = mainList.stream().map(item -> item.toArray(new String[0])).toArray(String[][]::new);
		String[] columnNames = { list.get(0).getOrderDate(), list.get(0).getRegion(), list.get(0).getRep1(),
				list.get(0).getRep2(), list.get(0).getItem(), list.get(0).getUnits(), list.get(0).getUnitCost(),
				list.get(0).getTotal() };
		JTable table = new JTable(data, columnNames);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
			// Prevents a user from freely changing the values inside the cells
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		// Prevents the user from sorting by column 1, 6, 7 and 8
		sorter.setSortable(0, false);
		sorter.setSortable(5, false);
		sorter.setSortable(6, false);
		sorter.setSortable(7, false);
		table.setRowSorter(sorter);
		// Prevents the user from moving the columns arround
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(30, 30, 820, 400);
		frame.add(pane);

		JTextField input1 = new JTextField();
		JTextField input2 = new JTextField();
		JTextField input3 = new JTextField();
		JTextField input4 = new JTextField();
		JTextField input5 = new JTextField();
		JTextField input6 = new JTextField();
		JTextField input7 = new JTextField();
		JTextField input8 = new JTextField();
		input1.setBounds(30, 450, 100, 25);
		input2.setBounds(131, 450, 100, 25);
		input3.setBounds(232, 450, 100, 25);
		input4.setBounds(333, 450, 100, 25);
		input5.setBounds(434, 450, 100, 25);
		input6.setBounds(535, 450, 100, 25);
		input7.setBounds(636, 450, 100, 25);
		input8.setBounds(737, 450, 100, 25);
		frame.add(input1);
		frame.add(input2);
		frame.add(input3);
		frame.add(input4);
		frame.add(input5);
		frame.add(input6);
		frame.add(input7);
		frame.add(input8);

		JButton submit = new JButton("Submit");
		submit.setBounds(737, 487, 100, 25);
		frame.add(submit);
		// Adds the information in the fields to the list
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (input1.getText().equals("") || input2.getText().equals("") || input3.getText().equals("")
						|| input4.getText().equals("") || input5.getText().equals("") || input6.getText().equals("")
						|| input7.getText().equals("") || input8.getText().equals("")) {

				} else {
					String input = input1.getText() + "," + input2.getText() + "," + input3.getText() + ","
							+ input4.getText() + "," + input5.getText() + "," + input6.getText() + ","
							+ input7.getText() + "," + input8.getText();
					list.add(new Row(input));
					tableModel.addRow(new Object[] { input1.getText(), input2.getText(), input3.getText(),
							input4.getText(), input5.getText(), input6.getText(), input7.getText(), input8.getText() });
				}
				input1.setText(null);
				input2.setText(null);
				input3.setText(null);
				input4.setText(null);
				input5.setText(null);
				input6.setText(null);
				input7.setText(null);
				input8.setText(null);

			}
		});

		JButton save = new JButton("Save");
		save.setBounds(737, 525, 100, 25);
		frame.add(save);
		// Saves the New info to the file
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(path);
				try {
					new PrintWriter(path).close();
					PrintWriter writer = new PrintWriter(file);
					for (int i = 0; i < list.size(); i++) {
						writer.println(list.get(i).get());
					}
					writer.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}

		});

		JLabel message = new JLabel("Add New Row:");
		message.setBounds(30, 427, 100, 25);
		frame.add(message);

		frame.setSize(900, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
