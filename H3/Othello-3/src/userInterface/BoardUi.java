 /*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package userInterface;

import core.Constants;
import core.Disc;
import core.Game;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author eder
 */
public class BoardUi extends JPanel
{
    private JButton[][] board;
    private BoardListener listener;
    private Game game;
    private GameUi gameUi;
    private boolean move; 
    //no argument constructor
    public BoardUi(Game game, GameUi gameUi)
    {
        this.game = game;
        this.gameUi = gameUi;
        initComponents();
        listener.updateUi();

    } 
    
    private void initComponents()
    {
        //dimensions for the board and layout type
        this.setPreferredSize(new Dimension(500,500));
        this.setMinimumSize(new Dimension(500,500));
        this.setLayout(new GridLayout(Constants.ROWS,Constants.COLS));

        //making a 2D array of JButtons (as in, JButton is the allowed data type)
        board = new JButton[Constants.ROWS][Constants.COLS];
        
        //initializing the listener
        listener = new BoardListener();
        
        move = true;
        
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col < Constants.COLS; col++)
            {
                //this is different than line 39 because this is actually filling the 2D array with JButtons.
                board[row][col] = new JButton();
                board[row][col].putClientProperty("row", row);
                board[row][col].putClientProperty("col", col);
                //setting it to empty because in the future if the value of color
                //isn't empty at that spot, the we know there is a disk there?
                board[row][col].putClientProperty("color", Constants.EMPTY);
                
                board[row][col].setBackground(Color.CYAN);
                
                //register action listener
                board[row][col].addActionListener(listener);
                this.add(board[row][col]);
                 
            }
            
        }
        
    }

    private class BoardListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() instanceof JButton)
            {
                JButton button = (JButton)ae.getSource();
                int i = (int)button.getClientProperty("row");
                int j = (int)button.getClientProperty("col");
                Color color = (Color)button.getClientProperty("color");
                
                move = true;
                 
                if(isValidMove(i, j, game.getCurrentPlayer().getDiscColor(), move))
                {
                     updateUi();
                     changePlayer();
                }
                else{
                     //if(gameOver(game.getCurrentPlayer().getDiscColor()) == true)
                     if(game.getBoard().gameOver(game.getPlayers().get(Constants.PLAYER_ONE).getScore(),
                             game.getPlayers().get(Constants.PLAYER_TWO).getScore()))
                     {
                         if(game.getPlayers().get(Constants.PLAYER_ONE).getScore()
                            > game.getPlayers().get(Constants.PLAYER_TWO).getScore())
                         {
                             JOptionPane.showMessageDialog(null, "Player one wins!");
                         }
                         else if(game.getPlayers().get(Constants.PLAYER_TWO).getScore()
                            > game.getPlayers().get(Constants.PLAYER_ONE).getScore())
                         {
                             JOptionPane.showMessageDialog(null, "Player two wins!");
                         }                
                         else
                             JOptionPane.showMessageDialog(null, "Tie game!");      
                     }
                     
                    else
                     {
                         JOptionPane.showMessageDialog(button, "Invalid move. Select again");
                     }    
                
                }
                   
            }
        }   
        
        private void updateUi()
        {
            Disc[][] discs = game.getBoard().getBoard();
            ImageIcon disc = null;

            for(int row = 0; row < Constants.ROWS; row++)
            {
                for(int col = 0; col < Constants.COLS; col++)
                {
                    if(discs[row][col].getColor() == Constants.LIGHT)
                    {
                        disc = new ImageIcon(getClass().getResource("../images/meg.png"));
                        disc = imageResize(disc);
                        board[row][col].setIcon(disc);
                        board[row][col].putClientProperty("color", Constants.LIGHT);
                    }
                    else if(discs[row][col].getColor() == Constants.DARK)
                    {
                        disc = new ImageIcon(getClass().getResource("../images/robotnik.gif"));
                        disc = imageResize(disc);
                        board[row][col].setIcon(disc);
                        board[row][col].putClientProperty("color", Constants.DARK);
                    }
                }
            }
            
            gameUi.getScoreOne().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_ONE).getScore()));
            gameUi.getScoreTwo().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_TWO).getScore()));
        }  
    }
    
        private boolean isValidMove(int row, int col, Color color, boolean move)
        {
            boolean valid = false;
            move = true; 
            
            if(board[row][col].getClientProperty("color") != Constants.EMPTY)
            {
                valid = false;
            }
            //call the isValidMove from board
            else if(game.getBoard().isValidMove(row, col, color, move))
            {
                valid = true;
            }

            return valid;
        }      
    
    private ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    
        private void changePlayer()
        {
        if(game.getCurrentPlayer() == game.getPlayers().get(Constants.PLAYER_ONE))
            game.setCurrentPlayer(game.getPlayers().get(Constants.PLAYER_TWO));
        else
            game.setCurrentPlayer(game.getPlayers().get(Constants.PLAYER_ONE)); 
        }
}