package controller;

import javax.swing.JButton;

import model.Player;
import model.RowGameModel;
import view.RowGameGUI;


public class ThreeInARowGameRules extends AbstractRowGameRules
{

    public ThreeInARowGameRules(RowGameModel gameModel, RowGameGUI gameView) {
	super(gameModel, gameView);
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(JButton block) {
	gameModel.setMovesLeft(gameModel.getMovesLeft() - 1);
	
	if(gameModel.getPlayer().equals(Player.PLAYER_1)) {
	    // Check whether player 1 won
	    if(block==gameView.boardGameView.blocks[0][0]) {
		gameModel.blocksData[0][0].setContents("X");
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("X");
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("X");
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("X");
		gameModel.blocksData[1][0].setIsLegalMove(false);
		// The block on top of this block is now a legal move.
		gameModel.blocksData[0][0].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("X");
		gameModel.blocksData[1][1].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[0][1].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("X");
		gameModel.blocksData[1][2].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[0][2].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("X");
		gameModel.blocksData[2][0].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[1][0].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("X");
		gameModel.blocksData[2][1].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[1][1].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("X");
		gameModel.blocksData[2][2].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[1][2].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    }
	} else {
	    // Check whether player 2 won
	    if(block==gameView.boardGameView.blocks[0][0]) {
		gameModel.blocksData[0][0].setContents("O");
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("O");
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("O");
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("O");
		gameModel.blocksData[1][0].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[0][0].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("O");
		gameModel.blocksData[1][1].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[0][1].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("O");
		gameModel.blocksData[1][2].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[0][2].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("O");
		gameModel.blocksData[2][0].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[1][0].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("O");
		gameModel.blocksData[2][1].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[1][1].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.boardGameView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("O");
		gameModel.blocksData[2][2].setIsLegalMove(false);
		// The block on top of this block is now a legal move. 
		gameModel.blocksData[1][2].setIsLegalMove(true);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.getMovesLeft()<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.getMovesLeft()==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		}
	    }
	}

	// The Observer design pattern is now doing the following.
	//gameView.update(gameModel);
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void reset() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
		// Initially, the bottom row contains the legal moves.
		if (row == 2) {
		    gameModel.blocksData[row][column].setIsLegalMove(true);
		}
	    }
        }
        gameModel.setPlayer(Player.PLAYER_1);
        gameModel.setMovesLeft(9);
	gameModel.setFinalResult(null);

	// The Observer design pattern is now doing the following. 
	//gameView.update(gameModel);
    }
}
