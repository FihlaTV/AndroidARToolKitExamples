package com.hacaller.ardistanceopengles20.shader;

import org.artoolkit.ar.base.rendering.gles20.BaseFragmentShader;

/**
 * Created by Herbert Caller on 30/11/2017.
 */
/**
 * Created by Thorsten Bux on 26.01.2016.
 * <p/>
 * FragmentShader class that extends the {@link BaseFragmentShader} class.
 * Here you define your fragment shader and what it does with the given color.
 * In that case it just applies it to the geometry and prints it on the screen.
 */
public class MarkerDistanceFragmentShader extends BaseFragmentShader {

    public static String colorVectorString = "a_Color";

    /**
     * We get the color to apply to the rendered geometry from the vertex shader.
     * We don't do anything with it, just simply pass it to the rendering pipe.
     * Therefor OpenGL 2.0 uses the gl_FragColor variable
     */
    private String fragmentShader =
            "precision lowp float;" +
                    "uniform vec4 " + colorVectorString + "; \n"     // This is the color from the vertex shader interpolated across the
                    // triangle per fragment.
                    + "void main()                    \n"     // The entry point for our fragment shader.
                    + "{                              \n"
                    + "   gl_FragColor = " + colorVectorString + "; \n"     // Pass the color directly through the pipeline.
                    + "}                              \n";

    public MarkerDistanceFragmentShader() {
        super();
        setShaderSource(fragmentShader);
    }

    /**
     * This method gets called by the {@link org.artoolkit.ar.base.rendering.gles20.BaseShaderProgram}
     * during initializing the shaders.
     * You can use it to pass in your own shader program as shown here. If you do not pass your own
     * shader program the one from {@link BaseFragmentShader} is used.
     *
     * @return The handle of the fragment shader
     */
    @Override
    public int configureShader() {
        return super.configureShader();
    }

}
