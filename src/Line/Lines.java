/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Line;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class Lines {
    private ArrayList<Line> alLines = new ArrayList<>();

    public boolean isEmpty() {
        return alLines.isEmpty();
    }

    public void add(Line e) {
        alLines.add(e);
    }

    public Line remove(int index) {
        return alLines.remove(index);
    }

    public void clear() {
        alLines.clear();
    }

    public int size() {
        return alLines.size();
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < alLines.size(); i++) {
             alLines.get(i).draw(g);
        }
    }
}
