/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author edermazariegos
 */

public class GameUi extends JPanel{

      private JLabel nameOne;
      private JLabel nameTwo;
      private JLabel scoreOne;
      private JLabel scoreTwo;
      
      public GameUi(){
      
          initcomponents();
      }
      private void initcomponents(){
      
          this.setPreferredSize(new Dimension(60, 60));
          this.setMinimumSize(new Dimension(100,50));
          this.setBackground(Color.orange);
          
          nameOne = new JLabel ("Eder");
          nameOne.setMinimumSize(new Dimension(100,50));
          nameOne.setPreferredSize(new Dimension(100,50));
          nameOne.setBackground(Color.ORANGE);
          nameOne.setFont(new Font ("serif",Font.BOLD, 22));
          
          nameTwo = new JLabel("Chip");
          nameTwo.setMinimumSize(new Dimension(100,50));
          nameTwo.setPreferredSize(new Dimension(100,50));
          nameTwo.setBackground(Color.BLACK);
          nameTwo.setFont(new Font ("serif",Font.BOLD, 22));
          
          scoreOne = new JLabel ("43");
          scoreOne.setMinimumSize(new Dimension(100,50));
          scoreOne.setPreferredSize(new Dimension(100,50));
          scoreOne.setBackground(Color.BLACK);
          scoreOne.setFont(new Font ("serif",Font.BOLD, 22));
          
          scoreTwo = new JLabel ("45");
          scoreTwo.setMinimumSize(new Dimension(100,50));
          scoreTwo.setPreferredSize(new Dimension(100,50));
          scoreTwo.setBackground(Color.BLACK);
          scoreTwo.setFont(new Font ("serif",Font.BOLD, 22));
          
          this.add(nameOne);
          this.add(scoreOne);
          this.add(nameTwo);
          this.add(scoreTwo);
      }
}

