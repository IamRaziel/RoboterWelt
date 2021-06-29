/*
 * Haus.java
 *
 * created at 2021-06-28 by p.simon <p.simon@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Haus extends Element
{

   private Roboter r;



   public Haus(int posX, int posY)
    {
        super(posX, posY);
        try
        {
            image = ImageIO.read(new File("resources/Haus.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
       public void hineingehen(Roboter l)
       {
           r = l;
           r.setInHaus(true);
       }

       public Roboter herausgehen()
       {
           r.setInHaus(false);
           r.setPosX(posX);
           r.setPosY(posY + 1);
           r.setBlickrichtung(Blickrichtung.UNTEN);
           return r;
       }
       public Roboter getRoboter()
       {
           return r;
       }
}



