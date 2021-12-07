package controller;

import javax.swing.JButton;

import model.RowGameModel;
import view.RowGameGUI;


public abstract class AbstractRowGameRules
{
    protected RowGameModel gameModel;
    protected RowGameGUI gameView;


    protected AbstractRowGameRules(RowGameModel gameModel, RowGameGUI gameView) {
	super();
	this.gameModel = gameModel;
	this.gameView = gameView;
    }

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                this.gameModel.blocksData[row][column].setIsLegalMove(false);
            }
        }

        // The Observer design pattern is now doing the following. 
        //gameView.update(gameModel);
    }

    public abstract void move(JButton block);

    public abstract void reset();
} 
