import java.util.Random;
import java.util.Scanner;

public class TikTik {

    public static void main(String[] args) {
        System.out.println("WELCOME TO THE TIK-TAK-TOE GAME");
        Scanner scanner = new Scanner(System.in);
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printBoard(board);

        while (true) {
        playerTurn(board, scanner);
            if (isGameFinished(board)) {
                break;
            }
        printBoard(board);

        compsTurn(board);
            if (isGameFinished(board)) {
                break;
            }
        printBoard(board);

        }
        scanner.close();
    }

    private static boolean isGameFinished(char[][] board) {

        if (hasWon(board,'X')){
            printBoard(board);
            System.out.println("Player Wins!");
            return true;
        }

        if (hasWon(board,'0')) {
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        }
        //looping through the board with an enhanced for-each loop to see if there's an empty space
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Game over! It's a tie");
        return true;
    }
    //checking if player of computer wins
    private static boolean hasWon(char[][] board, char symbol) {
                //row checking for both players
        return  (board[0][0] == symbol) && (board[0][1] == symbol) && (board[0][2] == symbol) ||
                (board[1][0] == symbol) && (board[1][1] == symbol) && (board[1][2] == symbol) ||
                (board[2][0] == symbol) && (board[2][1] == symbol) && (board[2][2] == symbol) ||
                //column checking for both players
                (board[0][0] == symbol) && (board[1][0] == symbol) && (board[2][0] == symbol) ||
                (board[0][1] == symbol) && (board[1][1] == symbol) && (board[2][1] == symbol) ||
                (board[0][2] == symbol) && (board[1][2] == symbol) && (board[2][2] == symbol) ||
                //checking both diagonals
                (board[0][0] == symbol) && (board[1][1] == symbol) && (board[2][2] == symbol) ||
                (board[0][2] == symbol) && (board[2][1] == symbol) && (board[2][0] == symbol);
    }


    //taking computer's input
    private static void compsTurn(char[][] board) {

        Random rand = new Random();

        int compsMove;
        while (true) {
            compsMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(compsMove))){
               break;
            }
        }
        placeMove(board, Integer.toString(compsMove), '0');
        System.out.println("Computer plays "+compsMove);
    }
    //a method to check if every move is a valid one
    private static boolean isValidMove(char[][] board, String position) {

        switch(position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    //taking user input
    private static void playerTurn(char[][] board, Scanner scanner) {

        System.out.println("Enter a value between (1-9)");
        String userInput;
        while (true) {
        userInput = scanner.nextLine();
            if (isValidMove(board,userInput)) {
            break;
            }
            else {
                System.out.println(userInput +" is not a valid move");
            }
        }
        placeMove(board, userInput, 'X');

    }
    //placing a move
    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("...(:-");
        }
    }
    //empty board method
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}
