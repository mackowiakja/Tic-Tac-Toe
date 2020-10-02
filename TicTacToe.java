import java.util.Scanner;
/**
 * 
 * @author Jacob Mackowiak 4/23/19
 *	This program plays the game Tic-Tac-Toe, using arrays and methods. 
 * It should play a one-player game, between the computer (program) and the player (user).
 */

public class TicTacToe {


	enum Square {O, X, E};

	// Initialize the Tic-Tac-Toe board so all squares are "Empty".
	final static Square[] board = { Square.E, Square.E, Square.E,
			Square.E, Square.E, Square.E,
			Square.E, Square.E, Square.E };

	// lines[][] provides the indices for the 8 ways to win in the board array.
	final static int[][] lines = { 	{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
			{0, 3, 6}, {1, 4, 7}, {2, 5, 8},
			{0, 4, 8}, {2, 4, 6} };

	// Counts the number of the squares, s, in the line specified. Returns the result.
	// Example:	a = countLine(0, Square.X); Counts the number of X's in first row.
	public static int countLine(int line, Square s) {
		int count = 0;
		for(int i=0; i<3; i++) {
			if (board[ lines[line][i] ] == s) {
				count++;
			}
		}
		return count;
	}
	// Counts the number of squares, s, in the column specified.
	public static int countColumn(int line, Square s) {
		int count = 0;
		for(int i=0; i<3; i++) {
			if (board[ lines[i][line] ] == s) {
				count++;
			}
		}
		return count;
	}

	// Checks to see if there is a winning move for player specified by square s, and
	// makes the win. Returns true if a winning move was played. Otherwise, false.
	// Example: move = makeWin(Square.O);
	public static boolean makeWin(Square s) {
		// Checks to see if you can win in the 3rd column
		if (board[0] == Square.O && board[1] == Square.O && board[2] == Square.E) {			
			board[2] = s;
			return true;}
		if (board[3] == Square.O && board[4] == Square.O && board[5] == Square.E) { 
			board[5] = s;
			return true;}
		if (board[6] == Square.O && board[7] == Square.O && board[8] == Square.E) {
			board[8] = s; 
			return true;}
		// Checks to see if you can win in the 1st column
		if (board[1] == Square.O && board[2] == Square.O && board[0] == Square.E) { 
			board[0] = s;
			return true;}
		if (board[4] == Square.O && board[5] == Square.O && board[3] == Square.E) {
			board[3] = s;
			return true;}
		if (board[7] == Square.O && board[8] == Square.O && board[6] == Square.E) { 
			board[6] = s;
			return true;}
		// Checks to see if you can win in the 2nd column
		if (board[0] == Square.O && board[1] == Square.E && board[2] == Square.O) { 
			board[1] = s;
			return true;}
		if (board[3] == Square.O && board[4] == Square.E && board[5] == Square.O) {
			board[4] = s;
			return true;}
		if (board[6] == Square.O && board[7] == Square.E && board[8] == Square.O) {
			board[7] = s;
			return true;}
		// Checks to see if you can win in the 3rd row
		if (board[0] == Square.O && board[3] == Square.O && board[6] == Square.E) {
			board[6] = s;
			return true;}
		if (board[1] == Square.O && board[4] == Square.O && board[7] == Square.E) {
			board[7] = s;
			return true;}
		if (board[2] == Square.O && board[5] == Square.O && board[8] == Square.E) {
			board[8] = s;
			return true;}
		// Checks to see if you can win in the 1st row
		if (board[3] == Square.O && board[6] == Square.O && board[0] == Square.E) {
			board[0] = s;
			return true;}
		if (board[7] == Square.O && board[4] == Square.O && board[1] == Square.E) {
			board[1] = s;
			return true;}
		if (board[8] == Square.O && board[5] == Square.O && board[2] == Square.E) {
			board[2] = s;
			return true;}
		// Checks to see if you can win in the 2nd row
		if (board[0] == Square.O && board[3] == Square.E && board[6] == Square.O) {
			board[3] = s;
			return true;}
		if (board[1] == Square.O && board[4] == Square.E && board[7] == Square.O) {
			board[4] = s;
			return true;}
		if (board[2] == Square.O && board[5] == Square.E && board[8] == Square.O) {
			board[5] = s;
			return true;}

		if(board[0] == Square.O && board[4] == Square.E && board[8] == Square.O) {
			board[4] = s;
			return true;}
		if(board[2] == Square.O && board[4] == Square.E && board[6] == Square.O) {
			board[4] = s;
			return true;}
		// Checks to see if you can win in any of the diagonals
		if(board[0] == Square.O && board[4] == Square.O && board[8] == Square.E) {
			board[8] = s;
			return true;}
		if(board[2] == Square.O && board[4] == Square.O && board[6] == Square.E) {
			board[6] = s;}
		if(board[4] == Square.O && board[8] == Square.O && board[0] == Square.E) {
			board[8] = s;
			return true;}
		if(board[6] == Square.O && board[4] == Square.O && board[2] == Square.E) {
			board[2] = s;
			return true;}
		else {
			return false;
		}
	}


	// Checks to see if there is a blocking move for player s, and makes the block.
	// Returns true if a blocking move was played. Otherwise, false.
	// Example: move = makeBlock(Square.O); Checks if there is a line with 2 X's
	//										and one E, and will place an O in the E.
	public static boolean makeBlock(Square s) {
		//Block method is same as makeWin method except the O's are now X's

		if (board[0] == Square.X && board[1] == Square.X && board[2] == Square.E) {			
			board[2] = s;
			return true;}
		else if (board[3] == Square.X && board[4] == Square.X && board[5] == Square.E) { 
			board[5] = s;
			return true;}
		else if (board[6] == Square.X && board[7] == Square.X && board[8] == Square.E) {
			board[8] = s; 
			return true;}

		else if (board[1] == Square.X && board[2] == Square.X && board[0] == Square.E) { 
			board[0] = s;
			return true;}
		else if (board[4] == Square.X && board[5] == Square.X && board[3] == Square.E) {
			board[3] = s;
			return true;}
		else if (board[7] == Square.X && board[8] == Square.X && board[6] == Square.E) { 
			board[6] = s;
			return true;}

		else if (board[0] == Square.X && board[1] == Square.E && board[2] == Square.X) { 
			board[1] = s;
			return true;}
		else if (board[3] == Square.X && board[4] == Square.E && board[5] == Square.X) {
			board[4] = s;
			return true;}
		else if (board[6] == Square.X && board[7] == Square.E && board[8] == Square.X) {
			board[7] = s;
			return true;}

		else if (board[0] == Square.X && board[3] == Square.X && board[6] == Square.E) {
			board[6] = s;
			return true;}
		else if (board[1] == Square.X && board[4] == Square.X && board[7] == Square.E) {
			board[7] = s;
			return true;}
		else if (board[2] == Square.X && board[5] == Square.X && board[8] == Square.E) {
			board[8] = s;
			return true;}

		else if (board[3] == Square.X && board[6] == Square.X && board[0] == Square.E) {
			board[0] = s;
			return true;}
		else if (board[7] == Square.X && board[4] == Square.X && board[1] == Square.E) {
			board[1] = s;
			return true;}
		else if (board[8] == Square.X && board[5] == Square.X && board[2] == Square.E) {
			board[2] = s;
			return true;}

		else if (board[0] == Square.X && board[3] == Square.E && board[6] == Square.X) {
			board[3] = s;
			return true;}
		else if (board[1] == Square.X && board[4] == Square.E && board[7] == Square.X) {
			board[4] = s;
			return true;}
		else if (board[2] == Square.X && board[5] == Square.E && board[8] == Square.X) {
			board[5] = s;
			return true;}

		else if(board[0] == Square.X && board[4] == Square.E && board[8] == Square.X) {
			board[4] = s;
			return true;}
		else if(board[2] == Square.X && board[4] == Square.E && board[6] == Square.X) {
			board[4] = s;
			return true;}

		else if(board[0] == Square.X && board[4] == Square.X && board[8] == Square.E) {
			board[8] = s;
			return true;}
		else if(board[2] == Square.X && board[4] == Square.X && board[6] == Square.E) {
			board[6] = s;
			return true;}
		else if(board[4] == Square.X && board[8] == Square.X && board[0] == Square.E) {
			board[8] = s;
			return true;}
		else if(board[6] == Square.X && board[4] == Square.X && board[2] == Square.E) {
			board[2] = s;	
			return true;}
		else {
			return false;
		}
	}


	public static boolean makeMark(Square s) {

		int row1 = countLine(0, Square.O);
		int row2 = countLine(1, Square.O);
		int row3 = countLine(2, Square.O);
		// Checks to see if there is a row with 1 program mark
		if(row1 == 1 && board[0] == Square.E) {
			board[0] = s;
			return true;}
		if(row1 == 1 && board[1] == Square.E) {
			board[1] = s;
			return true;}
		if(row1 == 1 && board[2] == Square.E) {
			board[2] = s;
			return true;}

		if(row2 == 1 && board[3] == Square.E) {
			board[3] = s;
			return true;}
		if(row2 == 1 && board[4] == Square.E) {
			board[4] = s;
			return true;}
		if(row2 == 1 && board[5] == Square.E) {
			board[5] = s;
			return true;}

		if(row3 == 1 && board[6] == Square.E) {
			board[6] = s;
			return true;}
		if(row3 == 1 && board[7] == Square.E) {
			board[7] = s;
			return true;}
		if(row3 == 1 && board[8] == Square.E) {
			board[8] = s;
			return true;}

		int col1 = countColumn(0, Square.O);
		int col2 = countColumn(1, Square.O);
		int col3 = countColumn(2, Square.O);
		//Checks to see if there is a column with 1 program mark
		if(col1 == 1 && board[0] == Square.E) {
			board[0] = s;
			return true;}
		if(col1 == 1 && board[3] == Square.E) {
			board[3] = s;
			return true;}
		if(col1 == 1 && board[6] == Square.E) {
			board[6] = s;
			return true;}

		if(col2 == 1 && board[1] == Square.E) {
			board[1] = s;
			return true;}
		if(col2 == 1 && board[4] == Square.E) {
			board[4] = s;
			return true;}
		if(col2 == 1 && board[7] == Square.E) {
			board[7] = s;
			return true;}

		if(col3 == 1 && board[2] == Square.E) {
			board[2] = s;
			return true;}
		if(col3 == 1 && board[5] == Square.E) {
			board[5] = s;
			return true;}
		if(col3 == 1 && board[8] == Square.E) {
			board[8] = s;
			return true;}

		// Checks to see if there are any empty rows
		if(row1 == 0 && board[0] == Square.E) {
			board[0] = s;
			return true;}
		if(row1 == 0 && board[1] == Square.E) {
			board[1] = s;
			return true;}
		if(row1 == 0 && board[2] == Square.E) {
			board[2] = s;
			return true;}

		if(row2 == 0 && board[3] == Square.E) {
			board[3] = s;
			return true;}
		if(row2 == 0 && board[4] == Square.E) {
			board[4] = s;
			return true;}
		if(row2 == 0 && board[5] == Square.E) {
			board[5] = s;
			return true;}

		if(row3 == 0 && board[6] == Square.E) {
			board[6] = s;
			return true;}
		if(row3 == 0 && board[7] == Square.E) {
			board[7] = s;
			return true;}
		if(row3 == 0 && board[8] == Square.E) {
			board[8] = s;
			return true;}

		// Checks to see if there are any empty columns	
		if(col1 == 0 && board[0] == Square.E) {
			board[0] = s;
			return true;}
		if(col1 == 0 && board[3] == Square.E) {
			board[3] = s;
			return true;}
		if(col1 == 0 && board[6] == Square.E) {
			board[6] = s;
			return true;}

		if(col2 == 0 && board[1] == Square.E) {
			board[1] = s;
			return true;}
		if(col2 == 0 && board[4] == Square.E) {
			board[4] = s;
			return true;}
		if(col2 == 0 && board[7] == Square.E) {
			board[7] = s;
			return true;}


		if(col3 == 0 && board[6] == Square.E) {
			board[6] = s;
			return true;}
		if(col3 == 0 && board[7] == Square.E) {
			board[7] = s;
			return true;}
		if(col3 == 0 && board[8] == Square.E) {
			board[8] = s;
			return true;}

		// Makes a move in some empty place	
		if (board[0] == Square.E){
			board[0] = s;
			return true;}
		if(board[1] == Square.E) {
			board[1] = s;
			return true;}
		if(board[2] == Square.E) {
			board[2] = s;
			return true;}
		if(board[3] == Square.E) {
			board[3] = s;
			return true;}
		if(board[4] == Square.E) {
			board[4] = s;
			return true;}
		if(board[5] == Square.E) {
			board[5] = s;
			return true;}
		if(board[6] == Square.E) {
			board[6] = s;
			return true;}
		if(board[7] == Square.E) {
			board[7] = s;
			return true;}
		if(board[8] == Square.E) {
			board[8] = s;
			return true;}
		else {
			return false;
		}

	}


	// Checks to see if player s won the game. Looks for a line with three squares for
	// the player. Returns true if player won. Otherwise, false.
	// Example: playerWin = checkWin(Square.X);
	public static boolean checkWin(Square s) {

		if(board[0] == s && board[1] == s && board[2] == s) return true;
		if(board[3] == s && board[4] == s && board[5] == s) return true;
		if(board[6] == s && board[7] == s && board[8] == s) return true;
		if(board[0] == s && board[3] == s && board[6] == s) return true;
		if(board[1] == s && board[4] == s && board[7] == s) return true;
		if(board[2] == s && board[5] == s && board[8] == s) return true;
		if(board[0] == s && board[4] == s && board[8] == s) return true;
		if(board[2] == s && board[4] == s && board[6] == s) return true;
		else {
			return false;
		}
	}

	// Checks to see if the game is a tie
	public static boolean checkTie() {

		if(board[0] != Square.E && board[1] != Square.E && board[2] != Square.E && board[3] != Square.E && board[4] != Square.E && board[5] != Square.E && board[6] != Square.E && board[7] != Square.E && board[8] != Square.E) return true;
		else
			return false;
	}

	// Displays the current board of Tic-Tac-Toe.
	public static void displayBoard() {
		if (board[0] == Square.E) System.out.print("0 |");
		else System.out.print(board[0] + " |");
		if (board[1] == Square.E) System.out.print(" 1 ");
		else System.out.print(" " + board[1] + " ");
		if (board[2] == Square.E) System.out.print("| 2");
		else System.out.print("| " + board[2]);
		System.out.print("\n---------\n");
		if (board[3] == Square.E) System.out.print("3 |");
		else System.out.print(board[3] + " |");
		if (board[4] == Square.E) System.out.print(" 4 ");
		else System.out.print(" " + board[4] + " ");
		if (board[5] == Square.E) System.out.print("| 5");
		else System.out.print("| " + board[5]);
		System.out.print("\n---------\n");
		if (board[6] == Square.E) System.out.print("6 |");
		else System.out.print(board[6] + " |");
		if (board[7] == Square.E) System.out.print(" 7 ");
		else System.out.print(" " + board[7] + " ");
		if (board[8] == Square.E) System.out.print("| 8");
		else System.out.print("| " + board[8]);
	}
	public static void newBoard() {
		System.out.print("0 |");
		System.out.print(" 1 ");
		System.out.print("| 2");
		System.out.print("\n---------\n");
		System.out.print("3 |");
		System.out.print(" 4 ");
		System.out.print("| 5");
		System.out.print("\n---------\n");
		System.out.print("6 |");
		System.out.print(" 7 ");
		System.out.print("| 8");
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		newBoard();
		System.out.println();
		System.out.println();

		// While loop to check if the game has been won yet or not
		while(checkWin(Square.X) == false && checkWin(Square.O) == false && checkTie() == false) { 
			System.out.println("\nEnter position to mark an X: ");
			int x = input.nextInt();

			//Checks to see if user marks a valid position
			if(board[x] != Square.E) {
				System.out.println("This spot is already marked. Try again.");
				continue;}
			else {
				board[x] = Square.X;
				if(checkWin(Square.X) == true) {
					displayBoard();
					break;}
				else {
					checkTie();
					displayBoard();}
			}
			// Checks to see if computer can make a winning move
			makeWin(Square.O);
			checkWin(Square.O);

			// Checks to see if computer can block the user from winning
			if(makeBlock(Square.O) == true) {
				checkWin(Square.O);
				checkTie();
				System.out.println();
				System.out.println("\nComputer's Move: ");
				displayBoard(); 
				continue;}

			// Computer can't win or block a win, so it makes the best move possible
			if (makeMark(Square.O) == true) {
				checkWin(Square.O);
				checkTie();
				System.out.println();
				System.out.println("\nComputer's Move: ");
				System.out.println();
				displayBoard();}

			System.out.println();
			System.out.println();
		}

		if (checkWin(Square.X) == true) {
			System.out.println();
			System.out.println("\nYou won the game!");}
		else if (checkWin(Square.O) == true) {
			System.out.println();
			System.out.println("\nYou lost :((");}
		else if(checkTie() == true) {
			System.out.println("\nCat's Game!");
		}
		else {
			System.out.println();
		}

		input.close();
	}
}