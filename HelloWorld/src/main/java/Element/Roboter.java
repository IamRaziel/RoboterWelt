/*
 * Roboter.java
 *
 * created at 2021-06-27 by p.simon <p.simon@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package Element;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;

public class Roboter extends Element
{
    private Blickrichtung blickrichtung;
    private Element aufgehobenesElement;

    public Roboter(int posX, int posY)
    {
        super(posX, posY);
        blickrichtung = Blickrichtung.RECHTS;
        loadImage();
    }

    public void schritt()
    {
        posX += diffX();
        posY += diffY();
    }

    public boolean aufheben(Set<Element> allElements)
    {
        if (aufgehobenesElement == null)
        {
            int aPosX = posX + diffX();
            int aPosY = posY + diffY();

            for (Element e : allElements)
            {
                if (e.getPosX() == aPosX && e.getPosY() == aPosY)
                {
                    if (e.isAufhebbar())
                    {
                        aufgehobenesElement = e;
                        break;
                    }
                }
            }
            if (aufgehobenesElement != null)
            {
                allElements.remove(aufgehobenesElement);
                return true;
            }
        }

        return false;
    }

    public boolean ablegen(Set<Element> allElements)
    {
        if (aufgehobenesElement != null)
        {
            int aPosX = posX + diffX();
            int aPosY = posY + diffY();

            for (Element e : allElements)
            {
                if (e.getPosX() == aPosX && e.getPosY() == aPosY)
                {
                    return false;
                }
            }
            aufgehobenesElement.setPosX(aPosX);
            aufgehobenesElement.setPosY(aPosY);
            allElements.add(aufgehobenesElement);
            aufgehobenesElement = null;
            return true;
        }
        return false;
    }

    public void dreheLinks()
    {
        Blickrichtung alt = blickrichtung;
        if (alt == Blickrichtung.LINKS)
        {
            blickrichtung = Blickrichtung.UNTEN;
        }
        else if (alt == Blickrichtung.UNTEN)
        {
            blickrichtung = Blickrichtung.RECHTS;
        }
        else if (alt == Blickrichtung.RECHTS)
        {
            blickrichtung = Blickrichtung.OBEN;
        }
        else if (alt == Blickrichtung.OBEN)
        {
            blickrichtung = Blickrichtung.LINKS;
        }
        loadImage();
    }

    private void loadImage()
    {
        StringBuilder pathBuilder = new StringBuilder("resources/Roboter_");
        pathBuilder.append(blickrichtung.toString().charAt(0));
        pathBuilder.append(".png");
        try
        {
            image = ImageIO.read(new File(pathBuilder.toString()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private int diffX()
    {
        int x = 0;
        if (blickrichtung == Blickrichtung.LINKS)
        {
            x--;
        }
        else if (blickrichtung == Blickrichtung.RECHTS)
        {
            x++;
        }
        return x;
    }

    private int diffY()
    {
        int y = 0;
        if (blickrichtung == Blickrichtung.OBEN)
        {
            y--;
        }
        else if (blickrichtung == Blickrichtung.UNTEN)
        {
            y++;
        }
        return y;
    }
}



