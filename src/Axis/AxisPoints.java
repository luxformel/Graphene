/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Axis;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class AxisPoints {
    
    private ArrayList<AxisPoint> alPoints = new ArrayList<>();

    public boolean isEmpty() {
        return alPoints.isEmpty();
    }

    public void add(AxisPoint e) {
         alPoints.add(e);
    }

    public void clear() {
        alPoints.clear();
    }
    
    public void draw(Graphics g){
        if (!alPoints.isEmpty()) {
            for (int i = 0; i < alPoints.size(); i++) {
                alPoints.get(i).draw(g); 
            }
        }
    }
     
}
