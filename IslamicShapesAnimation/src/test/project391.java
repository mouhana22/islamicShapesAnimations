package test;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import java.time.Clock;
import java.util.Scanner;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 *
 * @author Mouhana Almouhana
 */
public class project391 {
    Clock clock = Clock.systemDefaultZone();
    long milliSeconds=clock.millis();
    
    final float size = 0.75f;
    
    Vertex v = new Vertex();
    Shape mainShape = new Shape();
    Shape frame = new Shape();
    Shape square = new Shape();
    
    FirstAnimation firstAnimation = new FirstAnimation();
    SecondAnimation secondAnimation = new SecondAnimation();
    ThirdAnimation thirdAnimation = new ThirdAnimation();
    FourthAnimation fourthAnimation = new FourthAnimation();
    
    long now =clock.millis();
    // The window handle
    private long window;

    public void run() {
        now =clock.millis();
        init();
        loop();
        switch (n) {
            case 1:
                long animationTime1 = firstAnimation.after - now;
                System.out.println("Animation time: " + (animationTime1 <= 0 ? "Sorry Animation did not finish" : (animationTime1 + " ms ")));
                break;
            case 2:
                long animationTime2 = secondAnimation.after - now;
                System.out.println("Animation time: " + (animationTime2 <= 0 ? "Sorry Animation did not finish" : (animationTime2 + " ms ")));
                break;
            case 3:
                long animationTime3 = thirdAnimation.after - now;
                System.out.println("Animation time: " + (animationTime3 <= 0 ? "Sorry Animation did not finish" : (animationTime3 + " ms ")));
                break;
            case 4:   
                long animationTime4 = fourthAnimation.after - now;
                System.out.println("Animation time: " + (animationTime4 <= 0 ? "Sorry Animation did not finish" : (animationTime4 + " ms ")));
                break;
            default:
                break;
        }
        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(1000, 1000, "PROJECT", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            }
        });

        // Get the thread stack and push a new frame
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
        
    }

    private void update() {
        
        switch (n) {
            case 1:
                
                break;
            case 2:
                break;
            case 3:
                
                break;
            default:
                break;
        }
        
        
        
    }
    
    private void render() {
       
        glLineWidth(5f);
        glColor3f(0f,0f,0f);
        
        /////////////////////////////  Vertex of the frame ////////////////////////////////
        float fr = 0.9f * size;
        v = new Vertex(fr, fr);
        frame.Vertices.put("v1", v);
        v = new Vertex(fr, -fr);
        frame.Vertices.put("v2", v);
        v = new Vertex(-fr, -fr);
        frame.Vertices.put("v3", v);
        v = new Vertex(-fr, fr);
        frame.Vertices.put("v4", v);
        v = new Vertex(fr, fr);
        frame.Vertices.put("v5", v);
        /////////////////////////////  Vertex of the frame ////////////////////////////////
        
        //////////////////////////// inner frame //////////////////////////////////////////
        glPushMatrix();
        switch (n) {
            case 1:
                firstAnimation.scaleTheFrame();
                glScalef(firstAnimation.getScaleFrame(),firstAnimation.getScaleFrame(),0);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                break;
        }
        frame.draw();
        glPopMatrix();
        //////////////////////////// inner frame //////////////////////////////////////////
        
        
        //////////////////////////// mid frame //////////////////////////////////////////
        glPushMatrix();
        glScalef(1.03f,1.03f,0);
        switch (n) {
            case 1:
                glScalef(firstAnimation.getScaleFrame(),firstAnimation.getScaleFrame(),0);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                break;
        }
        frame.draw();
        glPopMatrix();
        //////////////////////////// mid frame //////////////////////////////////////////
        
        
        //////////////////////////// outer frame //////////////////////////////////////////
        glPushMatrix();
        glScalef(1.06f,1.06f,0);
        switch (n) {
            case 1:
                glScalef(firstAnimation.getScaleFrame(),firstAnimation.getScaleFrame(),0);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                break;
        }
        frame.draw();
        glPopMatrix();
        //////////////////////////// outer frame //////////////////////////////////////////
        
        
//        
        
        /////////////////////////////  Vertex of main Shape ////////////////////////////////
        float ms = 0.4f * size;
        float head = 1.5f;
        float preHead = 3f;
        v = new Vertex(ms, ms);
        mainShape.Vertices.put("v1", v);
        v = new Vertex(ms, ms/preHead);
        mainShape.Vertices.put("v2", v);
        v = new Vertex(ms*head, 0);
        mainShape.Vertices.put("v3", v);
        v = new Vertex(ms, -ms/preHead);
        mainShape.Vertices.put("v4", v);
        v = new Vertex(ms, -ms);
        mainShape.Vertices.put("v5", v);
        
        v = new Vertex(ms/preHead, -ms);
        mainShape.Vertices.put("v6", v);
        v = new Vertex(0, -ms*head);
        mainShape.Vertices.put("v7", v);
        v = new Vertex(-ms/preHead, -ms);
        mainShape.Vertices.put("v8", v);
        v = new Vertex(-ms, -ms);
        mainShape.Vertices.put("v9", v);
        
        
        
        v = new Vertex(-ms, -ms/preHead);
        mainShape.Vertices.put("v10", v);
        v = new Vertex(-ms*head, 0);
        mainShape.Vertices.put("v11", v);
        v = new Vertex(-ms, ms/preHead);
        mainShape.Vertices.put("v12", v);
        v = new Vertex(-ms, ms);
        mainShape.Vertices.put("v13", v);
        
        v = new Vertex(-ms/preHead, ms);
        mainShape.Vertices.put("v14", v);
        v = new Vertex(0, ms*head);
        mainShape.Vertices.put("v15", v);
        v = new Vertex(ms/preHead, ms);
        mainShape.Vertices.put("v16", v);
        v = new Vertex(ms, ms);
        mainShape.Vertices.put("v17", v);
         /////////////////////////////  Vertex of main Shape ////////////////////////////////
        
         
         //////////////////////////// draw and animations for main shape ////////////////////
        glPushMatrix();
        
        switch (n) {
            case 1:
                break;
            case 2:
                secondAnimation.squaresTranslate();
                break;
            case 3:
                thirdAnimation.squaresRotate(1);
                thirdAnimation.ScaleDownUp();
                break;
            case 4:
                fourthAnimation.getanimation();
                break;
            default:
                break;
        }
        mainShape.draw();
        glPopMatrix();
        //////////////////////////// draw and animations for main shape ////////////////////
        
       
        
        /////////////////////////////  Vertex of square ////////////////////////////////
        float sqSize = 0.25f *size;
        v = new Vertex(sqSize, sqSize);
        square.Vertices.put("v1", v);
        v = new Vertex(sqSize, -sqSize);
        square.Vertices.put("v2", v);
        v = new Vertex(-sqSize, -sqSize);
        square.Vertices.put("v3", v);
        v = new Vertex(-sqSize, sqSize);
        square.Vertices.put("v4", v);
        v = new Vertex(sqSize, sqSize);
        square.Vertices.put("v5", v);
        /////////////////////////////  Vertex of square ////////////////////////////////
        
        ///////////////////////////////////////////////////   square 1  ////////////////////////////////////////////////////////
        glPushMatrix();
        glMatrixMode(5888);
        glLoadIdentity();
        glTranslatef(0.35f*size, 0.35f*size, 0);
        
        switch (n) {
            case 1:
                firstAnimation.squaresTranslate();
                glTranslatef(-firstAnimation.getTranslateLimit(), -firstAnimation.getTranslateLimit(), 0);
                
                break;
            case 2:
                if (secondAnimation.counterOfFrames == 1) {
                    printMatrix(2982);
                }
                
                square.draw();
                glTranslatef(-0.35f*size, -0.35f*size, 0);
                secondAnimation.squaresTranslate();
                if (secondAnimation.counterOfFrames == 450) {
                    printMatrix(2982);
                }
                glTranslatef(0.35f*size, 0.35f*size, 0);
                glTranslatef(-secondAnimation.getTranslateLimit(), -secondAnimation.getTranslateLimit(), 0);
                square.draw();
                
                if (secondAnimation.counterOfFrames == 130 || secondAnimation.counterOfFrames == 631) {
                    printMatrix(2982);
                }
                
                glTranslatef(secondAnimation.getTranslateLimit()/2, secondAnimation.getTranslateLimit()/2, 0);
                
                if (secondAnimation.counterOfFrames == 760) {
                    printMatrix(2982);
                }
                break;
            case 3:
                thirdAnimation.squaresRotate(1);
                break;
            case 4:   
                fourthAnimation.getanimation();
                glTranslatef(-fourthAnimation.getLimit(), -fourthAnimation.getLimit(), 0);
                break;
            default:
                break;
        }
        
        
        square.draw();
        glPopMatrix();
        ///////////////////////////////////////////////////   square 1  ////////////////////////////////////////////////////////
        
        
        
        
        ///////////////////////////////////////////////////   square 2  ////////////////////////////////////////////////////////
        glPushMatrix();
        glTranslatef(-0.35f*size, 0.35f*size, 0);
        switch (n) {
            case 1:
                firstAnimation.squaresTranslate();
                glTranslatef(firstAnimation.getTranslateLimit(), -firstAnimation.getTranslateLimit(), 0);
                break;
            case 2:
                square.draw();
                glTranslatef(0.35f*size, -0.35f*size, 0);
                secondAnimation.squaresTranslate();
                glTranslatef(-0.35f*size, 0.35f*size, 0);
                
                glTranslatef(secondAnimation.getTranslateLimit(), -secondAnimation.getTranslateLimit(), 0);
                square.draw();
                glTranslatef(-secondAnimation.getTranslateLimit()/2, secondAnimation.getTranslateLimit()/2, 0);
                break;
            case 3:
                thirdAnimation.squaresRotate(1);
                break;
            case 4:
                fourthAnimation.getanimation();
                glTranslatef(fourthAnimation.getLimit(), -fourthAnimation.getLimit(), 0);
                break;
            default:
                break;
        }
        square.draw();
        glPopMatrix();
        ///////////////////////////////////////////////////   square 2  ////////////////////////////////////////////////////////
        
        
        
        ///////////////////////////////////////////////////   square 3  ////////////////////////////////////////////////////////
        glPushMatrix();
        glTranslatef(-0.35f*size, -0.35f*size, 0);
        switch (n) {
            case 1:
                firstAnimation.squaresTranslate();
                glTranslatef(firstAnimation.getTranslateLimit(), firstAnimation.getTranslateLimit(), 0);
                break;
            case 2:
                square.draw();
                glTranslatef(0.35f*size, 0.35f*size, 0);
                secondAnimation.squaresTranslate();
                glTranslatef(-0.35f*size, -0.35f*size, 0);
                
                glTranslatef(secondAnimation.getTranslateLimit(), secondAnimation.getTranslateLimit(), 0);
                square.draw();
                glTranslatef(-secondAnimation.getTranslateLimit()/2, -secondAnimation.getTranslateLimit()/2, 0);
                break;
            case 3:
                thirdAnimation.squaresRotate(1);
                break;
            case 4:       
                fourthAnimation.getanimation();
                glTranslatef(fourthAnimation.getLimit(), fourthAnimation.getLimit(), 0);
                break;
            default:
                break;
        }
        square.draw();
        glPopMatrix();
        ///////////////////////////////////////////////////   square 3  ////////////////////////////////////////////////////////
        
        
        ///////////////////////////////////////////////////   square 4  ////////////////////////////////////////////////////////
        glPushMatrix();
        glTranslatef(0.35f*size, -0.35f*size, 0);
        switch (n) {
            case 1:
                firstAnimation.squaresTranslate();
                glTranslatef(-firstAnimation.getTranslateLimit(), firstAnimation.getTranslateLimit(), 0);
                break;
            case 2:
                square.draw();
                glTranslatef(-0.35f*size, 0.35f*size, 0);
                secondAnimation.squaresTranslate();
                glTranslatef(0.35f*size, -0.35f*size, 0);
               
                glTranslatef(-secondAnimation.getTranslateLimit(), secondAnimation.getTranslateLimit(), 0);
                square.draw();
                glTranslatef(secondAnimation.getTranslateLimit()/2, -secondAnimation.getTranslateLimit()/2, 0);
                break;
            case 3:
                thirdAnimation.squaresRotate(1);
                break;
            case 4:
                fourthAnimation.getanimation();
                glTranslatef(-fourthAnimation.getLimit(), fourthAnimation.getLimit(), 0);
                break;
            default:
                break;
        }
        square.draw();
        glPopMatrix();
        ///////////////////////////////////////////////////   square 4  ////////////////////////////////////////////////////////
        
        
        ///////////////////////////////////////////////////   square 1 R ////////////////////////////////////////////////////////
        glPushMatrix();
        glTranslatef(0, 0.5f*size, 0);
        glRotatef(45f,0,0,0.1f);
        switch (n) {
            case 1:
                if (firstAnimation.counterOfFrames == 1) {
                    printMatrix(2982);
                }
                
                firstAnimation.squaresTranslate();
                glTranslatef(-firstAnimation.getTranslateLimit(), -firstAnimation.getTranslateLimit(), 0);
                
                if (firstAnimation.counterOfFrames == 327 || firstAnimation.counterOfFrames == 656) {
                    printMatrix(2982);
                }
                break;
            case 2:
                square.draw();
                glRotatef(-45f,0,0,0.1f);
                glTranslatef(0, -0.5f*size, 0);
                secondAnimation.squaresTranslate();
                glTranslatef(0, 0.5f*size, 0);
                glRotatef(45f,0,0,0.1f);
                
                glTranslatef(-secondAnimation.getTranslateLimit(), -secondAnimation.getTranslateLimit(), 0);
                square.draw();
                glTranslatef(secondAnimation.getTranslateLimit()/2, secondAnimation.getTranslateLimit()/2, 0);
                break;
            case 3:
                thirdAnimation.RotateAroundCenter(1.0f, -(0.5f * size), -(0.5f * size));
            	thirdAnimation.squaresRotate(1);
                break;
            case 4:
                fourthAnimation.getanimation();
                break;
            default:
                break;
        }
        square.draw();
        glPopMatrix();
         ///////////////////////////////////////////////////   square 1 R ////////////////////////////////////////////////////////
        
        
        ///////////////////////////////////////////////////   square 2 R ////////////////////////////////////////////////////////
        glPushMatrix();
        glTranslatef(0.5f*size, 0, 0);
        glRotatef(45f,0,0,0.1f);
        switch (n) {
            case 1:
                firstAnimation.squaresTranslate();
                glTranslatef(-firstAnimation.getTranslateLimit(), firstAnimation.getTranslateLimit(), 0);
                break;
            case 2:
                square.draw();
                glRotatef(-45f,0,0,0.1f);
                glTranslatef(-0.5f*size, 0, 0);
                secondAnimation.squaresTranslate();
                glTranslatef(0.5f*size, 0, 0);
                glRotatef(45f,0,0,0.1f);
                
                glTranslatef(-secondAnimation.getTranslateLimit(), secondAnimation.getTranslateLimit(), 0);
                square.draw();
                glTranslatef(secondAnimation.getTranslateLimit()/2, -secondAnimation.getTranslateLimit()/2, 0);
                break;
            case 3:
                thirdAnimation.RotateAroundCenter(-1.0f, -(0.5f * size), (0.5f * size));
            	thirdAnimation.squaresRotate(-1);
                break;
            case 4:
                fourthAnimation.getanimation();
                break;
            default:
                break;
        }
        square.draw();
        glPopMatrix();
         ///////////////////////////////////////////////////   square 2 R ////////////////////////////////////////////////////////
         
         
          ///////////////////////////////////////////////////   square 3 R ////////////////////////////////////////////////////////
        glPushMatrix();
        glTranslatef(-0.5f*size, 0, 0);
        glRotatef(45f,0,0,0.1f);
        switch (n) {
            case 1:
                 firstAnimation.squaresTranslate();
                glTranslatef(firstAnimation.getTranslateLimit(), -firstAnimation.getTranslateLimit(), 0);
                break;
            case 2:
                square.draw();
                glRotatef(-45f,0,0,0.1f);
                glTranslatef(0.5f*size, 0, 0);
               secondAnimation.squaresTranslate();
               glTranslatef(-0.5f*size, 0, 0);
               glRotatef(45f,0,0,0.1f);
               
                glTranslatef(secondAnimation.getTranslateLimit(), -secondAnimation.getTranslateLimit(), 0);
                square.draw();
                glTranslatef(-secondAnimation.getTranslateLimit()/2, secondAnimation.getTranslateLimit()/2, 0);
                break;
            case 3:
                thirdAnimation.RotateAroundCenter(-1.0f, (0.5f * size),-(0.5f * size));
            	thirdAnimation.squaresRotate(-1);
                break;
            case 4:
                fourthAnimation.getanimation();
                break;
            default:
                break;
        }
        square.draw();
        glPopMatrix();
         ///////////////////////////////////////////////////   square 3 R ////////////////////////////////////////////////////////
         
         
           ///////////////////////////////////////////////////   square 4 R ////////////////////////////////////////////////////////
        glPushMatrix();
        glTranslatef(0, -0.5f*size, 0);
        glRotatef(45f,0,0,0.1f);
        switch (n) {
            case 1:
                firstAnimation.squaresTranslate();
                glTranslatef(firstAnimation.getTranslateLimit(), firstAnimation.getTranslateLimit(), 0);
                break;
            case 2:
                square.draw();
                glRotatef(-45f,0,0,0.1f);
                glTranslatef(0, 0.5f*size, 0);
                secondAnimation.squaresTranslate();
                glTranslatef(0, -0.5f*size, 0);
                glRotatef(45f,0,0,0.1f);
                glTranslatef(secondAnimation.getTranslateLimit(), secondAnimation.getTranslateLimit(), 0);
                square.draw();
                glTranslatef(-secondAnimation.getTranslateLimit()/2, -secondAnimation.getTranslateLimit()/2, 0);
                break;
            case 3:
                thirdAnimation.RotateAroundCenter(1.0f, (0.5f * size),(0.5f * size));
            	thirdAnimation.squaresRotate(1);
                break;
            case 4:
                fourthAnimation.getanimation();
                break;
            default:
                break;
        }
        square.draw();
        glPopMatrix();
         ///////////////////////////////////////////////////   square 4 R ////////////////////////////////////////////////////////
        
         
         
       
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while (!glfwWindowShouldClose(window)) {

            glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            
            firstAnimation.counterOfFrames++;
            secondAnimation.counterOfFrames++;
            thirdAnimation.frames++;
            update();
            render();
            
            glfwSwapBuffers(window); // swap the color buffers
            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
       
    }
    static int n;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Please choose a number: "
                + "\n0: No Animation"
                + "\n1: First Animation"
                + "\n2: Second Animation"
                + "\n3: Third Animation"
                + "\n4: Fourth Animation");
       
            n = input.nextInt();
        } while (!((n == 1) || (n == 2) || (n == 3) || (n == 4) || (n == 0)));
        
        
//        n=0;
            
        new project391().run();
        
    }
    
    public void printMatrix(int type){
        System.out.println("-----------------------------");
        System.err.println("-----------------------------");
        double [] mat = new double[16];
        
        glGetDoublev(type, mat);
        
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.format("%7.3f%c",mat[row+col*4],col == 3 ? '\n' : ' ');
            }
        }
        System.err.println("-----------------------------");
        System.out.println("-----------------------------");
    }
}
