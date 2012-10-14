package com.example.order15;

import com.example.order15.R;
import com.example.order15.ColorBall;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Canvas;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Order15MainActivity extends Activity {
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawImageView(this));
        
//        setContentView(R.layout.activity_order15_main);
/*        ImageView view = (ImageView)findViewById(R.id.imageView1);
        DrawImageView draw = new DrawImageView(this);
        draw.setLayoutParams(view.getLayoutParams());
        view.setVisibility(view.GONE);
        draw.setVisibility(view.VISIBLE);
        */
        
        
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_order15_main, menu);
        return true;
    }
  }
