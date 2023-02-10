package com.example.fingerpainting;

import static java.lang.Integer.parseInt;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityLauncher;
    private FingerPainterView draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variable
        FingerPainterView myFingerPainterView = new FingerPainterView(this);
        myFingerPainterView.setId(R.id.view);
        //Assign draw variable which ensures the instance of FingerPainterView exists
        draw = (FingerPainterView) findViewById(R.id.view);
        //Allow the pictures to load in this app
        draw.load(getIntent().getData());

        //Initialise Launcher for activity to update the brush settings based on the user preferences
        activityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                //Referenced from Lab 3- Multiple Activities, Threads
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //Initializing the Result Data
                        Intent intent = result.getData();
                        assert intent != null;
                        //Obtain data for colour from colour activity
                        int currentColour = intent.getExtras().getInt("color");

                        //If the variable is not 0 (for Integer), the newest selection for colour will be updated to the current colour
                        if (!Objects.equals(currentColour, 0)) {
                            draw.setColour(currentColour);
                            Log.d("Comp3018", "Received Colour:" + (myFingerPainterView.getColour()));
                        }
                        //Obtain data for brush type and brush size from brush activity
                        String currentBrush = intent.getStringExtra("brush");
                        String currentBrushWidth = intent.getStringExtra("brushWidth");

                        //If the variable is not NULL (for String) or 0(for Integer), the newest selection for shape will be updated to the current shape
                        if (!Objects.equals(currentBrush, null)) {
                            draw.setBrush(Paint.Cap.valueOf(currentBrush));
                            Log.d("Comp3018", "Received Brush Shape:" + (myFingerPainterView.getBrush()));
                        }
                        //If the variable is not NULL (for String), the newest selection for the brush width will be updated to the current size
                        if (!Objects.equals(currentBrushWidth, null)) {
                            draw.setBrushWidth(parseInt(currentBrushWidth));
                            Log.d("Comp3018", "Received Brush Size:" + (myFingerPainterView.getBrushWidth()));
                        }
                    }
                });
    }

        //Referenced from Lab 3- Multiple Activities, Threads
        public void onButtonColour (View v){
            //Initializing an intent to proceed the page of colour selection by pressing this button
            Intent intent = new Intent(MainActivity.this, colour.class);
            activityLauncher.launch(intent);
        }
        //Referenced from Lab 3- Multiple Activities, Threads
        public void onButtonBrush (View v){
            //Initializing an intent to proceed the page of brush selection by pressing this button
            Intent intent = new Intent(MainActivity.this, brush.class);
            activityLauncher.launch(intent);
        }

        //Referenced from: "https://www.geeksforgeeks.org/how-to-implement-on-saved-instance-state-in-android/"
        @Override
        public void onSaveInstanceState(@NonNull Bundle storeState){
            //To retrieve per-instance state in the activity before being killed so that the state can be restored in onRestoreInstanceState
            storeState.putInt("colour two",draw.getColour());
            storeState.putString("brush two",String.valueOf(draw.getBrush()));
            storeState.putString("brushWidth two",String.valueOf(draw.getBrushWidth()));
            super.onSaveInstanceState(storeState);
        }
        @Override
        public void onRestoreInstanceState(Bundle storeState){
            //Recover the destroyed activity after recreating while rotating the screen
            int colour2 = storeState.getInt("colour two");
            String brush2 = storeState.getString("brush two");
            String brushWidth2 = storeState.getString("brushWidth two");

            if (!Objects.equals(colour2, 0)) {
                draw.setColour(colour2);
            }
            if (!Objects.equals(brush2, null)) {
                draw.setBrush(Paint.Cap.valueOf(brush2));
            }
            if (!Objects.equals(brushWidth2, null)) {
                draw.setBrushWidth(parseInt(brushWidth2));
            }
            super.onRestoreInstanceState(storeState);

    }

    }
