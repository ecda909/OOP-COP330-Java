/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package core;

import java.awt.Color;
import java.util.ArrayList;

public class Board
{
    private Disc [][] board;  // 2D array called board
    //assignment 3
    private int darkCount;
    private int lightCount;
    private ArrayList<Player> players;
    ///
    public Board() //answered in Game class.
    {
        initObjects(); //calling the method
    }
    
    private void initObjects() //this is a method definition. In OOP order doesn't matter
    {
        board = new Disc[Constants.ROWS][Constants.COLS];
        
        for(int row = 0; row < Constants.ROWS; row++)
            for(int col = 0; col < Constants.COLS; col++)
                board[row][col] = new Disc();
        
        board[3][3].setColor(Constants.LIGHT);
        board[3][4].setColor(Constants.DARK);
        board[4][3].setColor(Constants.DARK);
        board[4][4].setColor(Constants.LIGHT);

    }

    public boolean isValidMove(int row, int col, Color color, boolean move)
    {
        boolean valid = false;
        
        if(checkUp(row, col, color, move))
        {
            valid = true;
        }
        if(checkUpLeft(row, col,color, move))
        {
            valid = true;
        }
        if(checkLeft(row, col, color, move))
        {
            valid = true;
        }
        if(checkLeftDown(row, col, color, move))
        {
            valid = true;
        }
        if(checkDown(row, col, color, move))
        {
            valid = true;
        }
        if(checkDownRight(row, col, color, move))
        {
            valid = true;
        }
        if(checkRight(row, col, color, move))
        {
            valid = true;
        }
        if(checkUpRight(row, col,color, move))
        {
            valid = true;
        }
        //probably put calculateScore(); here instead of calling it after every
        //check up move
        return valid;
    }
    
    private boolean checkUp(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0;
        int checkRow = row - 1; //no need to check current row, check the one above
        boolean matchFound = false;
        boolean validMove = false;
        
        while(checkRow >= 0 && !matchFound)
        {
            if(board[checkRow][col].getColor() == Constants.EMPTY)
            {
                //this square is empty. Nothing to flip. invalid move.
                return validMove;
            }
            else if(board[checkRow][col].getColor() != color)
            {
                //the square has the opposite player's color. valid move
                flipSquares++;
            }
            else
            {
                matchFound = true;
            }
            
            checkRow--;
        }
        
        if(matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
            
            board[row][col].setColor(color);        /*This is how the rest of your check functions should be*/
            do          /*The do while loop covers only the rows above the current spot*/
            {
                row--;
                flipSquares--;
                board[row][col].setColor(color);
            }while(flipSquares > 0);
            
            validMove = true;
        }
        else
            validMove = false;
        
        calculateScore();
        
        return validMove;
             
    }
    
    private boolean checkDown(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0; 
        int checkRow= row + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow < Constants.ROWS && !matchFound)
        {
            
            if (board[checkRow][col].getColor() == Constants.EMPTY)
            {
                //validMove = false;
                return validMove;
            }
            else if (board[checkRow][col].getColor()!= color)
            {
                flipSquares++;
                
            }
            else
            {
                matchFound = true;
            }    
                
            checkRow++;
        }
            
        if (matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
                        
            board[row][col].setColor(color);
            do
            {
                row++;
                flipSquares--;
                board[row][col].setColor(color);                
            }while(flipSquares > 0);
            
            validMove = true;
        }    

        else
            validMove = false;
  
        calculateScore();        
        return validMove;
    }
    
    private boolean checkLeft(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0; 
        int checkCol= col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkCol >= 0 && !matchFound)
        {
            
            if (board[row][checkCol].getColor()== Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[row][checkCol].getColor()!= color)
            {
                flipSquares++;
                
            }
            else
            {
                matchFound = true;
            }    
                
            checkCol--;
        }
            
        if (matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
                        
            board[row][col].setColor(color);
            do
            {
                col--;
                flipSquares--;
                board[row][col].setColor(color);                
            }while(flipSquares > 0);
            
            validMove = true;
        }

        else
            validMove = false;

        calculateScore();        
        return validMove;
    }
    
    private boolean checkRight(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0; 
        int checkCol= col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkCol < Constants.COLS && !matchFound)
        {
            
            if (board[row][checkCol].getColor()== Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[row][checkCol].getColor()!= color)
            {
                flipSquares++;
                
            }
            else
            {
                matchFound = true;
            }    
                
            checkCol++;
        }
            
        if (matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
                        
            board[row][col].setColor(color); 
            do
            {
                col++;
                flipSquares--;
                board[row][col].setColor(color);                
            }while(flipSquares > 0);
            
            validMove = true;
        }   
        else
            validMove = false;  

        calculateScore();        
        return validMove;
    }
    
    private boolean checkUpLeft(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0; 
        int checkRow= row - 1;
        int checkCol= col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow >= 0 && checkCol >= 0 && !matchFound)
        {
            
            if (board[checkRow][checkCol].getColor()== Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][checkCol].getColor()!= color)
            {
                flipSquares++;
                
            }
            else
            {
                matchFound = true;
            }    
                
            checkRow--; 
            checkCol--;
        }
            
        if (matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
                        
            board[row][col].setColor(color);
            do
            {
                row--;
                col--;
                flipSquares--;
                board[row][col].setColor(color);               
            } 
            while(flipSquares > 0);
            
            validMove = true;
        }   
        else
            validMove = false;
        
        calculateScore();
        return validMove;
    }
    
    private boolean checkLeftDown(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0; 
        int checkRow= row + 1;
        int checkCol= col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow < Constants.ROWS && checkCol >= 0 && !matchFound)
        {
            
            if (board[checkRow][checkCol].getColor()== Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][checkCol].getColor()!= color)
            {
                flipSquares++;
                
            }
            else
            {
                matchFound = true;
            }    
                
            checkRow++; 
            checkCol--;
        }
            
        if (matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
                      
            board[row][col].setColor(color);
            do
            {
                row++;
                col--;
                flipSquares--;
                board[row][col].setColor(color);                
            } while(flipSquares > 0);
            
            validMove = true;
        }
         else
            validMove = false;

        calculateScore();       
        return validMove;
    }
    
    private boolean checkUpRight(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0; 
        int checkRow= row - 1;
        int checkCol= col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow >= 0  && checkCol < Constants.COLS && !matchFound)
        {
            
            if (board[checkRow][checkCol].getColor()== Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][checkCol].getColor()!= color)
            {
                flipSquares++;
                
            }
            else
            {
                matchFound = true;
            }    
                
            checkRow--; 
            checkCol++;
        }
            
        if (matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
                        
            board[row][col].setColor(color);
            do
            {
                row--;
                col++;
                flipSquares--;
                board[row][col].setColor(color);                
            } 
            while(flipSquares > 0);
            
            validMove = true;
        }

        else
            validMove = false;

        calculateScore();        
        return validMove;
    }

    private boolean checkDownRight(int row, int col, Color color, boolean move)
    {
        int flipSquares = 0; 
        int checkRow= row + 1;
        int checkCol= col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow < Constants.ROWS && checkCol < Constants.COLS && !matchFound)
        {
            
            if (board[checkRow][checkCol].getColor()== Constants.EMPTY)
            {
                return validMove;
            }
            else if (board[checkRow][checkCol].getColor()!= color)
            {
                flipSquares++;
                
            }
            else
            {
                matchFound = true;
            }    
                
            checkRow++; 
            checkCol++;
        }
            
        if (matchFound && flipSquares > 0)
        {
            if(move == false)
                return true;
                        
            board[row][col].setColor(color);
            do
            {
                row++;
                col++;
                flipSquares--;
                board[row][col].setColor(color);                
            } 
            while(flipSquares > 0);
            
            validMove = true;
        }   

        else
            validMove = false;

        calculateScore();
        return validMove;
    }
    
    public void calculateScore()
    {
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col < Constants.COLS; col++)
            {
                if(board[row][col].getColor() == Constants.DARK)
                    darkCount++;
                else if(board[row][col].getColor() == Constants.LIGHT)
                    lightCount++;
            }
        }
        
        players.get(Constants.PLAYER_ONE).setScore(lightCount);
        players.get(Constants.PLAYER_TWO).setScore(darkCount);
        darkCount = 0;
        lightCount = 0;
                
    }
    
    public boolean gameOver(int scoreOne, int scoreTwo)
    {
        boolean over = false;
        
        if(scoreOne + scoreTwo == 64)
            return true;
        
        if(!availMove(Constants.DARK) || !availMove(Constants.LIGHT))
            over = true;
        return over;
        
    }
    
    public boolean availMove(Color color)
    {
        boolean valMove = false;
        
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col < Constants.COLS; col++)
            {
                if(board[row][col].getColor() == Constants.EMPTY && isValidMove(row, col, color, false))
                    valMove = true;
            }
        }
        
        return valMove;
    }

    /**
     * @return the board
     */
    public Disc[][] getBoard()
    {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Disc[][] board)
    {
        this.board = board;
    }

    /**
     * @return the darkCount
     */
    public int getDarkCount()
    {
        return darkCount;
    }

    /**
     * @param darkCount the darkCount to set
     */
    public void setDarkCount(int darkCount)
    {
        this.darkCount = darkCount;
    }

    /**
     * @return the lightCount
     */
    public int getLightCount()
    {
        return lightCount;
    }

    /**
     * @param lightCount the lightCount to set
     */
    public void setLightCount(int lightCount)
    {
        this.lightCount = lightCount;
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
}
