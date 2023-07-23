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
    private static ArrayList<Line> alLines = new ArrayList<>();

    public static boolean isEmpty() {
        return alLines.isEmpty();
    }

    public static void add(Line e) {
        alLines.add(e);
    }

    public static Line remove(int index) {
        return alLines.remove(index);
    }

    public static void clear() {
        alLines.clear();
    }

    public static int size() {
        return alLines.size();
    }
    
    public static void draw(Graphics g){
        for (int i = 0; i < alLines.size(); i++) {
             alLines.get(i).draw(g);
        }
    }
}
