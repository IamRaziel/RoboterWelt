/*
 * Baum.java
 *
 * created at 2021-06-27 by p.simon <p.simon@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Baum extends Element
{

    public Baum(int posX, int posY)
    {
        super(posX, posY);
        try
        {
            image = ImageIO.read(new File("resources/Baum.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}



