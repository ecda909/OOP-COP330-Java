/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package othello;

// importing core package to use its classes
import core.Game;
import userInterface.OthelloUi;

public class Othello
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Game game = new Game();   
        OthelloUi userInterface = new OthelloUi(game);
    }
    
}
