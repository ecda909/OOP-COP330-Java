/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package core;

import java.awt.Color;

/**
 *
 * @author eder
 */

public class Disc
{
    private Color color;

    /**
     * @return the color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    
    //this is shadowing
    //the argument name is the same as the class's field
    //we use the keyboard 'this' to differentiate between them
    
    public void setColor(Color color) //shadowing not necessary, can change the argument color to something else.
    {
        this.color = color;
    }
    
}
