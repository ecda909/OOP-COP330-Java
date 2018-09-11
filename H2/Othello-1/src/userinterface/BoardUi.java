/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import core.Constants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author edermazariegos
 */

public class BoardUi extends JPanel{

    private JButton [][] board;
    private BoardListener listener;
    
    public BoardUi (){
    
        initcomponents();
    }
   
    

    private void initcomponents() {
        
    this.setPreferredSize(new Dimension(60,60));
    this.setMinimumSize(new Dimension (400,400));
    this.setLayout(new GridLayout(Constants.ROWS, Constants.COLUMNS));
    
    board = new JButton [Constants.ROWS][Constants.COLUMNS];
    listener = new BoardListener();
    
    for(int row = 0; row < Constants.ROWS; row++){
        
        for (int col = 0; col < Constants.COLUMNS; col++)
        {
            board [row][col] = new JButton();
            board [row][col].putClientProperty("row", row);
            board [row][col].putClientProperty("col", col);
            board [row][col].putClientProperty("color", Constants.EMPTY);
            board [row][col].setBackground(Color.GREEN);
            board [row][col].addActionListener(listener);     
            
            this.add(board[row][col]);
        }
    }
}
    private class BoardListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            
            
                if (ae.getSource() instanceof JButton){
                
                    JButton button = (JButton) ae.getSource();
                    
                    int row = (int) button.getClientProperty("row");
                    int col = (int) button.getClientProperty("col");
                    Color color = (Color)button.getClientProperty("color");
                    
                if (color == null)
                    board[row][col].setIcon(new ImageIcon(getClass().getResource("../images/darkcoin.gif")));
                            
                }
            }
         }        
    }

