package sim;

import java.util.Scanner;

public class TicTacToeBoard {
    private String[] board;
    private String[] WIN = {"012", "345", "678", "036", "147", "258", "048", "246"};
    private boolean isPlayerTurn;
    private String computerMarker;
    private String playerMarker;
    private Scanner scanner;

    public TicTacToeBoard() {
        board = new String[9];
        isPlayerTurn = (Math.random()*2 < 1); // Randomly decide if the player or computer goes first
        scanner = new Scanner(System.in);
        
        if (isPlayerTurn) {
            playerMarker = "✕";
            computerMarker = "◯";
        } else {
            playerMarker = "◯";
            computerMarker = "✕";
        }
    }

    public int computerMove() {
        int x;
        do {
            x = (int) (Math.random() * 9);
        } while (board[x] != null);
        return x; // Return the move without marking it on the board here
    }

    public int playerMove() {
        int x;
        do {
            System.out.print("Input a space number (0-8): ");
            x = Integer.parseInt(scanner.nextLine());
            if (x < 0 || x > 8 || board[x] != null) {
                System.out.println("Error: Enter a space numbered 0 through 8 that is not already taken.");
                x = -1; // Reset to an invalid state
            }
        } while (x < 0);
        return x; // Return the move without marking it on the board here
    }

    public String isGameOver() {
        boolean hasBlanks = false;
        for (String win : WIN) {
            if (board[Character.getNumericValue(win.charAt(0))] != null &&
                board[Character.getNumericValue(win.charAt(0))].equals(board[Character.getNumericValue(win.charAt(1))]) &&
                board[Character.getNumericValue(win.charAt(1))].equals(board[Character.getNumericValue(win.charAt(2))])) {
                return (board[Character.getNumericValue(win.charAt(0))] + " wins! Game Over");
            }
        }
        for (String space : board) {
            if (space == null) {
                hasBlanks = true;
                break;
            }
        }
        return (hasBlanks ? "Continue" : "Tie! Game Over");
    }

    public String toString() {
        StringBuilder boardPrint = new StringBuilder();
        for (int i = 0; i < 9; ) {
            for (int j = 0; j < 3; j++) {
                boardPrint.append(board[i] != null ? board[i] : " ");
                if (j < 2) {
                    boardPrint.append(" | ");
                }
                i++;
            }
            boardPrint.append("\n");
            if (i < 9) {
                boardPrint.append("---------\n");
            }
        }
        return boardPrint.toString();
    }
    
    public void instructionBoard() {
        for (int i = 0; i < 9; ) {
            for (int j = 0; j < 3; j++) {
            	System.out.print(i);
                if (j < 2) {
                	System.out.print(" | ");
                }
                i++;
            }
            System.out.println("");
            if (i < 9) {
                System.out.print("---------\n");
            }
        }
        System.out.println("__________\n");
    }
    
    public void playGame() {
    	instructionBoard();
        while (true) {
            int move; // Store the current move

            if (isPlayerTurn) {
                move = playerMove(); // Get the player's move
                board[move] = playerMarker; // Mark the player's move on the board
            } else {
                move = computerMove(); // Get the computer's move
                board[move] = computerMarker; // Mark the computer's move on the board
            }

            String result = isGameOver(); // Check if the game is over
            if (!result.equals("Continue")) {
                System.out.println(this); // Print the final board
                System.out.println(result); // Print the result
                break; // Exit the game loop
            }
            isPlayerTurn = !isPlayerTurn; // Switch turns
            System.out.println(this); // Print the current board
        }
        scanner.close(); // Close the scanner when done
    }

    public static void main(String[] args) {
        TicTacToeBoard game = new TicTacToeBoard();
        game.playGame(); // Start the game
    }
}
