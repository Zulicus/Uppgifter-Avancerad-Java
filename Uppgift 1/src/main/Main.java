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
	//Global Vaiables
	static boolean player;
	static JLabel welcome = new JLabel("Welcome to Tic Tac Toe!");
	static JLabel playerTurn = new JLabel();
	static JLabel errorMessage = new JLabel();
	static JFrame frame = new JFrame("Tic Tac Toe!");
	static JButton exit = new JButton("Exit");
	static JButton play = new JButton("Play Again!");
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
		StartGame();
		Play();
	}

	private static void Play() {
		//Event Listener that allows for a player to end the game at any time
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
				PlaceToken();
			} else if (!player) {
				playerTurn.setText("Player O Choose");
				PlaceToken();
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
			playerTurn.setText("Congratulations X, You Won!");
			gameIsRunning=false;
			PlayAgain();
			// If O wins
		} else if (oWin) {
			playerTurn.setText("Congratulations O, You Won!");
			gameIsRunning=false;			
			PlayAgain();
			// If it's a draw
		} else if (draw) {
			playerTurn.setText("It's a Draw!");
			gameIsRunning=false;			
			PlayAgain();
		} else {
			// If none wins
		}

	}

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

	// Asks if the player(s) wants to play again
	private static void PlayAgain() {
		play.setBounds(100, 200, 150, 25);
		frame.add(play);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameIsRunning=true;
				RestartGame();
				frame.remove(play);
			}
		});
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
		gameboardX.clear();
		StartGame();
	}

	// Handles the Player Choices
	private static void PlaceToken() {
		String emptySpace = "[ ]", xToken = "[x]", oToken = "[o]", message = "That Space is already taken! Try again!";
		if (player) {
			// player X
			oneOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (oneOne.getText().equals(emptySpace)) {
						gameboardX.get(0).set(0, xToken);
						oneOne.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			oneTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (oneTwo.getText().equals(emptySpace)) {
						gameboardX.get(1).set(0, xToken);
						oneTwo.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			oneThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (oneThree.getText().equals(emptySpace)) {
						gameboardX.get(2).set(0, xToken);
						oneThree.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			twoOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (twoOne.getText().equals(emptySpace)) {
						gameboardX.get(0).set(1, xToken);
						twoOne.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			twoTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (twoTwo.getText().equals(emptySpace)) {
						gameboardX.get(1).set(1, xToken);
						twoTwo.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			twoThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (twoThree.getText().equals(emptySpace)) {
						gameboardX.get(2).set(1, xToken);
						twoThree.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			threeOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (threeOne.getText().equals(emptySpace)) {
						gameboardX.get(0).set(2, xToken);
						threeOne.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			threeTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (threeTwo.getText().equals(emptySpace)) {
						gameboardX.get(1).set(2, xToken);
						threeTwo.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			threeThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (threeThree.getText().equals(emptySpace)) {
						gameboardX.get(2).set(2, xToken);
						threeThree.setText(xToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});

		} else {
			// Player O
			oneOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (oneOne.getText().equals(emptySpace)) {
						gameboardX.get(0).set(0, oToken);
						oneOne.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			oneTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (oneTwo.getText().equals(emptySpace)) {
						gameboardX.get(1).set(0, oToken);
						oneTwo.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			oneThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (oneThree.getText().equals(emptySpace)) {
						gameboardX.get(2).set(0, oToken);
						oneThree.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			twoOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (twoOne.getText().equals(emptySpace)) {
						gameboardX.get(0).set(1, oToken);
						twoOne.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			twoTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (twoTwo.getText().equals(emptySpace)) {
						gameboardX.get(1).set(1, oToken);
						twoTwo.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			twoThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (twoThree.getText().equals(emptySpace)) {
						gameboardX.get(2).set(1, oToken);
						twoThree.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			threeOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (threeOne.getText().equals(emptySpace)) {
						gameboardX.get(0).set(2, oToken);
						threeOne.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			threeTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (threeTwo.getText().equals(emptySpace)) {
						gameboardX.get(1).set(2, oToken);
						threeTwo.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
			threeThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (threeThree.getText().equals(emptySpace)) {
						gameboardX.get(2).set(2, oToken);
						threeThree.setText(oToken);
						player = !player;
					} else {
						errorMessage.setText(message);
					}
				}
			});
		}
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
		
		//Sets the parameters of the frame
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setVisible(true);
		
		//Event listener that controls the reset function
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oneOne.setText("[ ]");
				oneTwo.setText("[ ]");
				oneThree.setText("[ ]");
				twoOne.setText("[ ]");
				twoTwo.setText("[ ]");
				twoThree.setText("[ ]");
				threeOne.setText("[ ]");
				threeTwo.setText("[ ]");
				threeThree.setText("[ ]");
				RestartGame();
			}
		});

	}
}
