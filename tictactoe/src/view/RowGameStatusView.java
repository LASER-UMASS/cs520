package view;

import javax.swing.JTextArea;

/**
 * Type safety using enums
 */
public class RowGameStatusView {
    public enum GameStatus {
        P1WIN, P2WIN, DRAW, P1TURN, P2TURN, START
    }

    public JTextArea playerturn = new JTextArea();

    public void update(GameStatus status){
        switch(status){
            case START:
                this.playerturn.setText("Player 1 to play 'X'");
                break;
            case P1TURN:
                this.playerturn.setText("'X': Player 1");
                break;
            case P2TURN:
                this.playerturn.setText("'O': Player 2");
                break;
            case P1WIN:
                this.playerturn.setText("Player 1 wins!");
                break;
            case P2WIN:
                this.playerturn.setText("Player 2 wins!");
                break;
            case DRAW:
                this.playerturn.setText("Game ends in a draw");
                break;
            default:
                break;
        }
    }
}
