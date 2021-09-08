package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	// Global Vaiables
	static boolean player;
	static JLabel welcome = new JLabel("Welcome to Tic Tac Toe!");
	static JLabel playerTurn = new JLabel();
	static JLabel errorMessage = new JLabel();
	static JFrame frame = new JFrame("Tic Tac Toe!");
	static JButton exit = new JButton("Exit");
	static JButton resetbtn = new JButton("Reset");
	static JButton oneOne = new JButton("[ ]");
	static JButton oneTwo = new JButton("[ ]");
	static JButton oneThree = new JButton("[ ]");
	static JButton twoOne = new JButton("[ ]");
	static JButton twoTwo = new JButton("[ ]");
	static JButton twoThree = new JButton("[ ]");
	static JButton threeOne = new JButton("[ ]");
	static JButton threeTwo = new JButton("[ ]");
	static JButton threeThree = new JButton("[ ]");
	static ArrayList<ArrayList<String>> gameboardX = new ArrayList<ArrayList<String>>();
	static Random rand = new Random();
	static boolean gameIsRunning = true;

	public static void main(String[] args) {
		Graphics();
		PlaceToken();
		StartGame();
		Play();
	}

	private static void Play() {
		// Event Listener that allows for a player to end the game at any time
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(1000);
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				} catch (InterruptedException e1) {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					e1.printStackTrace();
				}
			}
		});
		while (gameIsRunning) {
			if (player) {
				playerTurn.setText("Player X Choose");
			} else if (!player) {
				playerTurn.setText("Player O Choose");
			} else {
				System.out.println("Error");
				gameIsRunning = false;
			}
			WinCondition();
		}

	}

	// Checks if anyone won
	private static void WinCondition() {
		boolean xWin = false, oWin = false, draw = false;
		// Checks for a Draw
		draw = CheckForDraw();

		// Checks Vertical
		for (int i = 0; i < 3; i++) {
			if (gameboardX.get(i).get(0).equals(gameboardX.get(i).get(1))
					&& gameboardX.get(i).get(0).equals(gameboardX.get(i).get(2))) {
				if (gameboardX.get(i).get(0) == "[x]") {
					xWin = true;
				} else if (gameboardX.get(i).get(0) == "[o]") {
					oWin = true;
				} else {
					xWin = false;
					oWin = false;
				}
			}
		}
		// Checks Horizontally
		if (!xWin && !oWin) {
			for (int i = 0; i < 3; i++) {
				if (gameboardX.get(0).get(i).equals(gameboardX.get(1).get(i))
						&& gameboardX.get(0).get(i).equals(gameboardX.get(2).get(i))) {
					if (gameboardX.get(0).get(i) == "[x]") {
						xWin = true;
					} else if (gameboardX.get(0).get(i) == "[o]") {
						oWin = true;
					} else {
						xWin = false;
						oWin = false;
					}
				}
			}
		}
		// Checks Diagonally
		if (!xWin && !oWin) {
			if (gameboardX.get(0).get(0).equals(gameboardX.get(1).get(1))
					&& gameboardX.get(0).get(0).equals(gameboardX.get(2).get(2))) {
				if (gameboardX.get(1).get(1) == "[x]") {
					xWin = true;
				} else if (gameboardX.get(1).get(1) == "[o]") {
					oWin = true;
				} else {
					xWin = false;
					oWin = false;
				}
			}
		}
		// Checks Diagonally
		if (!xWin && !oWin) {
			if (gameboardX.get(2).get(0).equals(gameboardX.get(1).get(1))
					&& gameboardX.get(2).get(0).equals(gameboardX.get(0).get(2))) {
				if (gameboardX.get(1).get(1) == "[x]") {
					xWin = true;
				} else if (gameboardX.get(1).get(1) == "[o]") {
					oWin = true;
				} else {
					xWin = false;
					oWin = false;
				}
			}
		}
		// If X wins
		if (xWin) {
			errorMessage.setText("Congratulations X, You Won!");
			RestartGame();
			// If O wins
		} else if (oWin) {
			errorMessage.setText("Congratulations O, You Won!");
			RestartGame();
			// If it's a draw
		} else if (draw) {
			errorMessage.setText("It's a Draw!");
			RestartGame();
		} else {
			// No victory
		}
	}

	// Tests if it's a draw
	private static boolean CheckForDraw() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameboardX.get(i).get(j).equals("[ ]")) {
					return false;
				}
			}
		}
		return true;
	}

	// Initialising of the game board
	private static void StartGame() {
		for (int i = 0; i < 3; i++) {
			ArrayList<String> gameboardY = new ArrayList<String>();
			for (int j = 0; j < 3; j++) {
				gameboardY.add("[ ]");
			}
			gameboardX.add(gameboardY);
		}
		player = rand.nextBoolean();
	}

	// Resets the game
	private static void RestartGame() {
		try {
			Thread.sleep(1000);
			oneOne.setText("[ ]");
			oneTwo.setText("[ ]");
			oneThree.setText("[ ]");
			twoOne.setText("[ ]");
			twoTwo.setText("[ ]");
			twoThree.setText("[ ]");
			threeOne.setText("[ ]");
			threeTwo.setText("[ ]");
			threeThree.setText("[ ]");
			gameboardX.clear();
			StartGame();
		} catch (InterruptedException e) {
			oneOne.setText("[ ]");
			oneTwo.setText("[ ]");
			oneThree.setText("[ ]");
			twoOne.setText("[ ]");
			twoTwo.setText("[ ]");
			twoThree.setText("[ ]");
			threeOne.setText("[ ]");
			threeTwo.setText("[ ]");
			threeThree.setText("[ ]");
			gameboardX.clear();
			StartGame();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Sets all the event listeners
	private static void PlaceToken() {
		String emptySpace = "[ ]", xToken = "[x]", oToken = "[o]", message = "That Space is already taken! Try again!";
		oneOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneOne.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(0).set(0, xToken);
						oneOne.setText(xToken);
					} else {
						gameboardX.get(0).set(0, oToken);
						oneOne.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		oneTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneTwo.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(1).set(0, xToken);
						oneTwo.setText(xToken);
					} else {
						gameboardX.get(1).set(0, oToken);
						oneTwo.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		oneThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oneThree.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(2).set(0, xToken);
						oneThree.setText(xToken);
					} else {
						gameboardX.get(2).set(0, oToken);
						oneThree.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		twoOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (twoOne.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(0).set(1, xToken);
						twoOne.setText(xToken);
					} else {
						gameboardX.get(0).set(1, oToken);
						twoOne.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		twoTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (twoTwo.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(1).set(1, xToken);
						twoTwo.setText(xToken);
					} else {
						gameboardX.get(1).set(1, oToken);
						twoTwo.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		twoThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (twoThree.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(2).set(1, xToken);
						twoThree.setText(xToken);
					} else {
						gameboardX.get(2).set(1, oToken);
						twoThree.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		threeOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (threeOne.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(0).set(2, xToken);
						threeOne.setText(xToken);
					} else {
						gameboardX.get(0).set(2, oToken);
						threeOne.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		threeTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (threeTwo.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(1).set(2, xToken);
						threeTwo.setText(xToken);
					} else {
						gameboardX.get(1).set(2, oToken);
						threeTwo.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
		threeThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (threeThree.getText().equals(emptySpace)) {
					if (player) {
						gameboardX.get(2).set(2, xToken);
						threeThree.setText(xToken);
					} else {
						gameboardX.get(2).set(2, oToken);
						threeThree.setText(oToken);
					}
					player = !player;
				} else {
					errorMessage.setText(message);
				}
			}
		});
	}

	// Draws up all the graphics
	private static void Graphics() {
		// Sets the sizes of the components
		errorMessage.setBounds(50, 200, 350, 25);
		welcome.setBounds(50, 5, 150, 25);
		playerTurn.setBounds(75, 25, 350, 25);
		resetbtn.setBounds(50, 225, 75, 25);
		exit.setBounds(125, 225, 75, 25);
		oneOne.setBounds(50, 50, 50, 50);
		oneTwo.setBounds(100, 50, 50, 50);
		oneThree.setBounds(150, 50, 50, 50);
		twoOne.setBounds(50, 100, 50, 50);
		twoTwo.setBounds(100, 100, 50, 50);
		twoThree.setBounds(150, 100, 50, 50);
		threeOne.setBounds(50, 150, 50, 50);
		threeTwo.setBounds(100, 150, 50, 50);
		threeThree.setBounds(150, 150, 50, 50);

		// Adds the components to the frame
		frame.add(exit);
		frame.add(resetbtn);
		frame.add(oneOne);
		frame.add(oneTwo);
		frame.add(oneThree);
		frame.add(twoOne);
		frame.add(twoTwo);
		frame.add(twoThree);
		frame.add(threeOne);
		frame.add(threeTwo);
		frame.add(threeThree);
		frame.add(welcome);
		frame.add(playerTurn);
		frame.add(errorMessage);

		// Sets the parameters of the frame
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setVisible(true);

		// Event listener that controls the reset function
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestartGame();
			}
		});

	}
}
