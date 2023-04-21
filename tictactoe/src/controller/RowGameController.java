package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import model.Player;
import view.BlockIndex;
import view.RowGameGUI;

public class RowGameController {
	public RowGameModel gameModel;
	public RowGameGUI gameView;

	// Add a new button to the GUI for undo functionality
	private JButton undo = new JButton("Undo");

	/**
	 * Creates a new game initializing the GUI.
	 */
	public RowGameController() {
		gameModel = new RowGameModel();
		gameView = new RowGameGUI(this);
		///////////////
		// add undo button to the GUI
		// gameView.gui.add(undo, BorderLayout.SOUTH);

		// add action listener to the undo button
		// undo.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// undoMove();
		// }
		// });
		////////////////
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				gameModel.blocksData[row][column].setContents("");
				gameModel.blocksData[row][column].setIsLegalMove(true);
			}
		}

		gameView.update(gameModel);
	}

	//////////////
	public void undoMove() {
		if (gameModel.movesLeft == 9) {

			throw new IllegalStateException("Cannot undo before making a move");
		} else if (gameModel.movesLeft < 9) {
			gameModel.undoMove(); // call the undoMove() method of the model
			gameView.update(gameModel); // update the view with the new model state
		}
	}
	//////////////

	/**
	 * Moves the current player into the given block.
	 *
	 * @param block The block to be moved to by the current player
	 */
	public void move(JButton block) {
		// The Controller first manipulates the Model.
		gameModel.movesLeft--;

		BlockIndex blockIndex = gameView.getBlockIndex(block);
		if (gameModel.getPlayer().equals(Player.PLAYER_1)) {
			// Check whether player 1 won
			if (blockIndex.matches(0, 0)) {
				gameModel.blocksData[0][0].setContents("X");
				gameModel.blocksData[0][0].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(0, 0, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
							gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents()))
							||
							(gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents())
									&&
									gameModel.blocksData[1][0].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))
							||
							(gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[2][2].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(0, 1)) {
				gameModel.blocksData[0][1].setContents("X");
				gameModel.blocksData[0][1].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(0, 1, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
							gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents()))
							||
							(gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[2][1].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(0, 2)) {
				gameModel.blocksData[0][2].setContents("X");
				gameModel.blocksData[0][2].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(0, 2, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
							gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()))
							||
							(gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents())
									&&
									gameModel.blocksData[1][2].getContents()
											.equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(1, 0)) {
				gameModel.blocksData[1][0].setContents("X");
				gameModel.blocksData[1][0].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(1, 0, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
							gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents()))
							||
							(gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())
									&&
									gameModel.blocksData[0][0].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(1, 1)) {
				gameModel.blocksData[1][1].setContents("X");
				gameModel.blocksData[1][1].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(1, 1, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
							gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents()))
							||
							(gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents())
									&&
									gameModel.blocksData[0][1].getContents()
											.equals(gameModel.blocksData[2][1].getContents()))
							||
							(gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents())
									&&
									gameModel.blocksData[0][0].getContents()
											.equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents())
									&&
									gameModel.blocksData[0][2].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(1, 2)) {
				gameModel.blocksData[1][2].setContents("X");
				gameModel.blocksData[1][2].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(1, 2, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
							gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[1][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(2, 0)) {
				gameModel.blocksData[2][0].setContents("X");
				gameModel.blocksData[2][0].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(2, 0, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
							gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents())
									&&
									gameModel.blocksData[1][0].getContents()
											.equals(gameModel.blocksData[0][0].getContents()))
							||
							(gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[0][2].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(2, 1)) {
				gameModel.blocksData[2][1].setContents("X");
				gameModel.blocksData[2][1].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(2, 1, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
							gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[0][1].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(2, 2)) {
				gameModel.blocksData[2][2].setContents("X");
				gameModel.blocksData[2][2].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_2);
				gameModel.recordMove(2, 2, Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
							gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()))
							||
							(gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents())
									&&
									gameModel.blocksData[1][2].getContents()
											.equals(gameModel.blocksData[0][2].getContents()))
							||
							(gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[0][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			}
		} else {
			// Check whether player 2 won
			if (blockIndex.matches(0, 0)) {
				gameModel.blocksData[0][0].setContents("O");
				gameModel.blocksData[0][0].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(0, 0, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
							gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents()))
							||
							(gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents())
									&&
									gameModel.blocksData[1][0].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))
							||
							(gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[2][2].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(0, 1)) {
				gameModel.blocksData[0][1].setContents("O");
				gameModel.blocksData[0][1].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(0, 1, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
							gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents()))
							||
							(gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[2][1].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(0, 2)) {
				gameModel.blocksData[0][2].setContents("O");
				gameModel.blocksData[0][2].setIsLegalMove(false);
				gameModel.recordMove(0, 2, Player.PLAYER_2);
				gameModel.setPlayer(Player.PLAYER_1);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
							gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()))
							||
							(gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents())
									&&
									gameModel.blocksData[1][2].getContents()
											.equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(1, 0)) {
				gameModel.blocksData[1][0].setContents("O");
				gameModel.blocksData[1][0].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(1, 0, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
							gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents()))
							||
							(gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())
									&&
									gameModel.blocksData[0][0].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(1, 1)) {
				gameModel.blocksData[1][1].setContents("O");
				gameModel.blocksData[1][1].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(1, 1, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
							gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents()))
							||
							(gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents())
									&&
									gameModel.blocksData[0][1].getContents()
											.equals(gameModel.blocksData[2][1].getContents()))
							||
							(gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents())
									&&
									gameModel.blocksData[0][0].getContents()
											.equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents())
									&&
									gameModel.blocksData[0][2].getContents()
											.equals(gameModel.blocksData[2][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(1, 2)) {
				gameModel.blocksData[1][2].setContents("O");
				gameModel.blocksData[1][2].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(1, 2, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
							gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[1][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(2, 0)) {
				gameModel.blocksData[2][0].setContents("O");
				gameModel.blocksData[2][0].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(2, 0, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
							gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents())
									&&
									gameModel.blocksData[1][0].getContents()
											.equals(gameModel.blocksData[0][0].getContents()))
							||
							(gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[0][2].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(2, 1)) {
				gameModel.blocksData[2][1].setContents("O");
				gameModel.blocksData[2][1].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(2, 1, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
							gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents()))
							||
							(gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[0][1].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			} else if (blockIndex.matches(2, 2)) {
				gameModel.blocksData[2][2].setContents("O");
				gameModel.blocksData[2][2].setIsLegalMove(false);
				gameModel.setPlayer(Player.PLAYER_1);
				gameModel.recordMove(2, 2, Player.PLAYER_2);
				if (gameModel.movesLeft < 7) {
					if ((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
							gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()))
							||
							(gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents())
									&&
									gameModel.blocksData[1][2].getContents()
											.equals(gameModel.blocksData[0][2].getContents()))
							||
							(gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents())
									&&
									gameModel.blocksData[1][1].getContents()
											.equals(gameModel.blocksData[0][0].getContents()))) {
						gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
						endGame();
					} else if (gameModel.movesLeft == 0) {
						gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
					}
				}
			}
		}

		// The Controller then updates the View.
		gameView.update(gameModel);
	}

	/**
	 * Ends the game disallowing further player turns.
	 */
	public void endGame() {
		// The Controller first manipulates the Model.
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				gameModel.blocksData[row][column].setIsLegalMove(false);
			}
		}

		// The Controller then updates the View.
		gameView.update(gameModel);
	}

	/**
	 * Resets the game to be able to start playing again.
	 */
	public void resetGame() {
		// The Controller first manipulates the Model.
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				gameModel.blocksData[row][column].reset();
				gameModel.blocksData[row][column].setIsLegalMove(true);
			}
		}
		gameModel.setPlayer(Player.PLAYER_1);
		gameModel.movesLeft = 9;
		gameModel.setFinalResult(null);

		// The Controller then updates the View.
		gameView.update(gameModel);
	}
}
