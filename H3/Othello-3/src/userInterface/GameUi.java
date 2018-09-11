/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package userInterface;

import core.Constants;
import core.Game;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eder
 */
public class GameUi extends JPanel
{
    private Game game;
    private JLabel nameOne;
    private JLabel nameTwo;
    private JLabel scoreOne;
    private JLabel scoreTwo;
    
    //no argument constructor
    public GameUi(Game game)
    {
        this.game = game;
        initComponents();
    }
    
    private void initComponents()
    {
        //setting dimensions for the labels
        this.setPreferredSize(new Dimension(600,60));
        this.setMinimumSize(new Dimension(600,60));
        
        ImageIcon discOne = new ImageIcon(getClass().getResource("../images/meg.png"));
        discOne = imageResize(discOne);
   
        nameOne = new JLabel();
        nameOne.setIcon(discOne);
        nameOne.setText(game.getPlayers().get(Constants.PLAYER_ONE).getName());
        nameOne.setMinimumSize(new Dimension(100, 50));
        
        scoreOne = new JLabel();
        scoreOne.setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_ONE).getScore()));
        scoreOne.setMinimumSize(new Dimension(100,50));
        
        ImageIcon discTwo = new ImageIcon(getClass().getResource("../images/robotnik.gif"));
        discTwo = imageResize(discTwo);
        nameTwo = new JLabel();
        nameTwo.setIcon(discTwo);
        nameTwo.setText(game.getPlayers().get(Constants.PLAYER_TWO).getName());
        nameTwo.setMinimumSize(new Dimension(100,50));
            
        scoreTwo = new JLabel();
        scoreTwo.setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_TWO).getScore()));    
        scoreTwo.setMinimumSize(new Dimension(100,50));        
        //adding this to the current object
        this.add(nameOne);
        this.add(scoreOne);
        this.add(nameTwo);
        this.add(scoreTwo);
    }
    private ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    /**
     * @return the scoreOne
     */
    public JLabel getScoreOne()
    {
        return scoreOne;
    }

    /**
     * @param scoreOne the scoreOne to set
     */
    public void setScoreOne(JLabel scoreOne)
    {
        this.scoreOne = scoreOne;
    }

    /**
     * @return the scoreTwo
     */
    public JLabel getScoreTwo()
    {
        return scoreTwo;
    }

    /**
     * @param scoreTwo the scoreTwo to set
     */
    public void setScoreTwo(JLabel scoreTwo)
    {
        this.scoreTwo = scoreTwo;
    }

    /**
     * @return the game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game)
    {
        this.game = game;
    }
}
