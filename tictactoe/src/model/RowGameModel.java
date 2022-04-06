package model;

import view.RowGameStatusView.GameStatus;

public class RowGameModel 
{
    /**
     * Type safety using enums
     */
    public enum Player {
        One, Two
    }
    public static final GameStatus GAME_END_NOWINNER = GameStatus.DRAW;

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
    public Player player = Player.One;
    public int movesLeft = 9;

    private GameStatus finalResult = null;


    public RowGameModel() {
	super();

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public GameStatus getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(GameStatus finalResult) {
	this.finalResult = finalResult;
    }
}
