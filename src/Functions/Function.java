/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import Axis.Axis;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


/**
 *
 * @author luxformel
 */
public class Function {
    private String func;
    private Points points = new Points();
    private Color color;

    public String getFunc() {
        return func;
    }


    public Function(String func){
        this.func = func;
        
        int newX = 0;
        int newY = 0;
        
        int startX = Axis.getStartX();
        int endX = Math.abs(Axis.getEndX()); 
        int endY = Math.abs(Axis.getEndY()); 
       
        int distBetwLinesX = Axis.getDistanceBetweenLinesX();
        int distBetwLinesY = Axis.getDistanceBetweenLinesY();
        
        for (double i = startX; i <= endX; i += 0.1) {
            double y = InterperateFunction.interperate(this.func, i);
            System.out.println("x: " + i + "; y: " + y);
            if (!Double.isNaN(y)) {
                newX = (int) ((i +  Math.abs(startX)) * distBetwLinesX);
                newY = (int) ((endY - y) * distBetwLinesY);
                System.out.println("x: " + newX + "; y: " + newY);
                points.add(new Point(newX, newY));
            }
        }
    }
    public void draw(Graphics g){
        points.drawPoints(g);
    } 
    
    @Override
    public String toString() {
        return "f(x) = " + func ;
    }

}
