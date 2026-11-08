import java.util.Scanner;
public class TicTacToe
{
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean playAgain;
        do
        {
            clearBoard();
            String player = "X";
            int moveCount = 0;
            boolean gameOver = false;
            while (!gameOver)
            {
                display();
                int rowMove = SafeInput.getRangedInt(in, player + ", choose a row (1-3): ", 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(in, player + ", choose a column (1-3): ", 1, 3) - 1;
                while (!isValidMove(rowMove, colMove))
                {
                    System.out.println("That space is already occupied. Try again.");

                    rowMove = SafeInput.getRangedInt(in, player + ", choose a row (1-3): ", 1, 3) - 1;
                    colMove = SafeInput.getRangedInt(in, player + ", choose a column (1-3): ", 1, 3) - 1;
                }
                board[rowMove][colMove] = player;
                moveCount++;
                if (moveCount >= 5)
                {
                    if (isWin(player))
                    {
                        display();
                        System.out.println(player + " wins!");
                        gameOver = true;
                    }
                    else if (isTie())
                    {
                        display();
                        System.out.println("The game is a tie!");
                        gameOver = true;
                    }
                }

                if (!gameOver)
                {
                    player = player.equals("X") ? "O" : "X";
                }
            }
            playAgain = SafeInput.getYNConfirm(in, "Would you like to play again?");
        } while (playAgain);
    }
    private static void clearBoard()
    {
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                board[row][col] = " ";
            }
        }
    }
    private static void display()
    {
        for (int row = 0; row < ROWS; row++)
        {
            System.out.print(" ");
            for (int col = 0; col < COLS; col++)
            {
                System.out.print(board[row][col]);
                if (col < COLS - 1)
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < ROWS - 1)
            {
                System.out.println("---+---+---");
            }
        }
    }
    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }
    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }
    private static boolean isRowWin(String player)
    {
        for (int row = 0; row < ROWS; row++)
        {
            boolean win = true;
            for (int col = 0; col < COLS; col++)
            {
                if (!board[row][col].equals(player))
                {
                    win = false;
                }
            }
            if (win)
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isColWin(String player)
    {
        for (int col = 0; col < COLS; col++)
        {
            boolean win = true;
            for (int row = 0; row < ROWS; row++)
            {
                if (!board[row][col].equals(player))
                {
                    win = false;
                }
            }
            if (win)
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player)
    {
        boolean diagonalWin = true;
        boolean otherDiagonalWin = true;
        for (int i = 0; i < ROWS; i++)
        {
            if (!board[i][i].equals(player))
            {
                diagonalWin = false;
            }
            if (!board[i][COLS - 1 - i].equals(player))
            {
                otherDiagonalWin = false;
            }
        }
        return diagonalWin || otherDiagonalWin;
    }
    private static boolean isTie()
    {
        boolean full = true;
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (board[row][col].equals(" "))
                {
                    full = false;
                }
            }
        }
        if (full)
        {
            return true;
        }
        for (int row = 0; row < ROWS; row++)
        {
            String[] line = new String[COLS];
            for (int col = 0; col < COLS; col++)
            {
                line[col] = board[row][col];
            }
            if (!isBlocked(line))
            {
                return false;
            }
        }
        for (int col = 0; col < COLS; col++)
        {
            String[] line = new String[ROWS];
            for (int row = 0; row < ROWS; row++)
            {
                line[row] = board[row][col];
            }
            if (!isBlocked(line))
            {
                return false;
            }
        }
        String[] diagonal = new String[ROWS];
        String[] otherDiagonal = new String[ROWS];
        for (int i = 0; i < ROWS; i++)
        {
            diagonal[i] = board[i][i];
            otherDiagonal[i] = board[i][COLS - 1 - i];
        }
        return isBlocked(diagonal) && isBlocked(otherDiagonal);
    }
    private static boolean isBlocked(String[] line)
    {
        boolean hasX = false;
        boolean hasO = false;
        for (int i = 0; i < line.length; i++)
        {
            if (line[i].equals("X"))
            {
                hasX = true;
            }
            if (line[i].equals("O"))
            {
                hasO = true;
            }
        }
        return hasX && hasO;
    }
}

