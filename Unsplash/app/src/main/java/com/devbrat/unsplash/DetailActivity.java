package com.devbrat.unsplash;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends Activity {

    public static final String EXTRA_AUTHOR = "EXTRA_AUTHOR";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.photo) ImageView imageView;
    @BindView(R.id.author) TextView author;
    @BindInt(R.integer.detail_desc_slide_duration) int slideDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Picasso.with(this)
                .load(getIntent().getData())
                .placeholder(R.color.placeholder)
                .into(imageView);
        author.setText("—" + getIntent().getStringExtra(EXTRA_AUTHOR));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.BOTTOM);
            slide.addTarget(R.id.description);
            slide.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator
                    .linear_out_slow_in));
            slide.setDuration(slideDuration);
            getWindow().setEnterTransition(slide);
        }
    }
}
