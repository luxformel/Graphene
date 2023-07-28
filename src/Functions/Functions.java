/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class Functions {
    private ArrayList<Function> alFunctions = new ArrayList<>();

    public int size() {
        return alFunctions.size();
    }

    public Object[] toArray() {
        return alFunctions.toArray();
    }

    public Function get(int index) {
        return alFunctions.get(index);
    }

    public void add(Function e) {
         alFunctions.add(e);
    }

    public void remove(int index) {
        alFunctions.remove(index);
    }

    public void clear() {
        alFunctions.clear();
    }

    public boolean isEmpty() {
        return alFunctions.isEmpty();
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < alFunctions.size(); i++) {
            alFunctions.get(i).draw(g);
        }    
    }
    
}
