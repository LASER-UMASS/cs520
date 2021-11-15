package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.Player;
import model.RowGameModel;
import controller.RowGameController;

public class RowGameGUI implements RowGameView {
    public JFrame gui = new JFrame("Tic Tac Toe");
    public JButton[][] blocks = new JButton[3][3];
    public JButton reset = new JButton("Reset");
    public JTextArea playerturn = new JTextArea();

    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameGUI(RowGameController controller) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.resetGame();
            }
        });

        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
			controller.move((JButton)e.getSource());
                    }
                });
            }
        }
    }

    /**
     * Updates the block at the given row and column 
     * after one of the player's moves.
     *
     * @param gameModel The RowGameModel containing the block
     * @param row The row that contains the block
     * @param column The column that contains the block
     */
    public void updateBlock(RowGameModel gameModel, int row, int column) {
	blocks[row][column].setText(gameModel.blocksData[row][column].getContents());
	blocks[row][column].setEnabled(gameModel.blocksData[row][column].getIsLegalMove());
    }

    public void update(RowGameModel gameModel) {
	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		this.updateBlock(gameModel, row, col);
	    } // end for col
	} // end for row

	if (gameModel.getFinalResult() == null) {
	    if(gameModel.getMovesLeft()%2 == 1) {
	        playerturn.setText("'X': " + Player.PLAYER_1.getLabel());
	    } else{
		playerturn.setText("'O': " + Player.PLAYER_2.getLabel());
	    }
	}
	else {
	    playerturn.setText(gameModel.getFinalResult());
	}
    }
}
