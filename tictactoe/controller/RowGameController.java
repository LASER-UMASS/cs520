package controller;

// Import Swing classes.
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

// Import model class.
import model.RowGameModel;

/**
 * Class that contains functionality for the controller of the TicTacToe game
 */
public class RowGameController {

	/**
	 * Controller is responsible for sending input to one particular model
	 */
	private RowGameModel gameModel;

	/**
	 * Constructor for the TicTacToe controller.
	 */
	public RowGameController() {
	}

	/**
	 * Given player input on a square in the view of the TicTacToe game, this method
	 * finds the block that was clicked, associates it with a row and column number,
	 * then calls move() in the model to update the data in model.
	 *
	 * @param block The block that was clicked.
	 * @param blocks The array of blocks in the view.
	 */
	public void move(JButton block, JButton blocks[][]) {
		int row = -1;
		int col = -1;
		for (int i = 0; i < gameModel.getRows(); i++) {
			for (int j = 0; j < gameModel.getCols(); j++) {
				if (blocks[i][j] == block) {
					row = i;
					col = j;
					break;
				}
			}
		}
		gameModel.move(row, col);
	}

	/**
	 * Given player input to reset button, this method calls resetBoard() in the
	 * model
	 * to initialize the data in the model to return to a default state.
	 */
	public void resetGame() {
		gameModel.resetBoard();
	}

	/**
	 * Given a model, this method sets the model for the controller.
	 *
	 * @param gameModel The model for the game.
	 */
	public void addModel(RowGameModel gameModel) {
		this.gameModel = gameModel;
	}

}
