package com.hacaller.arsimpleinteractionproj;

import org.artoolkit.ar.base.ARToolKit;
import org.artoolkit.ar.base.rendering.ARRenderer;
import org.artoolkit.ar.base.rendering.Cube;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Herbert Caller on 28/11/2017.
 */

/**
 * A simple Renderer that adds a marker and draws a spinning cube on it. The spinning is toggled
 * in the {@link #click} method, which is called from the activity when the user taps the screen.
 */
public class SimpleInteractiveRenderer extends ARRenderer {

    private int markerID = -1;

    private Cube cube = new Cube(40.0f, 0.0f, 0.0f, 20.0f);
    private float angle = 0.0f;
    private boolean spinning = false;

    /**
     * By overriding {@link #configureARScene}, the markers and other settings can be configured
     * after the native library is initialised, but prior to the rendering actually starting.
     */
    @Override
    public boolean configureARScene() {

        markerID = ARToolKit.getInstance().addMarker("single;Data/hiro.patt;80");
        if (markerID < 0) return false;

        return true;

    }

    public void click() {
        spinning = !spinning;
    }

    public void draw(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadMatrixf(ARToolKit.getInstance().getProjectionMatrix(), 0);

        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glFrontFace(GL10.GL_CW);

        gl.glMatrixMode(GL10.GL_MODELVIEW);

        if (ARToolKit.getInstance().queryMarkerVisible(markerID)) {

            gl.glLoadMatrixf(ARToolKit.getInstance().queryMarkerTransformation(markerID), 0);

            gl.glPushMatrix();
            gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
            cube.draw(gl);
            gl.glPopMatrix();

            if (spinning) angle += 5.0f;
        }


    }


}
