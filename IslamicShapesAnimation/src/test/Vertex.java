/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Mouhana Almouhana
 */
public class Vertex {
    private float x,y;

    public Vertex() {
        this.x = 0;
        this.y = 0;
    }
    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Vertex{" + "x=" + x + ", y=" + y + '}';
    }
    
}
