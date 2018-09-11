/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package core;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eder
 */
public class Game
{
                     //Angle brackets, diamond brackets, v-brackets.
    private ArrayList<Player> players; //array lists are like a linked list in C
    private Board board;
    //assignment 3
    private Player currentPlayer;
    
    //This is a constructor (like a malloc in C) the first method that gets called 
    //needs to be in a constructor. afterwards, it can call any other method that it needs
    //but to start, you need it in a constructor that has the same name of the class.
    
    //this is overloading the constructor
    //we HAVE to have this constructor because we're doing something (initObjects();)
    //Default behavior it's just allocating memory public Game() { } (no arguments and nothing between the brackets
    // but here we're changing the default behavior. We're allocating memory
    // and calling the method initObjects();
    //if we werent calling anything then the compiler takes care of it, if we dont explicitly include it
    public Game()
    {
        initObjects(); //not the same as the one in the Board class
    }
    
    private void initObjects()
    {
        setBoard(new Board()); //why isn't this board = new Board(); Answer: this is just one way to do it.
                                
        createPlayers();
        //get rid of this?
        printPlayers();
        
        //assignment 3
        board.setPlayers(players);
        currentPlayer = players.get(Constants.PLAYER_TWO);
        
        //both players start with a score of two
        players.get(Constants.PLAYER_ONE).setScore(Constants.TWO);        
        players.get(Constants.PLAYER_TWO).setScore(Constants.TWO);      
    }
    
    private void createPlayers()
    {
        setPlayers(new ArrayList<>()); // ?????? Answer: allocating memory || ArrayList like linked list in C just errthing works by itself
        // players = new ArrayList<>; same thing as above. instanziation 
        
        for(int i = 0; i<Constants.MAX_PLAYERS; i++)
        {
            String name = JOptionPane.showInputDialog(null, "Enter your name:");
            Player player = new Player();
            player.setName(name);
            
            if(i == Constants.PLAYER_ONE)
                player.setDiscColor(Constants.LIGHT);
            else if (i == Constants.PLAYER_TWO)
                player.setDiscColor(Constants.DARK);
            
            getPlayers().add(player);
            //players.add(player);
            
        }
    }
    
    public void calculateScore()
    {
        //calculate score for each color
        board.calculateScore();
        //the score of player one is the amount of darks
        players.get(Constants.PLAYER_ONE).setScore(board.getLightCount());
        //lights for player two
        players.get(Constants.PLAYER_TWO).setScore(board.getDarkCount());
    }
    private void printPlayers()
    {
        System.out.println("The game has the following players:");
        
        for(Player player : getPlayers()) //foreach   //player place holder here to access the data
        {
            System.out.println("Player " + player.getName() + " is playing disc color " + player.getDiscColor());
        }
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players)
    {
        this.players = players;
    }

    /**
     * @return the board
     */
    public Board getBoard()
    {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board)
    {
        this.board = board;
    }

    /**
     * @return the currentPlayer
     */
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    public void setCurrentPlayer(Player currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }
}
