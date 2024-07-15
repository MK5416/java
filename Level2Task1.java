import java.util.*;
public class Level2Task1 {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static char[][] gameBoard = new char[BOARD_SIZE][BOARD_SIZE];
    private static char currentPlayer = 'X';
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String playAgain;
        do {
            initializeBoard();
            printBoard();
            boolean gameWon = false;
            boolean boardFull = false;
            while (!gameWon && !boardFull) {
                makeMove();
                printBoard();
                gameWon = checkWin();
                boardFull = checkBoardFull();
                if (gameWon) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (boardFull) {
                    System.out.println("It's a draw!");
                } else {
                    switchPlayer();
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = inputScanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));
        System.out.println("Thanks for playing!");
        inputScanner.close();
    }
    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                gameBoard[i][j] = EMPTY_CELL;
            }
        }
    }
    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < BOARD_SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < BOARD_SIZE - 1) {
                System.out.println("-----");
            }
        }
    }
    private static void makeMove() {
        Scanner inputScanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.println("Player " + currentPlayer + "'s turn:");
            System.out.print("Enter row (1-3): ");
            row = inputScanner.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            col = inputScanner.nextInt() - 1;
        } while (!isValidMove(row, col));
        gameBoard[row][col] = currentPlayer;
    }
    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || gameBoard[row][col] != EMPTY_CELL) {
            System.out.println("Invalid move! Try again.");
            return false;
        }
        return true;
    }
    private static boolean checkWin() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (gameBoard[i][0] == currentPlayer && gameBoard[i][1] == currentPlayer && gameBoard[i][2] == currentPlayer) {
                return true; 
            }
            if (gameBoard[0][i] == currentPlayer && gameBoard[1][i] == currentPlayer && gameBoard[2][i] == currentPlayer) {
                return true;  
            }
        }
        if (gameBoard[0][0] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][2] == currentPlayer) {
            return true;  
        }
        if (gameBoard[0][2] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][0] == currentPlayer) {
            return true; 
        }
        return false;
    }
    private static boolean checkBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (gameBoard[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
