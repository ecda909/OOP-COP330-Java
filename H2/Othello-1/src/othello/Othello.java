/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import core.Game;
import userinterface.Othelloui;
/**
 *
 * @author edermazariegos
 */
public class Othello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Game game = new Game();
        Othelloui Ui = new Othelloui(game);
        
    }
    
}
