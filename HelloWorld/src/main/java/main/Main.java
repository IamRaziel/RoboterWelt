/*
 * Main.java
 *
 * created at 2021-06-27 by p.simon <p.simon@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Element.Baum;
import Element.Element;
import Element.Haus;
import Element.Paket;
import Element.Roboter;
import Oberfläche.Map;

public class Main
{
    private Map m;
    private Roboter r;
    private Roboter r2;

    private List<Roboter> rList = new ArrayList();

    public static void main(String[] args)
    {
       new Main();
    }

    public Main()
    {
        m = new Map(10, 10, al, alSchritt, alaufheben);

        Roboter r = new Roboter (0, 4);
        m.addElement(r);
        Baum c = new Baum (2, 3);
        m.addElement(c);
        Baum b = new Baum(1, 2);
        m.addElement(b);
       Paket p = new Paket (2, 1);
       m.addElement(p);
       Baum d = new Baum (4, 1);
       m.addElement(d);
       Haus h = new Haus (4, 4);
       m.addElement(h);
       Baum e = new Baum (9, 9);
       m.addElement(e);
       Baum f = new Baum (9, 4);
       m.addElement(f);
       Baum g = new Baum (5, 8);
       m.addElement(g);
       Baum i = new Baum (7, 9);
       m.addElement(i);
       Baum j = new Baum (0, 5);
       m.addElement(j);
       m.paint();
    }

    private int Ganzzahl = 0;
    private String Text = "Hallo";
    private boolean WahrFalsch = true;
    private double Kommazahl = 0.0;


    //BUTTON CLICK
    private ActionListener al = new ActionListener()
    {
        private int click = 0;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hier kommt dein Code hinein

            while (true)
            {
               if(r.isInHaus())
               {
                   for(Element temp : m.getElements())
                   {
                       if(temp instanceof Haus && ((Haus)temp).getRoboter().equals(r))
                       {
                           m.addElement( ((Haus)temp).herausgehen());
                           break;
                       }
                   }
               }
               else if (r.feldIstFrei(m.getElements(), m.getMaxX(), m.getMaxY()))
               {
                   r.schritt();
               }
               else
               {
                   Haus h = r.isHaus(m.getElements());
                   if(h != null)
                   {
                       h.hineingehen(r);
                       m.getElements().remove(r);
                   }
                   else
                   {
                       double random = Math.random();
                       if (random < 0.5)
                       {
                          r.dreheLinks();
                       }
                       else
                       {
                           r.dreheRechts();
                       }
                   }
               }

//               if (r2.feldIstFrei(m.getElements(), m.getMaxX(), m.getMaxY()))
//               {
//                   r2.schritt();
//               }
//
//               else
//               {
//                   double random = Math.random();
//                   if (random < 0.5)
//                   {
//                      r2.dreheLinks();
//                   }
//                   else
//                   {
//                       r2.dreheRechts();
//                   }
//
//
//               }

               warte ();
                m.paint();
            }

        }
    };

    //BUTTON CLICK
    private ActionListener alSchritt = new ActionListener()
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hier kommt dein Code hinein


            if (r.feldIstFrei(m.getElements(), m.getMaxX(), m.getMaxY()))
            {
                r.schritt();
            }
            else
            {
                r.dreheRechts();
                r.schritt();
               warte ();
               m.paint();
                r.dreheLinks();
                r.schritt();
                warte ();
                m.paint();
                r.schritt();
                r.dreheLinks();
                warte ();
                m.paint();
                r.schritt();
                r.dreheRechts();
            }
            m.paint();
        }
    };

    //BUTTON CLICK
    private ActionListener alaufheben = new ActionListener()
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hier kommt dein Code hinein

            r.aufheben(m.getElements());
       m.paint();
        }
    };

    private void warte()
    {
        try
        {
            Thread.sleep(300);
        }
        catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
    }
}



