/*
 * Mouhana Almouhana
 */
package test;

import java.time.Clock;
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
public class FirstAnimation {
    private  Clock clock = Clock.systemDefaultZone();
    private long milliSeconds=clock.millis();
    
    int counterOfFrames = 0;
    private float squareRotateAngle = 0;
    
    private float translateLimit = 0;
    private long stopDuration = 0;
    private boolean translateFlag = true;
    
    private float scaleFrame = 1;
    private boolean scaleFlage = true;
    
    long after =clock.millis();
    private boolean timeOfAnimationFlage = true;
    public FirstAnimation() {
    }
    
    public void squaresRotate(){
        squareRotateAngle -= 0.276f;
        glRotatef(squareRotateAngle,0,0,0.1f);
    }
    
    public void stopAnimation(){
        milliSeconds=clock.millis();
        stopDuration = milliSeconds;
        stopDuration += 3000;
            while(stopDuration >= milliSeconds){
                milliSeconds=clock.millis();
            }
        
    }
    
    public void squaresTranslate(){
        if (translateLimit <= 0) {
            translateFlag = true;
        }else if (translateLimit >= 0.35f*0.75){
            
            translateFlag = false;
        }
        if (translateFlag) {
            translateLimit += 0.0001f;
        }else{
            translateLimit -= 0.0001f;
        }
        
        if (translateLimit < 0 ) {
            if (timeOfAnimationFlage) {
                after = clock.millis();
                timeOfAnimationFlage = false;
            }
            System.out.println("-------------- Animation End --------------");
            stopAnimation();
            counterOfFrames = 0;
            squareRotateAngle= 0;
        }
        if (counterOfFrames < 652) {
            squaresRotate();
        }
        
    }
    
    public void scaleTheFrame(){
         if (scaleFrame <= 1) {
            scaleFlage = true;
        }else if (scaleFrame >= 1.328f){
            scaleFlage = false;
        }
        if (scaleFlage) {
            scaleFrame += 0.001f;
        }else{
            scaleFrame -= 0.001f;
        }
        
        
     }

    public Clock getClock() {
        return clock;
    }

    public long getMilliSeconds() {
        return milliSeconds;
    }

    public int getCounterOfFrames() {
        return counterOfFrames;
    }

    public float getSquareRotateAngle() {
        return squareRotateAngle;
    }

    public float getTranslateLimit() {
        return translateLimit;
    }

    public long getStopDuration() {
        return stopDuration;
    }

    public boolean isTranslateFlag() {
        return translateFlag;
    }

    public float getScaleFrame() {
        return scaleFrame;
    }

    public boolean isScaleFlage() {
        return scaleFlage;
    }
    
    
    
}
