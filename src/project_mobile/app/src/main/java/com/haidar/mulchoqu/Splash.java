package com.haidar.mulchoqu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Splash extends AppCompatActivity {

    private TextView title_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        title_splash = findViewById(R.id.title_splash);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.bellania);
        title_splash.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        title_splash.setAnimation(anim);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Splash.this, MainActivity.class);

                startActivity(intent);
            }
        }).start();
    }
}