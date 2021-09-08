package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	static boolean player;

	public static void main(String[] args) {
		Graphics();

		System.out.println("Welcome to Tic Tac Toe!");
		Play();
		System.out.println("Thank you for Playing!");
	}

	private static void Graphics() {
		JFrame frame = new JFrame();
		JButton btn = new JButton("Start");
		btn.setBounds(300, 250, 100, 25);
		frame.add(btn);
		frame.setSize(700, 500);
		frame.setLayout(null);
		frame.setVisible(true);

		JButton oneOne = new JButton("[ ]");
		JButton oneTwo = new JButton("[ ]");
		JButton oneThree = new JButton("[ ]");
		JButton twoOne = new JButton("[ ]");
		JButton twoTwo = new JButton("[ ]");
		JButton twoThree = new JButton("[ ]");
		JButton threeOne = new JButton("[ ]");
		JButton threeTwo = new JButton("[ ]");
		JButton threeThree = new JButton("[ ]");
		oneOne.setBounds(200,100,50,50);
		oneTwo.setBounds(250,100,50,50);
		oneThree.setBounds(300,200,50,50);
		frame.add(oneOne);
		frame.add(oneTwo);
		frame.add(oneThree);
		frame.add(twoOne);
		frame.add(twoTwo);
		frame.add(twoThree);
		frame.add(threeOne);
		frame.add(threeTwo);
		frame.add(threeThree);

	}

	private static void Play() {
		ArrayList<ArrayList<String>> gameboardX = new ArrayList<ArrayList<String>>();
		System.out.println("Choose A coordinate to place your token. Example: '1.3'");
		Random rand = new Random();
		StartGame(gameboardX, rand);
		boolean gameIsRunning = true;
		Scanner scan = new Scanner(System.in);
		while (gameIsRunning) {
			if (player) {
				System.out.println("Player X Choose");
				player = PlaceToken(gameboardX, player, scan.nextLine());
			} else if (!player) {
				System.out.println("Player O Choose");
				player = PlaceToken(gameboardX, player, scan.nextLine());
			} else {
				System.out.println("Error");
				gameIsRunning = false;
			}
			DisplayGameboard(gameboardX);
			gameIsRunning = WinCondition(gameboardX, scan, rand);
		}
		scan.close();

	}

	// Checks if anyone won
	private static boolean WinCondition(ArrayList<ArrayList<String>> gameboardX, Scanner scan, Random rand) {
		boolean xWin = false, oWin = false, draw = false;
		// Checks for a Draw
		draw = CheckForDraw(gameboardX);

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
			System.out.println("Congratulations X, You Won!");
			return PlayAgain(gameboardX, scan, rand);
			// If O wins
		} else if (oWin) {
			System.out.println("Congratulations O, You Won!");
			return PlayAgain(gameboardX, scan, rand);
			// If it's a draw
		} else if (draw) {
			System.out.println("It's a Draw!");
			return PlayAgain(gameboardX, scan, rand);

		} else {
			// If none wins
			return true;
		}

	}

	private static boolean CheckForDraw(ArrayList<ArrayList<String>> gameboardX) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameboardX.get(i).get(j).equals("[ ]")) {
					return false;
				}
			}
		}
		return true;
	}

	// Asks if the player(s) wanna play again
	private static boolean PlayAgain(ArrayList<ArrayList<String>> gameboardX, Scanner scan, Random rand) {
		System.out.println("Play again? Y/N");
		String input = scan.nextLine();
		if (input.equals("y")) {
			RestartGame(gameboardX, rand);
			return true;
		} else if (input.equals("n")) {
			return false;
		} else {
			return false;
		}
	}

	// Initialising of the gameboard
	private static void StartGame(ArrayList<ArrayList<String>> gameboardX, Random rand) {
		for (int i = 0; i < 3; i++) {
			ArrayList<String> gameboardY = new ArrayList<String>();
			for (int j = 0; j < 3; j++) {
				gameboardY.add("[ ]");
			}
			gameboardX.add(gameboardY);
		}
		player = rand.nextBoolean();
		DisplayGameboard(gameboardX);
	}

	// Displays whatever is on the gameboard
	private static void DisplayGameboard(ArrayList<ArrayList<String>> gameboardX) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(gameboardX.get(i).get(j));
			}
			System.out.println("");
		}

	}

	// Resets the game
	private static void RestartGame(ArrayList<ArrayList<String>> gameboardX, Random rand) {
		gameboardX.clear();
		StartGame(gameboardX, rand);
	}

	// Handles the Player Choises
	private static boolean PlaceToken(ArrayList<ArrayList<String>> gameboardX, boolean player, String choice) {
		String emptySpace = "[ ]", xToken = "[x]", oToken = "[o]",
				errorMessage = "That Space is already taken! Try again!";
		if (player) {
			// player X
			switch (choice) {
			case "1.1":
				if (gameboardX.get(0).get(0).equals(emptySpace)) {
					gameboardX.get(0).set(0, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "2.1":
				if (gameboardX.get(0).get(1).equals(emptySpace)) {
					gameboardX.get(0).set(1, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "3.1":
				if (gameboardX.get(0).get(2).equals(emptySpace)) {
					gameboardX.get(0).set(2, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "1.2":
				if (gameboardX.get(1).get(0).equals(emptySpace)) {
					gameboardX.get(1).set(0, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "2.2":
				if (gameboardX.get(1).get(1).equals(emptySpace)) {
					gameboardX.get(1).set(1, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "3.2":
				if (gameboardX.get(1).get(2).equals(emptySpace)) {
					gameboardX.get(1).set(2, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "1.3":
				if (gameboardX.get(2).get(0).equals(emptySpace)) {
					gameboardX.get(2).set(0, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "2.3":
				if (gameboardX.get(2).get(1).equals(emptySpace)) {
					gameboardX.get(2).set(1, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "3.3":
				if (gameboardX.get(2).get(2).equals(emptySpace)) {
					gameboardX.get(2).set(2, xToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			default:
				System.out.println("Invalid input, try again");
				return player;
			}

		} else {
			// Player O
			switch (choice) {
			case "1.1":
				if (gameboardX.get(0).get(0).equals(emptySpace)) {
					gameboardX.get(0).set(0, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "2.1":
				if (gameboardX.get(0).get(1).equals(emptySpace)) {
					gameboardX.get(0).set(1, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "3.1":
				if (gameboardX.get(0).get(2).equals(emptySpace)) {
					gameboardX.get(0).set(2, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "1.2":
				if (gameboardX.get(1).get(0).equals(emptySpace)) {
					gameboardX.get(1).set(0, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "2.2":
				if (gameboardX.get(1).get(1).equals(emptySpace)) {
					gameboardX.get(1).set(1, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "3.2":
				if (gameboardX.get(1).get(2).equals(emptySpace)) {
					gameboardX.get(1).set(2, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "1.3":
				if (gameboardX.get(2).get(0).equals(emptySpace)) {
					gameboardX.get(2).set(0, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "2.3":
				if (gameboardX.get(2).get(1).equals(emptySpace)) {
					gameboardX.get(2).set(1, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			case "3.3":
				if (gameboardX.get(2).get(2).equals(emptySpace)) {
					gameboardX.get(2).set(2, oToken);
					return !player;
				} else {
					System.out.println(errorMessage);
				}
				return player;
			default:
				System.out.println("Invalid input, try again");
				return player;
			}
		}

	}
}
