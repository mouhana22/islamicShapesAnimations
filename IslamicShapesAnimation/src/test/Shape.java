
package test;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import java.util.HashMap;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 *
 * @author Mouhana Almouhana
 */

public class Shape {
    HashMap<String,Vertex> Vertices = new HashMap<String,Vertex>();
    private  Vertex v = new Vertex();
    
    public Shape() {
    }
    
    
    
    public void draw(){
        glBegin(GL_LINE_STRIP);
        
        
            {
                for (int i = 1; i <= Vertices.size(); i++) {
                    v = Vertices.get("v"+i);
                    
                    glVertex3f(v.getX(), v.getY(), 0.0f);
                   
                }
                
            }
            glEnd();
    }
    
    
    

}
