
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
 * @author Muhammed
 */
public class ThirdAnimation {

    private Clock clock = Clock.systemDefaultZone();
    private long milliSeconds = clock.millis();
    private float rotateFactor = 0;
    int frames = 0;
    private long stopDuration = 0;
    float rotateInceasement = 0.1384615f;
    long after =clock.millis();
    private boolean timeOfAnimationFlage = true;
    
    public ThirdAnimation() {
    }

    public void squaresRotate(float direction) { //direction must be -1(left Direction(Anti-Clockwise)) OR 1(Right Direction(Clockwise))
        //rotateFactor += rotateInceasement;
        glRotated(direction * rotateFactor, 0, 0, 0.01f);

    }

    public void ScaleDownUp() {
        //rotateFactor += rotateInceasement;
        glRotatef(-rotateFactor, 0, 0, 0);

    }

    public void RotateAroundCenter(float direction, float x, float y) { //direction must be -1(left Direction(Anti-Clockwise)) OR 1(Right Direction(Clockwise))

        if (frames > 650) {
            if (timeOfAnimationFlage) {
                after = clock.millis();
                timeOfAnimationFlage = false;
            }
            stopAnimation();
            rotateFactor = 0;

            frames = 0;
        }

        rotateFactor += rotateInceasement;
        if (frames >= 649) {
            rotateFactor = 360;
        }
        glTranslatef(x, y, 0);
        glRotatef(direction * rotateFactor, 0, 0, 0.1f);
        glTranslatef(-x, -y, 0);
    }

    public void stopAnimation() {
        milliSeconds = clock.millis();
        stopDuration = milliSeconds;
        stopDuration += 3000;
        while (stopDuration >= milliSeconds) {
            milliSeconds = clock.millis();
        }
    }

}
