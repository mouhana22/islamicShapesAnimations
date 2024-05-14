/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author 3baa3
 */
public class FourthAnimation {

    private int Animation_Count;
    private float limit;
    private float angel;
    private float size = 0.75f;
    private boolean condition = true;
    private Clock clock = Clock.systemDefaultZone();
    long milliSeconds = clock.millis();

    long after = clock.millis();
    private boolean timeOfAnimationFlage = true;

    public FourthAnimation() {
    }

    public void getanimation() {
        angel -= 0.164f;
        if (limit <= 0) {

            condition = true;
        } else if (limit >= 0.35f * size) {

            condition = false;
        }
        if (condition) {
            limit += 0.000239f;
        } else {
            limit -= 0.000239f;
        }
        if (limit < 0) {
            Animation_Count++;
            if (Animation_Count == 2) {
                if (timeOfAnimationFlage) {
                    after = clock.millis();
                    timeOfAnimationFlage = false;
                }
                stopAnimation();
                angel = 0;
                Animation_Count = 0;

            }

        }
        glRotatef(angel, angel, angel, 0);
    }

    public float getLimit() {
        return limit;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public void stopAnimation() {
        milliSeconds = clock.millis();
        long stopDuration = milliSeconds;
        stopDuration += 3000;
        while (stopDuration >= milliSeconds) {
            milliSeconds = clock.millis();
        }
    }
}
