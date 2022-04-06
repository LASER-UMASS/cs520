package model;

import model.RowGameModel.Player;

/**
 * The TicTacToeBlock class represents a given block in the game.
 */
public class RowBlockModel
{
    /**
     * Used enum to distinguish the pieces for each player for type safety
     */
    public enum PlayerPiece {
        Empty(""),
        X("X"),
        O("O");

        private final String str;
        PlayerPiece(String str){
            this.str = str;
        }
        @Override
        public String toString() {
            return this.str;
        }
    }
    /**
     * The game that contains this block
     */
    private RowGameModel game;

    /**
     * The current value of the contents of this block
     */
    private PlayerPiece contents;

    /**
     * Whether or not it is currently legal to move into this block
     */
    private boolean isLegalMove;

    /**
     * Creates a new block that will be contained in the given game.
     *
     * @param rowGameModel The game that will contain the new block
     * @throws IllegalArgumentException When the given game is null
     */
    public RowBlockModel(RowGameModel rowGameModel) {
	super();

	if (rowGameModel == null) {
	    throw new IllegalArgumentException("The game must be non-null.");
	}
	
	this.game = rowGameModel;
	this.reset();
    }

    public RowBlockModel(RowBlockModel block){
        this.game = block.game;
        this.contents = block.contents;
        this.isLegalMove = block.isLegalMove;
    }

    public RowGameModel getGame() {
	return this.game;
    }

    /**
     * Sets the contents of this block to the given value.
     *
     * @param value The new value for the contents of this block
     * @throws IllegalArgumentException When the given value is null
     */
    public void setPiece(PlayerPiece playerPiece) {
        if (playerPiece == null) {
            throw new IllegalArgumentException("The value must be non-null.");
        }
        this.contents = playerPiece;
        if(playerPiece == PlayerPiece.Empty){
            this.isLegalMove = true;
        } else{
            this.isLegalMove = false;
        }
    }

    public PlayerPiece getPiece(){
        return this.contents;
    }

    /**
     * Returns the non-null String value of the contents of this block.
     *
     * @return The non-null String value
     */
    public String getContents() {
	return this.contents.toString();
    }

    public void setIsLegalMove(boolean isLegalMove) {
	this.isLegalMove = isLegalMove;
    }

    public boolean getIsLegalMove() {
	return this.isLegalMove;
    }

    /**
     * Resets this block before starting a new game.
     */
    public void reset() {
	this.contents = PlayerPiece.Empty;
	this.isLegalMove = true;
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof RowBlockModel)){
            return false;
        }
        RowBlockModel o = (RowBlockModel) other;
        return this.game == o.game && this.contents == o.contents && this.isLegalMove == o.isLegalMove;
    }
}
