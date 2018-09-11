/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import core.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author edermazariegos
 */
public class Othelloui extends JFrame{
    private Game game;
    private GameUi gameUi;
    private BoardUi boardUi;
public Othelloui(Game game){
    this.game = game;
    initcomponents();
}         

    private void initcomponents() {
        this.setPreferredSize(new Dimension(600,600));
        this.setMinimumSize(new Dimension(600,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameUi = new GameUi ();
        boardUi = new BoardUi ();
        
        this.add(gameUi, BorderLayout.NORTH);
        this.add(boardUi, BorderLayout.CENTER);
        this.setVisible(true);
    }
}


