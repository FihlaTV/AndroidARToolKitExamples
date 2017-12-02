package com.hacaller.arsimplenativecars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.artoolkit.ar.base.ARActivity;
import org.artoolkit.ar.base.rendering.ARRenderer;

public class MainActivity extends ARActivity {

    private SimpleNativeRenderer simpleNativeRenderer = new SimpleNativeRenderer();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onStop() {
        SimpleNativeRenderer.demoShutdown();

        super.onStop();
    }

    @Override
    protected ARRenderer supplyRenderer() {
        return simpleNativeRenderer;
    }

    @Override
    protected FrameLayout supplyFrameLayout() {
        return (FrameLayout) this.findViewById(R.id.mainLayout);

    }


}
