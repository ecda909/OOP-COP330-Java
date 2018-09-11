 /*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package userInterface;

import core.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author eder
 */
public class OthelloUi extends JFrame
{
    private Game game;
    private GameUi gameUi;
    private BoardUi boardUi;
    
    //constructor with an argument of ' Game ' type
    public OthelloUi(Game game)
    {
        this.game = game;
        initComponents();
    }
    
    private void initComponents()
    {
        //dimensions for the game
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        
        //need this so when the UI is closed, the program
        //is also closed. otherwise, program stays opened
        //in the background. MEMORY LEAKS!
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameUi = new GameUi(game);
        boardUi = new BoardUi(game, gameUi);
        
        this.add(gameUi, BorderLayout.NORTH);
        this.add(boardUi, BorderLayout.CENTER);
        this.setVisible(true);
    }
}