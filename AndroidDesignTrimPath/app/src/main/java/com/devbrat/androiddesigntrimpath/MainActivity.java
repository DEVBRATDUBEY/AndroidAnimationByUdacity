package com.devbrat.androiddesigntrimpath;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimatedVectorDrawable avd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_view);
        avd = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_android_design);
        imageView.setImageDrawable(avd);
    }

    public void click(View view) {
        avd.start();
    }
}