/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public class Line {
    private Point position1, position2;

    public Line(Point position1, Point position2) {
        this.position1 = position1;
        this.position2 = position2;
    }

    public void setPosition1(Point position1) {
        this.position1 = position1;
    }

    public void setPosition2(Point position2) {
        this.position2 = position2;
    }
       
    public void draw(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(3));
        g2D.setColor(Color.BLACK);
        // Antialiasing
        //g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawLine(position1.x, position1.y, position2.x, position2.y);
    }
}   
