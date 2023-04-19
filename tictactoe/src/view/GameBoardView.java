package view;

import controller.RowGameController;
import model.RowGameModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * The GameBoardView class visualizes the game board of blocks.
 *
 * NOTE) For the Composite design pattern, this class is-a Component (i.e. View).
 */
public class GameBoardView implements View
{
    private JButton[][] blocks = new JButton[3][3];

    
    public GameBoardView(JPanel game, RowGameController controller) {
	super();

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
     * Returns the BlockIndex (pair of row and column) of the given block
     * if it is part of this game board and returns null otherwise.
     *
     * @param block The block of interest
     * @return The BlockIndex (pair of row and column) of the given block
     *         if it is part of this game board and null otherwise
     */
    public BlockIndex getBlockIndex(JButton block) {
	for (int row = 0; row < 3; row++) {
	    for (int column = 0; column < 3; column++) {
		if (this.blocks[row][column] == block) {
		    // Found
		    return new BlockIndex(row, column);
		}
	    } // end for column
	} // end for row

	// Not found
	return null;
    }

    public JButton getBlockFromIndex(int x, int y) {
        return this.blocks[x][y];
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
    
    public void update(RowGameModel model) {
	for (int row = 0; row < 3; row++) {
	    for (int column = 0; column < 3; column++) {
		updateBlock(model, row, column);
	    } // end for col
	} // end for row
    }
} // end for GameBoardView
