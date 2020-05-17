
public class Position {
    private int row;
    private int column;

    public Position(){
        this.row = -1;
        this.column = -1;
    }

    public Position(int row, int col){
        this.row = row;
        this.column = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Position))
            return false;

        Position o = (Position)other;
        return this.getRow() == o.getRow() || this.getColumn() == o.getColumn();
    }
}
