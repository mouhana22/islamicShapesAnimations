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
public class SecondAnimation {
    private  Clock clock = Clock.systemDefaultZone();
    private long milliSeconds=clock.millis();
    int counterOfFrames = 0;
    private float squareRotateAngle = 2f;
    
    private float translateLimit = 0;
    private long stopDuration = 0;
    private boolean translateFlag = true;
    
    private float scaleFrame = 1;
    private boolean scaleFlage = true;
    
    private float stopAngle = 2f;
    
    long after =clock.millis();
    private boolean timeOfAnimationFlage = true;
    
    public SecondAnimation() {
    }

    
    
    public void squaresRotate(){
        if(counterOfFrames > 130 && counterOfFrames < 382){
            squareRotateAngle *= 1.003f;
        }
        else if(counterOfFrames >= 382 && counterOfFrames <= 552){
           squareRotateAngle += 2f;
       }
        else if (counterOfFrames > 552) {
            stopAngle /= 1.003f;
            squareRotateAngle += stopAngle;
        }
        glRotatef(-squareRotateAngle,0,0,1f);
        
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
        }else if (translateLimit >= 0.31f*0.75){
            
            translateFlag = false;
        }
        if (translateFlag) {
            translateLimit += 0.0002f;
        }
        else{
            if (counterOfFrames > 630) {
                translateLimit -= 0.0002f;
            }else{
                squaresRotate();
            }
        }
        
        if (translateLimit < 0 ) {
            if (timeOfAnimationFlage) {
                after = clock.millis();
                timeOfAnimationFlage = false;
            }
            System.out.println("-------------- Animation End --------------");
            stopAnimation();
            counterOfFrames = 0;
            squareRotateAngle= 2f;
            stopAngle = 2f;
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
