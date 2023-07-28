/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Line.Line;
import Line.Lines;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class Points {
    private  ArrayList<Point> alPoints = new ArrayList<>();
    private Lines lines = new Lines();

    public int size() {
        return alPoints.size();
    }

    public boolean isEmpty() {
        return alPoints.isEmpty();
    }

    public Point get(int index) {
        return alPoints.get(index);
    }

    public void add(Point e) {
         alPoints.add(e);
    }

    public void clear() {
        alPoints.clear();
    }
    
    public void drawPoints(Graphics g){
        for (int i = 1; i < alPoints.size(); i++) {     
            Point point = alPoints.get(i);
            //g.setColor(Color.red);   
            //g.drawOval(point.x - 7, point.y - 7, 14, 14);
        }
        addLines(g);
    }
    
     public void addLines(Graphics g){
        for (int i = 1; i < alPoints.size(); i++) {     
            Point position1 = alPoints.get(i - 1);
            Point position2 = alPoints.get(i);
            lines.add(new Line(position1, position2));
            System.out.println(i);
        }
       lines.draw(g);
    }
}
