/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import java.awt.Point;

/**
 *
 * @author luxformel
 */
public class TranslateCoordinates {

    public static Point translateCoordinatesFromFunctionToPanel(Point point, int width){
       return new Point(point.x + width/2, -point.y);
    }
}
