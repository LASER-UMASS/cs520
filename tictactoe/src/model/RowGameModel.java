package model;

public class RowGameModel 
{
    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];
    /**
     * The current player taking their turn
     */
    public String player = "1";
    public int movesLeft = 9;

    public RowGameModel() {
	super();

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocksData[row][column] = new RowBlockModel(this);
                blocksData[row][column].setContents("");
                blocksData[row][column].setIsLegalMove(true);
	    } // end for column
	} // end for row
    }
}
