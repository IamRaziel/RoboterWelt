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

import Element.Roboter;
import Oberfläche.Map;

public class Main
{
    private Map m;
    private Roboter r;

    public static void main(String[] args)
    {
       new Main();
    }

    public Main()
    {
        m = new Map(10, 10, al);
    }



    //BUTTON CLICK
    private ActionListener al = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Hier kommt dein Code hinein



        }
    };
}



