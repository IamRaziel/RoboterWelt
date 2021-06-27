/*
 * Element.java
 *
 * created at 2021-06-27 by p.simon <p.simon@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package Element;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public abstract class Element
{
    protected Image image;
    protected int posX;
    protected int posY;
    protected boolean aufhebbar;

    public Element(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        aufhebbar = false;
    }


    public int getPosX()
    {
        return posX;
    }


    public void setPosX(int posX)
    {
        this.posX = posX;
    }


    public int getPosY()
    {
        return posY;
    }


    public void setPosY(int posY)
    {
        this.posY = posY;
    }


    public boolean isAufhebbar()
    {
        return aufhebbar;
    }


    public void paint(Graphics g, int size, int border)
    {
        if (image != null)
        {
            g.drawImage(image, posX * size + border + 1, posY * size + border + 1, size - 1, size - 1, Color.YELLOW, null);
        }
        else
        {
            g.setColor(Color.BLACK);
            g.fillRect(posX * size + border, posY * size + border, size, size);
        }
    }
}
