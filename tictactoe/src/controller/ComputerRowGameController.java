package controller;

import model.BlockIndex;


/**
 * The ComputerRowGameController class supports Player 1 being a human
 * and Player 2 being a computer.
 *
 * NOTE) This class is applying the Template method design pattern 
 *       for the following game rules: move, undo.
 */
public class ComputerRowGameController extends RowGameController
{
    public ComputerRowGameController() {
	super();
    }

    public BlockIndex move(BlockIndex blockIndex) {
	// First the human player takes a turn
	basicMove(blockIndex);

	// Second the computer player takes a turn
	// if the human player did not already win
	// or tie the game.
	BlockIndex computerBlockIndex = null;
	if (gameModel.getFinalResult() == null) {
	    for (int row = 0; row < 3; row++) {
		for (int column = 0; column < 3; column++) {
		    // Find the first available legal move
		    if (gameModel.blocksData[row][column].getIsLegalMove() == true) {
			computerBlockIndex = new BlockIndex(row, column);
			break;
		    }
		} // end for column
	    } // end for row
	    basicMove(computerBlockIndex);
	}
	return computerBlockIndex;
    }

    public void undo() {
	// Since the move method had both Player 1 and Player 2 take turns,
	// the undo method also needs to have both Players undo those turns.
	basicUndo();
	basicUndo();
    }
}

					
