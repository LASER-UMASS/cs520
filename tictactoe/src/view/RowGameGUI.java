package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import view.RowGameStatusView.GameStatus;
import controller.RowGameController;

public class RowGameGUI {
    public JFrame gui = new JFrame("Tic Tac Toe");
    public RowGameModel gameModel = new RowGameModel();
    //public JButton[][] blocks = new JButton[3][3];
    public JButton reset = new JButton("Reset");
    //public JTextArea playerturn = new JTextArea();
    public RowGameBoardView boardView = new RowGameBoardView();
    public RowGameStatusView statusView = new RowGameStatusView();


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

        messages.add(statusView.playerturn);
        this.updateStatus(GameStatus.START);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.resetGame();
            }
        });

        // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                boardView.blocks[row][column] = new JButton();
                boardView.blocks[row][column].setPreferredSize(new Dimension(75,75));
                game.add(boardView.blocks[row][column]);
                boardView.blocks[row][column].addActionListener(new ActionListener() {
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
        this.boardView.update(gameModel, row, column);
    }

    /**
     * Gets the block
     * 
     * @return block
     */
    public JButton[][] getBlocks(){
        return this.boardView.blocks;
    }

    public void updateStatus(GameStatus status){
        statusView.update(status);
    }

    public void disableButtons(){
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
            this.getBlocks()[row][column].setEnabled(false);
            }
        }
    }
}
