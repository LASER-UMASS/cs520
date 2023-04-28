package model;

import java.util.Stack;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
    private Player player = Player.PLAYER_1;
    public int movesLeft = 9;

    private String finalResult = null;

    /** Supports undo functionality */
    private Stack<BlockIndex> historyOfMoves = new Stack<BlockIndex>();
    
    
    public RowGameModel() {
	super();

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public Player getPlayer() {
	return this.player;
    }

    public void setPlayer(Player player) {
	// Perform input validation
	if (player == null) {
	    throw new IllegalArgumentException("The player must be non-null.");
	}

	this.player = player;
    }
    
    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }

    public void addToHistoryOfMoves(BlockIndex move) {
	this.historyOfMoves.push(move);
    }

    public void clearHistoryOfMoves() {
	this.historyOfMoves.clear();
    }

    public void undo() {
	// Check pre-conditions
	if (this.historyOfMoves.isEmpty()) {
	    throw new UnsupportedOperationException("Undo is not currently allowed.");
	}

	// "Erase" the last move.
	BlockIndex lastMove = this.historyOfMoves.pop();
	this.blocksData[lastMove.getRow()][lastMove.getColumn()].setContents("");
	this.blocksData[lastMove.getRow()][lastMove.getColumn()].setIsLegalMove(true);
	if (this.player == Player.PLAYER_1) {
	    this.player = Player.PLAYER_2;
	}
	else {
	    this.player = Player.PLAYER_1;
	}
	this.movesLeft++;
    }
}
