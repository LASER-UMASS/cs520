package controller;

import javax.swing.JButton;

import model.Player;
import model.RowGameModel;
import view.RowGameGUI;

public class RowGameController {
    public RowGameModel gameModel;
    public RowGameGUI gameView;
    private AbstractRowGameRules gameRulesStrategy;
    public static final String TIC_TAC_TOE_GAME_RULES = "TicTacToe";
    public static final String THREE_IN_A_ROW_GAME_RULES = "ThreeInARow";


    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameController(String gameRulesStrategyName) {
	gameModel = new RowGameModel();
	gameView = new RowGameGUI(this);
	if (THREE_IN_A_ROW_GAME_RULES.equals(gameRulesStrategyName)) {
	    gameRulesStrategy = new ThreeInARowGameRules(gameModel, gameView);
	}
	else if (TIC_TAC_TOE_GAME_RULES.equals(gameRulesStrategyName)) {
	    gameRulesStrategy = new TicTacToeGameRules(gameModel, gameView);
	}
	else {
	    throw new UnsupportedOperationException("The game rules to follow must be specified as either " + TIC_TAC_TOE_GAME_RULES + " or as " + THREE_IN_A_ROW_GAME_RULES + ".");
	}

	// Apply the Observer design pattern
	//
	// In this case, the RowGameGUI (the composite) is registered.
	// Alternatively, the RowBoardGameView and RowGameStatusView 
	// (the components) could be registered.
	gameModel.register(gameView);

	this.resetGame();
    }

    private BlockIndex getBlockIndex(JButton block) {
	for (int row = 0; row < 3; row++) {
	    for (int column = 0; column < 3; column++) {
		if (block == gameView.boardGameView.blocks[row][column]) {
		    return new BlockIndex(row, column);
		}
	    } // end for column
	} // end for row

	return null;
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(JButton block) {
	// Check the pre-conditions for a legal move
	BlockIndex blockIndex = this.getBlockIndex(block);
	if ((blockIndex == null) || 
	    (gameModel.blocksData[blockIndex.getRow()][blockIndex.getColumn()].getIsLegalMove() == false)) {
	    return;
	}

	gameRulesStrategy.move(block);
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
	gameRulesStrategy.reset();
    }
}
