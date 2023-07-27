/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Axis.Axis;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public class TranslateCoordinates {

    public static Point translateCoordinatesFromFunctionToPanel(Point point){
        int X = 0;
        int Y = 0;
        
        int pointx = point.x;
        int startX = Math.abs(Axis.getStartX());
        int distBetwLinesX =  Axis.getDistanceBetweenLinesX();
        
        int pointy = point.y;
        int endY = Math.abs(Axis.getEndY());
        int distBetwLinesY =  Axis.getDistanceBetweenLinesY();
        
        System.out.println("pointx " + pointx);
        System.out.println("startX " + startX);
        System.out.println("distBetwLinesX " + distBetwLinesX);
        
        System.out.println("pointy " + pointy);
        System.out.println("endY " + endY);
        System.out.println("distBetwLinesY " + distBetwLinesY);
        
        
        // detect quadrant
        if (pointx >= 0 && pointy >= 0) {
            // first quadrant
            X = (pointx + startX) * distBetwLinesX;
            Y = (endY - pointy) * distBetwLinesY;
            System.out.println("first quadrant");
        } else if (pointx <= 0 && pointy >= 0) {
            // second quadrant
            X = (startX - pointx) * distBetwLinesX;
            Y = (endY - pointy) * distBetwLinesY;
            System.out.println("second quadrant");
        }
        else if (pointx <= 0 && pointy <= 0) {
            // third quadrant
            X = (startX - pointx) * distBetwLinesX;
            Y = (endY + pointy) * distBetwLinesY;
            System.out.println("third quadrant");
        }
        else if (pointx >= 0 && pointy <= 0) {
            // fourth quadrant
            X = (pointx + startX) * distBetwLinesX;
            Y = (endY + pointy) * distBetwLinesY;
            System.out.println("fourth quadrant");
        }
        System.out.println("X: " + X  + "; Y: " + Y);
       return new Point(X,Y);
    }
}
