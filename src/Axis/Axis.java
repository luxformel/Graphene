/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author luxformel
 */
public class Axis {
    
    private static int numberOfDivisingLinesX = 1;
    private static int numberOfDivisingLinesY = 1;
    private static int fromX,toX,fromY,toY;
    private static int distanceBetweenLinesX, distanceBetweenLinesY;
    
    
    public static void setFromX(int fromX) {
        Axis.fromX = fromX;
    }

    public static void setToX(int toX) {
        Axis.toX = toX;
    }

    public static void setFromY(int fromY) {
        Axis.fromY = fromY;
    }

    public static void setToY(int toY) {
        Axis.toY = toY;
    }

    public static void setDistanceBetweenLinesX(int distanceBetweenLinesX) {
        Axis.distanceBetweenLinesX = distanceBetweenLinesX;
    }

    public static void setDistanceBetweenLinesY(int distanceBetweenLinesY) {
        Axis.distanceBetweenLinesY = distanceBetweenLinesY;
    }
    
    public static void setNumberOfDivisingLinesX(int numberOfDivisingLinesX) {
        Axis.numberOfDivisingLinesX = numberOfDivisingLinesX;
    }
    public static void setNumberOfDivisingLinesY(int numberOfDivisingLinesY) {
        Axis.numberOfDivisingLinesY = numberOfDivisingLinesY;
    }
    
    public static int getNumberOfDivisingLinesX() {
        return numberOfDivisingLinesX;
    }
    public static int getNumberOfDivisingLinesY() {
        return numberOfDivisingLinesY;
    }

    public static int getDistanceBetweenLinesX() {
        return distanceBetweenLinesX;
    }

    public static int getDistanceBetweenLinesY() {
        return distanceBetweenLinesY;
    }
    
    
    
    public static void calculateXDistance(){
        int lenght = Math.abs(fromX) + Math.abs(toX);
        setNumberOfDivisingLinesX(lenght);
    }
    
    public static void calculateYDistance(){
        int lenght = Math.abs(fromY) + Math.abs(toY);
        setNumberOfDivisingLinesY(lenght);
    }
    
       public static void drawAxis(int width, int height, Graphics g){
           
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(3));
            g2D.setColor(Color.BLACK);

            //draws the x axis
            g2D.setColor(new Color(100,100,100));
            
            Axis.setDistanceBetweenLinesY((int)height / Axis.numberOfDivisingLinesY);
            
            int heightXAxis = Math.abs(fromY) * distanceBetweenLinesY;
            
            g2D.drawLine(0, heightXAxis, width - 5, heightXAxis);
            // arrow x 
            int[] xPointsX = {width, width - 10, width - 10};
            int[] yPointsX = {heightXAxis, heightXAxis - 5, heightXAxis + 5};
            g2D.fillPolygon(xPointsX, yPointsX, 3);
            
            
            //draws the y axis
            
            Axis.setDistanceBetweenLinesX((int)width / Axis.numberOfDivisingLinesX);
            
            int heightYAxis = Math.abs(fromX) * distanceBetweenLinesX;
            
            g2D.drawLine(heightYAxis, 5, heightYAxis, height);
            // arrow y 
            int[] xPointsY = {heightYAxis, heightYAxis - 5, heightYAxis + 5};
            int[] yPointsY = {0, 10, 10};
            g2D.fillPolygon(xPointsY, yPointsY, 3);
        }
       public static void drawAxisDown(int width, int height, Graphics g){
           
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(3));
            g2D.setColor(Color.BLACK);

            //draws the x axis
            g2D.setColor(new Color(100,100,100));
            g2D.drawLine(0, 3, width - 5, 3);
            // arrow x 
            int[] xPointsX = {width, width - 10, width - 10};
            int[] yPointsX = {3, 3 - 5, 3 + 5};
            g2D.fillPolygon(xPointsX, yPointsX, 3);
            //draws the y axis
            g2D.drawLine(0, 5, 3, height - 5);
            // arrow y 
            int[] xPointsY = {3, 3 - 5, 3 + 5};
            int[] yPointsY = {height, height - 10,height - 10};
            g2D.fillPolygon(xPointsY, yPointsY, 3);
        }
       public static void drawAxisUp(int width, int height, Graphics g){
           
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(3));
            g2D.setColor(Color.BLACK);

            //draws the x axis
            g2D.setColor(new Color(100,100,100));
            g2D.drawLine(0, height - 3, width - 5, height - 3);
            // arrow x 
            int[] xPointsX = {width, width - 10, width - 10};
            int[] yPointsX = {height - 3, height - 8, height + 2};
            g2D.fillPolygon(xPointsX, yPointsX, 3);
            //draws the y axis
            g2D.drawLine(0, 5, 3, height - 5);
            // arrow y 
            int[] xPointsY = {0, 0 - 5, 0 + 5};
            int[] yPointsY = {0, 10, 10};
            g2D.fillPolygon(xPointsY, yPointsY, 3);
        }
        public static void drawBackgroundLines(int width, int height, Graphics g){
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(3));
            g2D.setColor(Color.BLACK);
            
            g2D.setColor(new Color(200,200,200));

            for (int i = 1; i <= numberOfDivisingLinesX; i++) {
                g2D.drawLine(width/numberOfDivisingLinesX * i, 0, width/numberOfDivisingLinesX * i, height);
            }
            for (int i = 0; i < numberOfDivisingLinesY; i++) {
                g2D.drawLine(0, height/numberOfDivisingLinesY * i, width, height/numberOfDivisingLinesY * i);  
            }
        
        }
}
