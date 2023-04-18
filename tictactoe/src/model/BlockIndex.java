package model;


public class BlockIndex
{
    private int row;
    private int column;

    public BlockIndex(int row, int column)
    {
	super();

	this.row = row;
	this.column = column;
    }

    public int getRow() {
	return this.row;
    }

    public int getColumn() {
	return this.column;
    }

    public boolean matches(int row, int column)
    {
	return ((this.getRow() == row) && (this.getColumn() == column));
    }

    public void updateIndex(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
