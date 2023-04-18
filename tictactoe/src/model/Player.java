package model;


public enum Player
{
    PLAYER_1(1), PLAYER_2(2);

    private int id;

    
    private Player(int id) {
	this.id = id;
    }

    public int getID() {
	return this.id;
    }
    
    public String toString() {
	return "" + this.getID();
    }
}
