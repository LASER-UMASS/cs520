package model;


public class BlockIndex
{
    private final int row;
    private final int column;

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
}
