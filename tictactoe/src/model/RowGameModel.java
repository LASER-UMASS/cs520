package model;

import java.util.Stack;

public class RowGameModel {
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
    private Player player = Player.PLAYER_1;
    public int movesLeft = 9;

    public String finalResult = null;

    private Stack<Move> moveHistory = new Stack<>(); // Stack to store move history

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

    /**
     * Method to handle undo functionality. Allows undoing the previous move if
     * there
     * are moves to undo.
     */
    public void undoMove() {
        if (!moveHistory.isEmpty()) { // Check if there are moves to undo
            Move lastMove = moveHistory.pop(); // Pop the last move from the move history stack
            int row = lastMove.getRow();
            int col = lastMove.getCol();
            Player player = lastMove.getPlayer();

            // Undo the move by resetting the contents of the corresponding block
            blocksData[row][col].reset();
            blocksData[row][col].setIsLegalMove(true);

            // Update the model state
            this.player = player;
            this.movesLeft++;
        }
    }

    /**
     * Method to record a move in the move history stack.
     *
     * @param row    The row index of the block where the move was made
     * @param col    The column index of the block where the move was made
     * @param player The player who made the move
     */
    public void recordMove(int row, int col, Player player) {
        moveHistory.push(new Move(row, col, player));
    }

    /**
     * Inner class to represent a move made by a player.
     */
    private static class Move {
        private int row;
        private int col;
        private Player player;

        public Move(int row, int col, Player player) {
            this.row = row;
            this.col = col;
            this.player = player;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public Player getPlayer() {
            return player;
        }
    }
}