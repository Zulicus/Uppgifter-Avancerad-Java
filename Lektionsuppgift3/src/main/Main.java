package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) {
		JLabel message = new JLabel("3*6+4-(6/3)");
		JFrame frame = new JFrame("Lektionsuppgift 3");
		JButton btn = new JButton("Calculate");
		btn.setBounds(125, 50, 100, 25);
		message.setBounds(50, 50, 75, 25);
		frame.add(btn);
		frame.add(message);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = 3 * 6 + 4 - (6 / 3);
				System.out.println(number);
			}
		});
	}
}
