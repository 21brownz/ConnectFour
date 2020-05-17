public class ConnectFour implements BoardGame {
    @Override
    public void newGame() {

    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public int getWinner() {
        return 0;
    }

    @Override
    public Position[] getWinningPositions() {
        return new Position[0];
    }

    @Override
    public boolean columnFull(int column) {
        return false;
    }

    @Override
    public void play(int column) {

    }

    @Override
    public int[][] getBoard() {
        return new int[0][];
    }
}
