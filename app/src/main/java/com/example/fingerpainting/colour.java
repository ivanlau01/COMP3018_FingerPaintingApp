package com.example.fingerpainting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class colour extends AppCompatActivity {

    //Initializing variable
    int color;
    public TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour);
        //Create a textView to show the selection of colours after clicking the button by the user
        textView3 = (TextView) findViewById(R.id.textView3);
    }
    //All Colours are referenced from:"https://convertingcolors.com/"
    @SuppressLint("SetTextI18n")
    public void onButtonRed (View v){
        //Calling out the colour of red by using the android graphics colour code
       color = 0xFFFF0000;
       textView3.setText("Red colour is selected！");
       Log.d("Comp3018","Red Colour Button Clicked");
    }
    @SuppressLint("SetTextI18n")
    public void onButtonGreen (View v){
        //Calling out the colour of green by using the android graphics colour code
        color = 0xFF3CB043;
        textView3.setText("Green colour is selected！");
        Log.d("Comp3018","Green Colour Button Clicked");
    }
    @SuppressLint("SetTextI18n")
    public void onButtonBlack (View v){
        //Calling out the colour of black by using the android graphics colour code
        color = 0xFF000000;
        textView3.setText("Black colour is selected！");
        Log.d("Comp3018","Black Colour Button Clicked");
    }
    @SuppressLint("SetTextI18n")
    public void onButtonYellow (View v){
        //Calling out the colour of yellow by using the android graphics colour code
        color = 0xFFFFFF00;
        textView3.setText("Yellow colour is selected！");
        Log.d("Comp3018","Yellow Colour Button Clicked");
    }
    @SuppressLint("SetTextI18n")
    public void onButtonViolet (View v){
        //Calling out the colour of violet by using the android graphics colour code
        color = 0xFFEE82EE;
        textView3.setText("Violet colour is selected！");
        Log.d("Comp3018","Violet Colour Button Clicked");
    }
    @SuppressLint("SetTextI18n")
    public void onButtonPink (View v){
        //Calling out the colour of pink by using the android graphics colour code
        color = 0xFFFFC0CB;
        textView3.setText("Pink colour is selected！");
        Log.d("Comp3018","Pink Colour Button Clicked");
    }
    @SuppressLint("SetTextI18n")
    public void onButtonBlue (View v){
        //Calling out the colour of blue by using the android graphics colour code
        color = 0xFF0000FF;
        textView3.setText("Blue colour is selected！");
        Log.d("Comp3018","Blue Colour Button Clicked");
    }

    //Referenced from Lab 3- Multiple Activities, Threads
    public void onButtonSave(View v){
        //The selected colour will be saved and return to the main page by initializing intent
        Intent intent = new Intent();
        intent.putExtra("color",color);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    }


