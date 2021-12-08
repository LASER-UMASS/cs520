package model;

import view.RowGameView;

import java.util.ArrayList;
import java.util.List;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
    private Player player = Player.PLAYER_1;
    private int movesLeft = 9;

    private String finalResult = null;

    // Apply the Observer design pattern
    //
    // The RowGameModel and RowBlockModel are the Observerables.
    private List<RowGameView> observers = new ArrayList<RowGameView>();


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

    /**
     * Sets the current player to the specified player.
     *
     * @param player The specified player
     * @throws IllegalArgumentException When the specified player is null
     */
    public void setPlayer(Player player) {
	if (player == null) {
	    throw new IllegalArgumentException("The player must be non-null.");
	}
	this.player = player;
	this.stateChange();
    }

    public int getMovesLeft() {
	return this.movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
	this.movesLeft = movesLeft;
	this.stateChange();
    }

    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
	this.stateChange();
    }

    public void register(RowGameView observer) {
	this.observers.add(observer);
    }

    public void unregister(RowGameView observer) {
	this.observers.remove(observer);
    }

    protected void stateChange() {
	for (RowGameView currentObserver : this.observers) {
	    currentObserver.update(this);
	} // end for currentObserver
    }
}
