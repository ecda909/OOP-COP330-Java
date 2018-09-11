/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author edermazariegos
 */
public class Game {
    
    private ArrayList<Player> players;
    private Board board;
    
    
    public Game(){
        
        
        initObjects();
        
    }
    
    private void initObjects()
    {
        setBoard(new Board());
    createPlayers();
    
    printPlayers();
        
    }
 
    private void createPlayers()
    {
        
        setPlayers(new ArrayList<Player>());
        
        for(int i=0;i<Constants.MAX_PLAYERS;i++){
            
            String name = JOptionPane.showInputDialog(null,"enter your name!");
            Player player = new Player();
            player.setName(name);
            
            
            if(i==Constants.PLAYER_ONE)
                player.setDiscolor(Constants.DARK);
            else if (i==Constants.PLAYER_TWO)
                player.setDiscolor(Constants.LIGHT);
            
            getPlayers().add(player);
            
        }
        
    }
    
    private void printPlayers(){
        
        System.out.println("This game has the following players: ");
        
        for(Player player : getPlayers())
        {
            System.out.println("Player "+player.getName()+" is playing disc color" + player.getDiscolor());
        }
       
        
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }
            
            
}
