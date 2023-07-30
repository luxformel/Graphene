/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author luxformel
 */
public class Axis {
    
    private static int numberOfDivisingLinesX = 18;
    private static int numberOfDivisingLinesY = 22;
    private static int startX = -9, startY = -6, endX = 9, endY = 16;
    private static int distanceBetweenLinesX, distanceBetweenLinesY;
    private static String typOfAxis = "Normal";
    private static boolean displayNumbers = true;
    
     public static void setTypOfAxis(String typOfAxis) {
        Axis.typOfAxis = typOfAxis;
    }

    public static void setStartX(int startX) {
        Axis.startX = startX;
    }

    public static void setEndX(int endX) {
        Axis.endX = endX;
    }

    public static void setStartY(int startY) {
        Axis.startY = startY;
    }

    public static void setEndY(int endY) {
        Axis.endY = endY;
    }
    
    public static void setDisplayNumbers(boolean bool) {
        Axis.displayNumbers = bool;
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

    public static int getStartX() {
        return startX;
    }

    public static int getEndX() {
        return endX;
    }

    public static int getStartY() {
        return startY;
    }

    public static int getEndY() {
        return endY;
    }
    public static String getTypOfAxis() {
        return typOfAxis;
    }
    
    public static boolean getDisplayNumbers() {
        return displayNumbers;
    }
    
    
    public static void calculateXDistance(){
        int lenght = Math.abs(startX) + Math.abs(endX);
        setNumberOfDivisingLinesX(lenght);
    }
    
    public static void calculateYDistance(){
        int lenght = Math.abs(startY) + Math.abs(endY);
        setNumberOfDivisingLinesY(lenght);
    }
    
       public static void drawAxis(int width, int height, Graphics g){
           
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(3));
            g2D.setColor(Color.BLACK);

            //draws the x axis
            g2D.setColor(new Color(100,100,100));
            
            Axis.setDistanceBetweenLinesY((int)height / Axis.numberOfDivisingLinesY);
            
            int heightXAxis = Math.abs(endY) * distanceBetweenLinesY;
            
            g2D.drawLine(0, heightXAxis, width - 5, heightXAxis);
            // arrow x 
            int[] xPointsX = {width, width - 10, width - 10};
            int[] yPointsX = {heightXAxis, heightXAxis - 5, heightXAxis + 5};
            g2D.fillPolygon(xPointsX, yPointsX, 3);
            
            
            //draws the y axis
            
            Axis.setDistanceBetweenLinesX((int)width / Axis.numberOfDivisingLinesX);
            
            int heightYAxis = Math.abs(startX) * distanceBetweenLinesX;
            
            g2D.drawLine(heightYAxis, 5, heightYAxis, height);
            // arrow y 
            int[] xPointsY = {heightYAxis, heightYAxis - 5, heightYAxis + 5};
            int[] yPointsY = {0, 10, 10};
            g2D.fillPolygon(xPointsY, yPointsY, 3);
        }
       
       public static void drawAxisNormalDown(int width, int height, Graphics g){
           
            Graphics2D g2D = (Graphics2D) g;

            g2D.setStroke(new BasicStroke(3));
            g2D.setColor(Color.BLACK);

            //draws the x axis
            g2D.setColor(new Color(100,100,100));
            
            Axis.setDistanceBetweenLinesY((int)height / Axis.numberOfDivisingLinesY);
            
            int heightXAxis = Math.abs(endY) * distanceBetweenLinesY;
            
            g2D.drawLine(0, heightXAxis, width - 5, heightXAxis);
            // arrow x 
            int[] xPointsX = {width, width - 10, width - 10};
            int[] yPointsX = {heightXAxis, heightXAxis - 5, heightXAxis + 5};
            g2D.fillPolygon(xPointsX, yPointsX, 3);
            
            
            //draws the y axis
            
            Axis.setDistanceBetweenLinesX((int)width / Axis.numberOfDivisingLinesX);
            
            int heightYAxis = Math.abs(startX) * distanceBetweenLinesX;
            
            g2D.drawLine(heightYAxis, 0, heightYAxis, height - 5);
            // arrow y 
            int[] xPointsY = {heightYAxis, heightYAxis - 5, heightYAxis + 5};
            int[] yPointsY = {height, height - 10, height - 10};
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
            
            g2D.setColor(new Color(200,200,200));
            
            int xCounter = startX;
            
            for (int i = 1; i <= numberOfDivisingLinesX; i++) {
                
                
                int x = width/numberOfDivisingLinesX;
                
                if (numberOfDivisingLinesX + startX == endX && displayNumbers) {
                    xCounter++;
                    g2D.setColor(Color.BLACK);
                    g2D.drawString(String.valueOf(xCounter), x * i + 5,  Math.abs(endY) * distanceBetweenLinesY + 15);
                    g2D.setColor(new Color(200,200,200));
                }
                
                g2D.drawLine(x * i, 0, x * i, height);
            }
            
            int yCounter = endY + 1;
            
            for (int i = 0; i < numberOfDivisingLinesY; i++) {  
                
                int y = height/numberOfDivisingLinesY;
                
                if (numberOfDivisingLinesY + startY == endY && displayNumbers) {
                    yCounter--;
                    g2D.setColor(Color.BLACK);
                    g2D.drawString(String.valueOf(yCounter), Math.abs(endX) * distanceBetweenLinesX + 5, y * i - 5);
                    g2D.setColor(new Color(200,200,200));
                }
                
                g2D.drawLine(0, y * i, width,y * i);
                
                
            }
          
        }
}
