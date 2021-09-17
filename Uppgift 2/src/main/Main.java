package main;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public static void main(String[] args) {
		ReadFile();
		StartUi();
	}

	private static void ReadFile() {
		String path = "src/sample.csv";
		String line = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (line != null) {
				line = br.readLine();

				if (line != null) {
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

	public static void StartUi() {
		JFrame frame = new JFrame("Reader");
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
		String[][] data = mainList.stream().map(item -> item.toArray(new String[0])).toArray(String[][]::new);
		String[] columnNames = { list.get(0).getOrderDate(), list.get(0).getRegion(), list.get(0).getRep1(),
				list.get(0).getRep2(), list.get(0).getItem(), list.get(0).getUnits(), list.get(0).getUnitCost(),
				list.get(0).getTotal() };
		JTable table = new JTable(data, columnNames);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		table.setModel(tableModel);
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		sorter.setSortable(0, false); 
		sorter.setSortable(5, false); 
		sorter.setSortable(6, false); 
		sorter.setSortable(7, false); 
		table.setRowSorter(sorter);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(30, 30, 820, 400);
		frame.add(pane);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(737,500,100,25);
		frame.add(submit);
		
		JTextField input1 = new JTextField();
		JTextField input2 = new JTextField();
		JTextField input3 = new JTextField();
		JTextField input4 = new JTextField();
		JTextField input5 = new JTextField();
		JTextField input6 = new JTextField();
		JTextField input7 = new JTextField();
		JTextField input8 = new JTextField();
		input1.setBounds(30,450,100,25);
		input2.setBounds(131,450,100,25);
		input3.setBounds(232,450,100,25);
		input4.setBounds(333,450,100,25);
		input5.setBounds(434,450,100,25);
		input6.setBounds(535,450,100,25);
		input7.setBounds(636,450,100,25);
		input8.setBounds(737,450,100,25);
		frame.add(input1);
		frame.add(input2);
		frame.add(input3);
		frame.add(input4);
		frame.add(input5);
		frame.add(input6);
		frame.add(input7);
		frame.add(input8);
		
		JLabel message=new JLabel("Add New Row:");
		message.setBounds(30,427,100,25);frame.add(message);

		frame.setSize(900, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
