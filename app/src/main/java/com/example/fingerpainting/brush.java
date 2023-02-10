package com.example.fingerpainting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class brush extends AppCompatActivity {

    //Initializing variable
    String brush;
    String brushWidth;
    public SeekBar seekBar;
    public TextView textView2;
    public TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush);

        //Assign textview and seekbar variable
        textView2 = (TextView) findViewById(R.id.textView2);
        textView4 = (TextView) findViewById(R.id.textView4);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //Referenced from: "https://www.youtube.com/watch?v=G03ZR0jKtVs"
            @SuppressLint("SetTextI18n")
            @Override
            //Keep track the changes of value made from the seekbar
            public void onProgressChanged(SeekBar seekBar, int width, boolean b) {
                textView2.setText("Brush Width: " + width);
                brushWidth = Integer.toString(width);
                seekBar.setMax(100);
            }

            @Override
            //To track the start point
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            //To track the stop point
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void onButtonRound(View v) {
        //Calling out the round brush in string
        brush = String.valueOf(Paint.Cap.ROUND);
        textView4.setText("Round brush is selected!");
        Log.d("Comp3018","Round Brush Clicked");
    }
    @SuppressLint("SetTextI18n")
    public void onButtonSquare(View v) {
        //Calling out the square brush in string
        brush = String.valueOf(Paint.Cap.SQUARE);
        textView4.setText("Square brush is selected!");
        Log.d("Comp3018","Square Brush Clicked");
    }

    //Referenced from Lab 3- Multiple Activities, Threads
    public void onButtonSave2(View v) {
        //The selected brush shape and width will be saved and return to the main page by initializing intent
        Intent intent = new Intent();
        intent.putExtra("brush", brush);
        intent.putExtra("brushWidth",brushWidth);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}