package com.hacaller.arnative;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Herbert Caller on 02/12/2017.
 */

public class Renderer implements GLSurfaceView.Renderer {

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        MainActivity.nativeSurfaceCreated();
    }

    public void onSurfaceChanged(GL10 unused, int w, int h) {
        MainActivity.nativeSurfaceChanged(w, h);
    }

    public void onDrawFrame(GL10 unused) {
        MainActivity.nativeDrawFrame();
    }
}
