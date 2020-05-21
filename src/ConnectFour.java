/**
 * Connect four game main class.
 * Support classes developed by github.com/juliancochran
 * Check for win algorithm developed with help from github.com/memsdm05
 * @version 5/21/20
 * @author 21brownz
 */

public class ConnectFour implements BoardGame {
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;
    private int winner;

    /**
     * instantiates a new game.
     */
    @Override
    public void newGame() {
    board = new int[6][7];
    currentPlayer = 1;
    winner = 0;
    }

    /**
     * defines a gameover state.
     * @return if game is over.
     */
    @Override
    public boolean gameOver() {
        if (currentPlayer == 1){
            currentPlayer = 2;
        } else{
            currentPlayer = 1;
        }
        checkForWin();
        if (currentPlayer == 1){
            currentPlayer = 2;
        } else{
            currentPlayer = 1;
        }
        return winner > 0 || isBoardFull();
    }

    /**
     * getter for the winner param
     * @return winner
     */
    @Override
    public int getWinner() {
        return winner;
    }

    /**
     * getter for the winning positions
     * @return winning positions
     */
    @Override
    public Position[] getWinningPositions() {
        return winningPositions;
    }

    /**
     * checks to see if the column is full
     * @param column the column number
     * @return boolean whether the column is full
     */
    @Override
    public boolean columnFull(int column) {
        return board[0][column] > 0;
    }

    /**
     * defines a play.
     * @param column the column number
     */
    @Override
    public void play(int column) {
        if (!columnFull(column)) {
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][column] == 0) {
                    board[i][column] = currentPlayer;
                    currentPlayer = (currentPlayer == 1)? 2 : 1;
                    return;
                }
            }
        }
    }

    /**
     * checks to see if the board is full
     * @return boolean whether the board is full
     */
    private boolean isBoardFull() {
        int full = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (columnFull(col)) {
                full++;
            }
        }
        return full == board[0].length;
    }

    /**
     * checks to see if the board contains any winning states.
     * memsdm05 (20browner) helped out a bunch with this method.
     */
    private void checkForWin() {
        winningPositions = new Position[]{new Position()};
        // checks for horizontal win.
        for (int j = 0; j < board[0].length - 3; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == currentPlayer && board[i][j + 1] == currentPlayer && board[i][j + 2] == currentPlayer && board[i][j + 3] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j), new Position(i, j+1), new Position(i, j+2), new Position(i, j+3)};
                    winner = currentPlayer;
                }
            }
        }
        // checks for vertical win.
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == currentPlayer && board[i + 1][j] == currentPlayer && board[i + 2][j] == currentPlayer && board[i + 3][j] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j), new Position(i+1, j), new Position(i+2, j), new Position(i+3, j)};
                    winner = currentPlayer;
                }
            }
        }
        // checks for diagonal up win
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i][j] == currentPlayer && board[i - 1][j + 1] == currentPlayer && board[i - 2][j + 2] == currentPlayer && board[i - 3][j + 3] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j), new Position(i-1, j+1), new Position(i-2, j+2), new Position(i-3, j+3)};
                    winner = currentPlayer;
                }
            }
        }
        // checks for diagonal down win
        for (int i = 3; i < board.length; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (board[i][j] == currentPlayer && board[i - 1][j - 1] == currentPlayer && board[i - 2][j - 2] == currentPlayer && board[i - 3][j - 3] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j), new Position(i-1, j-1), new Position(i-2, j-2), new Position(i-3, j-3)};
                    winner = currentPlayer;
                }
            }
        }
    }

    /**
     * gets the board state
     * @return a 2d array of the board
     */
    @Override
    public int[][] getBoard() {
        return board;
    }
}
