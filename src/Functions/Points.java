/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Axis.Axis;
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
    private static  ArrayList<Point> alPoints = new ArrayList<>();

    public static int size() {
        return alPoints.size();
    }

    public static boolean isEmpty() {
        return alPoints.isEmpty();
    }

    public static Point get(int index) {
        return alPoints.get(index);
    }

    public static boolean add(Point e) {
        return alPoints.add(e);
    }

    public static void clear() {
        alPoints.clear();
    }
    
    public static void drawLines(Graphics g){
        for (int i = 1; i < alPoints.size(); i++) {
            
            Point position1 = alPoints.get(i - 1);
            position1 = TranslateCoordinates.translateCoordinatesFromFunctionToPanel(position1, 600);
            
            Point position2 = alPoints.get(i);
            //position2.x += 500;
            //position2.y += 500;
            
            Lines.add(new Line(position1, position2));
        }
        Lines.draw(g);
    }
}
