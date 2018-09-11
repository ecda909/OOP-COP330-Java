/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import static core.Constants.COLUMNS;
import static core.Constants.ROWS;

/**
 *
 * @author edermazariegos
 */
public class Board {
    
    private Disc[][] board;
    
    
 public Board(){
     
     initObjects();
     
     
 }
 
 private void initObjects(){
     
     board  = new Disc [Constants.ROWS][Constants.COLUMNS];
       
    for(int row = 0; row <Constants.ROWS;row++)
    {
        
    
        for(int col=0;col<Constants.COLUMNS;col++)
        {
                board[row][col] = new Disc();
        }
     
            }
     
    
            board[3][3].setColor(Constants.LIGHT);
            board[3][4].setColor(Constants.DARK);
            board[4][3].setColor(Constants.DARK);
            board[4][4].setColor(Constants.LIGHT);
    
    
    
    
 }
 
    /**
     * @return the board
     */
    public Disc[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Disc[][] board) {
        this.board = board;
    }
 
 
 
}
