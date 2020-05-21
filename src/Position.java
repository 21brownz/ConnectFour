/**
 * Class that defines a position
 * @author 21brownz
 * @version 5/21/20
 */
public class Position {
    private int row;
    private int column;

    /**
     * default constructor
     */
    public Position(){
        this.row = -1;
        this.column = -1;
    }

    /**
     * main constructor
     * @param row row of position
     * @param col column of position
     */
    public Position(int row, int col){
        this.row = row;
        this.column = col;
    }

    /**
     * getter for row parameter
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * setter for row parameter
     * @param row row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * getter for column parameter
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * setter for column parameter
     * @param column column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * checks to see if this position and another position are the same.
     * @param other position to check against
     * @return boolean equal
     */
    public boolean equals(Object other) {
        if (!(other instanceof Position))
            return false;

        Position o = (Position)other;
        return this.getRow() == o.getRow() || this.getColumn() == o.getColumn();
    }
}
