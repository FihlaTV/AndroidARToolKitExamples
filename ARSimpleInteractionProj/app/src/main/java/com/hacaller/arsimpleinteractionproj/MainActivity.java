package com.hacaller.arsimpleinteractionproj;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import org.artoolkit.ar.base.ARActivity;
import org.artoolkit.ar.base.rendering.ARRenderer;

public class MainActivity extends ARActivity {

    /**
     * A custom renderer is used to produce a new visual experience.
     */
    private SimpleInteractiveRenderer simpleRenderer = new SimpleInteractiveRenderer();

    /**
     * The FrameLayout where the AR view is displayed.
     */
    private FrameLayout mainLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (FrameLayout) this.findViewById(R.id.mainLayout);

        // When the screen is tapped, inform the renderer and vibrate the phone
        mainLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                simpleRenderer.click();

                Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(100);

            }

        });
    }

    /**
     * By overriding {@link supplyRenderer}, the custom renderer will be used rather than
     * the default renderer which does nothing.
     *
     * @return The custom renderer to use.
     */
    @Override
    protected ARRenderer supplyRenderer() {
        return simpleRenderer;
    }

    /**
     * By overriding {@link supplyFrameLayout}, the layout within this Activity's UI will be
     * used.
     */
    @Override
    protected FrameLayout supplyFrameLayout() {
        return mainLayout;

    }

}
