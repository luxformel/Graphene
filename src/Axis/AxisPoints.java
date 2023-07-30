/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Axis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class AxisPoints {
    
    private static ArrayList<Point> alPoints = new ArrayList<>();

    public static boolean isEmpty() {
        return alPoints.isEmpty();
    }

    public static void add(Point e) {
         alPoints.add(e);
    }

    public static void clear() {
        alPoints.clear();
    }

    public int size() {
        return alPoints.size();
    }
    
    
    public static void draw(Graphics g){
        for (int i = 0; i < alPoints.size(); i++) {
            Point p = alPoints.get(i);
           // System.out.println("point at index " + i + " is;" + p.toString());
            g.setColor(Color.red);
            g.drawOval(p.x - 7, p.y - 7, 14, 14);
        }
    }
     
}