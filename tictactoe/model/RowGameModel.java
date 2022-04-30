package model;

// Import Java classes.
import javax.swing.JButton;

// Import GameOverType enum types and view class.
import enums.GameOverType;
import view.RowGameGUI;

/**
 * The RowGameModel class represents the model of the game.
 */
public class RowGameModel {

    /**
     * The data representation of the game.
     */
    private RowBlockModel[][] blocksData;

    /**
     * The number of colums in the game.
     */
    private int cols;

    /**
     * The number of rows in the game.
     */
    private int rows;

    /**
     * The particular view to update after each model update.
     */
    private RowGameGUI gameView;

    /**
     * The current player.
     */
    private int player = 1;

    /**
     * The amount of moves remaining until tie.
     */
    private int movesLeft = 9;

    /**
     * The final state of the game.
     */
    private GameOverType gameOverState;

    /**
     * Class that contains functionality for the model of the TicTacToe game
     *
     * @param rows The number of rows in the game.
     * @param cols The number of columns in the game.
     */
    public RowGameModel(int rows, int cols) {
        /**
         * Rows and columns for the game are set to the values passed in.
         */
        this.rows = rows;
        this.cols = cols;

        /**
         * The blocksData array is initialized to the size of the rows and
         * columns.
         */
        blocksData = new RowBlockModel[this.cols][this.rows];

        /**
         * Each block in the blocksData array is initialized to a new RowBlockModel.
         */
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                blocksData[row][col] = new RowBlockModel();
            }
        }
    }

    /**
     * Return the final game over state of the game.
     * @return TIE or WIN based on the final game over state of the game.
     */
    public GameOverType getGameOverState() {
        return gameOverState;
    }

    /**
     * Returns the current player whose turn it is.
     * @return the current player.
     */
    public int getCurrentTurn() {
        if (this.player == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Return the amount of moves left in the game.
     *
     * @return the amount of moves left in the game.
     */
    public int getMovesLeft() {
        return this.movesLeft;
    }

    /**
     * Update the current player's turn based on the number of moves remaining.
     */
    public void updateCurrentTurn() {
        if (this.getMovesLeft() % 2 == 0) {
            this.player = 2;
        } else {
            this.player = 1;
        }
    }

    /**
     * Returns the shape associated with the current player.
     * @return "X" if player 1, "O" if player 2.
     */
    public String getShape() {
        if (this.getCurrentTurn() == 1) {
            return "X";
        } else {
            return "O";
        }
    }

    /**
     * Decrements the number of moves left by one.
     * Then, update whose turn it is.
     */
    public void decrementTurn() {
        this.movesLeft--;
        updateCurrentTurn();
    }

    /**
     * Returns the number of rows in the game.
     *
     * @return The number of rows in the game.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Returns the number of columns in the game.
     *
     * @return The number of columns in the game.
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * Places the current player's shape in the specified row and column.
     * First, check to ensure move is legal.
     * Then, set contents and make move.
     * Update view of gameboard based on move.
     * Finally, check for game over and update view accordingly.
     *
     * @param row The row to place the shape in.
     * @param col The column to place the shape in.
     */
    public void move(int row, int col) {
        if (!this.blocksData[row][col].getIsLegalMove()) {
            return;
        }
        blocksData[row][col].setContents(this.getShape());
        blocksData[row][col].setIsLegalMove(false);
        gameView.updateBlockView(blocksData[row][col].getContents(), blocksData[row][col].getIsLegalMove(), row, col);
        boolean gameOver = checkForWinner(blocksData);
        if (gameOver == true) {
            this.endGame(GameOverType.WIN);
            return;
        }
        decrementTurn();
        if (this.movesLeft == 0) {
            this.endGame(GameOverType.TIE);
            return;
        }
        gameView.updateTurnView(getCurrentTurn());
    }

    /**
     * Checks if the game is over by win (three in a row somewhere).
     *
     * @param blocksData The data representation of the game.
     * @return True if the game is over by win, false otherwise.
     */
    public boolean checkForWinner(RowBlockModel blocksData[][]) {
        return threeInARow(blocksData) || threeInAColumn(blocksData) || threeInADiagonal(blocksData);
    }

    /**
     * Check if there is a winner in the rows.
     * Calls helper method checkThree().
     *
     * @param blocksData The blocks to check
     * @return True if there is a winner in the rows, false otherwise
     */
    public boolean threeInARow(RowBlockModel blocksData[][]) {
        if (checkThree(blocksData[0][0], blocksData[0][1], blocksData[0][2]) ||
                checkThree(blocksData[1][0], blocksData[1][1], blocksData[1][2]) ||
                checkThree(blocksData[2][0], blocksData[2][1], blocksData[2][2])) {
            return true;
        }
        return false;
    }

    /**
     * Check if there is a winner in the columns.
     * Calls helper method checkThree().
     *
     * @param blocksData The data representation of the game.
     * @return True if there is a winner in the column, false otherwise.
     */
    public boolean threeInAColumn(RowBlockModel blocksData[][]) {
        if (checkThree(blocksData[0][0], blocksData[1][0], blocksData[2][0])
                || checkThree(blocksData[0][1], blocksData[1][1], blocksData[2][1])
                || checkThree(blocksData[0][2], blocksData[1][2], blocksData[2][2])) {
            return true;
        }
        return false;
    }

    /**
     * Check if there is a winner in the diagonal.
     * Calls helper method checkThree().
     *
     * @param blocksData The data representation of the game.
     * @return True if there is a winner in the diagonal, false otherwise.
     */
    public boolean threeInADiagonal(RowBlockModel blocksData[][]) {
        if (checkThree(blocksData[0][0], blocksData[1][1], blocksData[2][2])
                || checkThree(blocksData[0][2], blocksData[1][1], blocksData[2][0])) {
            return true;
        }
        return false;
    }

    /**
     * Check if three blocks have the same contents and are not empty.
     *
     * @param blockOne   The first block to check.
     * @param blockTwo   The second block to check.
     * @param blockThree The third block to check.
     * @return True if the blocks have the same contents and are not empty, false
     *         otherwise.
     */
    public boolean checkThree(RowBlockModel blockOne, RowBlockModel blockTwo, RowBlockModel blockThree) {
        if (blockOne.getContents().equals(blockTwo.getContents())
                && blockTwo.getContents().equals(blockThree.getContents())
                && !"".equals(blockOne.getContents())) {
            return true;
        }
        return false;
    }

    /**
     * This methods ends the game. All moves are disabled.
     * The gameOverState is set to the given type, and the view is updated to
     * reflect
     * the game over state.
     *
     * @param gameEndType The way in which the game endede (win, tie).
     */
    public void endGame(GameOverType gameEndType) {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.cols; column++) {
                blocksData[row][column].setIsLegalMove(false);
            }
        }
        if (gameEndType == GameOverType.WIN) {
            gameOverState = GameOverType.WIN;
            gameView.endGameView(getCurrentTurn());
        } else if (gameEndType == GameOverType.TIE) {
            gameOverState = GameOverType.TIE;
            gameView.endGameView(-1);
        }
    }

    /**
     * This method resets the data representation of the game.
     * The contents of all blocks are set to empty strings, and all moves are set to
     * legal.
     * The player is set to 1, and the number of moves left is set to 9.
     * Finally, the view is updated to reflect the changes.
     */
    public void resetBoard() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.cols; column++) {
                blocksData[row][column].reset();
                blocksData[row][column].setIsLegalMove(true);
                gameView.updateBlockView(blocksData[row][column].getContents(),
                        blocksData[row][column].getIsLegalMove(),
                        row, column);
            }
        }
        this.player = 1;
        this.movesLeft = 9;
        gameView.updateTurnView(getCurrentTurn());
    }

    /**
     * This method returns the data represetation of the board.
     *
     * @return blocksData The data representation of the board.
     */
    public RowBlockModel[][] getGameBoard() {
        return this.blocksData;
    }

    /**
     * Given a view, this method sets the view for the model.
     *
     * @param gameView The model for the game.
     */
    public void addView(RowGameGUI gameView) {
        this.gameView = gameView;
    }
}
