package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import model.RowBlockModel.PlayerPiece;
import model.RowGameModel.Player;
import view.RowGameGUI;
import view.RowGameStatusView.GameStatus;

public class RowGameController {
    public RowGameModel gameModel;
    public RowGameGUI gameView;

    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameController() {
	gameModel = new RowGameModel();
	gameView = new RowGameGUI(this);

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
	        	gameModel.blocksData[row][column].setPiece(PlayerPiece.Empty);
				gameModel.blocksData[row][column].setIsLegalMove(true);
				gameView.updateBlock(gameModel,row,column);
            }
        }
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(JButton block) {
	gameModel.movesLeft--;
	if(gameModel.movesLeft%2 == 1) {
	    //gameView.statusView.playerturn.setText("'X': Player 1");
		gameView.updateStatus(GameStatus.P1TURN);
	} else{
	    //gameView.statusView.playerturn.setText("'O': Player 2");
		gameView.updateStatus(GameStatus.P2TURN);
	}
	
	winChecker(block);
    }

	/**
	 *Checks the board to see if a player has won
	 *  
	 * @param block the board the players are playing on
	 */
	public void winChecker(JButton block) {
		if(gameModel.player == Player.One) {
		    playerWinCheck(block, true);
		} else {
			playerWinCheck(block, false);
		}
	}

	/**
	 *Checks if the last placed piece makes a row-of-three of the same piece
	 *  
	 * @param x column index of the piece
	 * @param y row index of the piece
	 * @return boolean
	 */
	public boolean rowChecker(int x, int y){
		return gameModel.blocksData[y][0].getContents().equals(gameModel.blocksData[y][1].getContents()) &&
			gameModel.blocksData[y][1].getContents().equals(gameModel.blocksData[y][2].getContents());
	}

	/**
	 *Checks if the last placed piece makes a column-of-three of the same piece
	 *  
	 * @param x column index of the piece
	 * @param y row index of the piece
	 * @return boolean
	 */
	public boolean columnChecker(int x, int y){
		return gameModel.blocksData[0][x].getContents().equals(gameModel.blocksData[1][x].getContents()) &&
			gameModel.blocksData[1][x].getContents().equals(gameModel.blocksData[2][x].getContents());
	}

	/**
	 *Checks if the last placed piece makes a diagonal-of-three of the same piece
	 *  
	 * @param x column index of the piece
	 * @param y row index of the piece
	 * @return boolean
	 */
	public boolean diagChecker(int x, int y){
		if((x-y) == 2 || (x-y) == -2){
			return gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
				gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents());
		}
		else if((x-y) == 0){
			if((x == 1) && (y == 1)){
				return (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
				gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents())) || 
				(gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
				gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()));
			} else{
				return gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
				gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents());
			}
		} else{
			return false;
		}
	}

	/**
	 *Incorporates the functions above to check for three-in-a-row pieces
	 *  
	 * @param x column index of the piece
	 * @param y row index of the piece
	 * @return boolean
	 */
	public boolean lineChecker(int x, int y){
		//if you can check diagonally
		if((x-y)%2 == 0){
			return(columnChecker(x, y) || rowChecker(x, y) || diagChecker(x, y));
		}//else just check for lines
		else{
			return(columnChecker(x, y) || rowChecker(x, y));
		}
	}

	/**
	 * Sets the piece on the board for the specific player 
	 * 
	 * @param y row index of where the piece should be
	 * @param x column index of where the piece should be
	 * @param isPlayer1 boolean of whether it's player1's turn or not
	 */
	private void doTurn(int y, int x, boolean isPlayer1) {
		PlayerPiece playerPiece = isPlayer1 ? PlayerPiece.X : PlayerPiece.O;
		Player nextPlayer = isPlayer1 ? Player.Two : Player.One;
		GameStatus winMsg = isPlayer1 ? GameStatus.P1WIN : GameStatus.P2WIN;
		gameModel.blocksData[y][x].setPiece(playerPiece);
		gameView.updateBlock(gameModel,y,x);
		gameModel.player = nextPlayer;
		if(gameModel.movesLeft<7) {
		    if(lineChecker(x, y)) {
			gameModel.setFinalResult(winMsg);
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.updateStatus(gameModel.getFinalResult());
		    }
		}
	}

	/**
	 * Incorporates all the functions above to check for the winner
	 * If there is a three-in-a-row after the turn, player# wins
	 * 
	 * @param block board where the players are playing
	 * @param isPlayer1 boolean of whether it's player1's turn or not
	 */
	private void playerWinCheck(JButton block, boolean isPlayer1) {
		if(block==gameView.getBlocks()[0][0]) {
			doTurn(0, 0, isPlayer1);
		} else if(block==gameView.getBlocks()[0][1]) {
			doTurn(0, 1, isPlayer1);
		} else if(block==gameView.getBlocks()[0][2]) {
			doTurn(0, 2, isPlayer1);
		} else if(block==gameView.getBlocks()[1][0]) {
			doTurn(1, 0, isPlayer1);
		} else if(block==gameView.getBlocks()[1][1]) {
			doTurn(1, 1, isPlayer1);
		} else if(block==gameView.getBlocks()[1][2]) {
			doTurn(1, 2, isPlayer1);
		} else if(block==gameView.getBlocks()[2][0]) {
			doTurn(2, 0, isPlayer1);
		} else if(block==gameView.getBlocks()[2][1]) {
			doTurn(2, 1, isPlayer1);
		} else if(block==gameView.getBlocks()[2][2]) {
			doTurn(2, 2, isPlayer1);
		}
	}

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
		gameView.disableButtons();
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
		gameModel.blocksData[row][column].setIsLegalMove(true);
		gameView.updateBlock(gameModel,row,column);
            }
        }
        gameModel.player = Player.One;
        gameModel.movesLeft = 9;
		gameModel.setFinalResult(null);
        //gameView.statusView.playerturn.setText("Player 1 to play 'X'");
		gameView.updateStatus(GameStatus.START);
    }
}
