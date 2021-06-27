/*
 * Map.java
 *
 * created at 2021-06-27 by p.simon <p.simon@seeburger.de>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package Oberfläche;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Element.Element;
import Element.Roboter;


public class Map extends JFrame
{
    private static final int FIELD_SIZE_WITH_BORDER = 51;
    private static final int BORDER_WIDTH = 100;

    private int width, height;
    private JPanel hintergrund = new JPanel();
    private JButton button;
    private Set<Element> elements = new HashSet();

    public Map(int width, int height, ActionListener al)
    {
        this.width = width;
        this.height = height;

        int h = height * FIELD_SIZE_WITH_BORDER + 2 * BORDER_WIDTH;
        int w = width * FIELD_SIZE_WITH_BORDER + 2 * BORDER_WIDTH;

        hintergrund.setBackground(Color.YELLOW);

        button = new JButton("button");
        button.addActionListener(al);
        hintergrund.add(button);

        this.setSize(new Dimension(w, h));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(hintergrund);
        this.setVisible(true);

        paintRuster();
        paintCellNames();
        paintElements();
    }


    public boolean addElement(Element e)
    {
         return elements.add(e);
    }

    public Element removeElement(int posX, int posY)
    {
        Element toRemove = null;
        for (Element e : elements)
        {
            if (e.getPosX() == posX && e.getPosY() == posY)
            {
                toRemove = e;
                break;
            }
        }
        elements.remove(toRemove);

        return toRemove;
    }

    public Set<Element> getElements()
    {
        return elements;
    }

    public void paint()
    {
        paintRuster();
        paintElements();
    }

    private void paintElements()
    {
        Graphics g = hintergrund.getGraphics();
        for (Element e : elements)
        {
            e.paint(g, FIELD_SIZE_WITH_BORDER, BORDER_WIDTH);
        }
        g.dispose();
    }

    private void paintRuster()
    {
         try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        int verticalLength = (height) * FIELD_SIZE_WITH_BORDER;
        int horizontalLength = (width) * FIELD_SIZE_WITH_BORDER;

        Graphics g = hintergrund.getGraphics();

        g.setColor(Color.YELLOW);

        g.fillRect(BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH + verticalLength, BORDER_WIDTH + horizontalLength);

        g.setColor(Color.BLACK);

        for (int x = 1; x < width; x++)
        {
            int pointX = BORDER_WIDTH + x * FIELD_SIZE_WITH_BORDER;
            int endPointY = BORDER_WIDTH + verticalLength;

            g.drawLine(pointX, BORDER_WIDTH, pointX, endPointY);
        }

        for (int y = 1; y < height; y++)
        {
            int pointY = BORDER_WIDTH + y * FIELD_SIZE_WITH_BORDER;
            int endPointX = BORDER_WIDTH + horizontalLength;

            g.drawLine(BORDER_WIDTH, pointY, endPointX, pointY);
        }

        g.dispose();
    }

    private void paintCellNames()
    {
        Graphics g = hintergrund.getGraphics();

        for (int x = 0; x < width; x++)
        {
            int pointX = (int)(BORDER_WIDTH + (x + 0.5) * FIELD_SIZE_WITH_BORDER);
            g.drawString(String.valueOf(x + 1), pointX, (int)(BORDER_WIDTH * 0.75));
        }

        int startChar = ((int)'a');

        for (int y = 0; y < height; y++)
        {
            int pointY = (int)(BORDER_WIDTH + (y + 0.6) * FIELD_SIZE_WITH_BORDER);
            g.drawString(String.valueOf((char)(startChar + y)), (int)(BORDER_WIDTH * 0.75), pointY);
        }

        g.dispose();
    }
}
