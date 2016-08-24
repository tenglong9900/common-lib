package com.arta.lib.demo.widget.circularprogressbutton;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.arta.lib.demo.R;
import com.arta.lib.widget.circularprogressbutton.CircularProgressButton;

public class CircularProgressButtonMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circularprogressbutton_main);

        final CircularProgressButton btnWithIcons1 = (CircularProgressButton) findViewById(R.id.btnWithIcons1);
        btnWithIcons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnWithIcons1.getProgress() == 0) {
                    simulateSuccessProgress(btnWithIcons1);
                } else {
                    btnWithIcons1.setProgress(0);
                }
            }
        });

        final CircularProgressButton btnWithIcons2 = (CircularProgressButton) findViewById(R.id.btnWithIcons2);
        btnWithIcons2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnWithIcons2.getProgress() == 0) {
                    simulateErrorProgress(btnWithIcons2);
                } else {
                    btnWithIcons2.setProgress(0);
                }
            }
        });

        final CircularProgressButton btnWithText1 = (CircularProgressButton) findViewById(R.id.btnWithText1);
        btnWithText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnWithText1.getProgress() == 0) {
                    simulateSuccessProgress(btnWithText1);
                } else {
                    btnWithText1.setProgress(0);
                }
            }
        });

        final CircularProgressButton btnWithText2= (CircularProgressButton) findViewById(R.id.btnWithText2);
        btnWithText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnWithText2.getProgress() == 0) {
                    simulateErrorProgress(btnWithText2);
                } else {
                    btnWithText2.setProgress(0);
                }
            }
        });
    }

    private void simulateSuccessProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 100);
        widthAnimation.setDuration(1500);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
            }
        });
        widthAnimation.start();
    }

    private void simulateErrorProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 99);
        widthAnimation.setDuration(1500);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
                if (value == 99) {
                    button.setProgress(-1);
                }
            }
        });
        widthAnimation.start();
    }
}
