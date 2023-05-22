package controller;

import model.BlockIndex;


/**
 * The HumanRowGameController class supports Player 1 being a human
 * and Player 2 also being a humun.
 *
 * NOTE) This class is applying the Template method design pattern 
 *       for the following game rules: move, undo.
 */
public class HumanRowGameController extends RowGameController
{
    public HumanRowGameController() {
	super();
    }
    
    public BlockIndex move(BlockIndex blockIndex) {
        basicMove(blockIndex);

	return blockIndex;
    }

    public void undo() {
        basicUndo();
    }
}
