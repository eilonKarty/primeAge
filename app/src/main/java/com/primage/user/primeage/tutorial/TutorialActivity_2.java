package com.primage.user.primeage.tutorial;


import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.WindowManager.LayoutParams;

import com.primage.user.primeage.Assistant;
import com.primage.user.primeage.Globals;
import com.primage.user.primeage.HomeActivity;
import com.primage.user.primeage.R;
import com.primage.user.primeage.HomeActivity.*;

public class TutorialActivity_2 extends Activity {


    public static long pressingDuration;
    public static int pressingCounter=0;

    Assistant assistant;


    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Seek bar object
    private SeekBar brightbar;
    //Window object, that will store a reference to the current window
    private Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_activity_2);

        //reset static variables
        pressingDuration=0;
        pressingCounter=0;




        //getting user preferences from previous session
        HomeActivity.userPreferences = getSharedPreferences(HomeActivity.USER_PREFERENCES, MODE_PRIVATE);
        //checking if this is the first run


        //set Listeners
        ImageButton button = (ImageButton) findViewById(R.id.pressureButton);
        button.setOnTouchListener(new View.OnTouchListener() {
            long startTime = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                long sessionPressingDuration;
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.pressure_button_pressed);
                    //start calculate your time here
                    startTime = System.currentTimeMillis();
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.pressure_button);
                    sessionPressingDuration = System.currentTimeMillis() - startTime;
                    Log.d("pressing duration:", String.valueOf(pressingDuration));
                    updatePressingDuration(sessionPressingDuration);
                }
                return true;
            }
        });

        ImageButton pushToContinueButton = (ImageButton) findViewById(R.id.pushToContinueButton);
        pushToContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Write to shared preference
                SharedPreferences userPreferences= getSharedPreferences(HomeActivity.USER_PREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor= userPreferences.edit();
                editor.putBoolean(HomeActivity.FIRST_RUN, false);
                boolean succeed=editor.commit();
                Log.i("Shared Pref commit:", String.valueOf(succeed));
                finish();

            }
        });

        /*
        Seek Bar setting section
        */


        /*
        //Get the content resolver
        cResolver = getContentResolver();

        //Get the current window
        window = getWindow();



        SeekBar BackLightControl = (SeekBar)findViewById(R.id.brightness_bar);

        BackLightControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                // TODO Auto-generated method stub
                float BackLightValue = (float) arg1 / 100;


                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = BackLightValue;
                getWindow().setAttributes(layoutParams);
                Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);


            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar arg0) {}
        });




      //  ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_SETTINGS}, 1);


       */





        //Get the content resolver
        cResolver = getContentResolver();

        //Get the current window
        window = getWindow();

        brightbar = (SeekBar) findViewById(R.id.brightness_bar);

        //Set the seekbar range between 0 and 255
        brightbar.setMax(255);
        //Set the seek bar progress to 1
        brightbar.setKeyProgressIncrement(1);

        try {
            //Get the current system brightness
            brightness = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            //Throw an error case it couldn't be retrieved
            Log.e("Error", "Cannot access system brightness");
            e.printStackTrace();
        }

        //Set the progress of the seek bar based on the system's brightness
        brightbar.setProgress(brightness);

        //Register OnSeekBarChangeListener, so it can actually change values
        brightbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Set the system brightness using the brightness variable value
                boolean writeResult= Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
                Log.i("sys settings write:", String.valueOf(writeResult));
                //Get the current window attributes
                LayoutParams layoutpars = window.getAttributes();
                //Set the brightness of this window
                layoutpars.screenBrightness = brightness / (float) 255;
                //Apply attribute changes to this window
                window.setAttributes(layoutpars);
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brightness = progress;
                LayoutParams layoutpars = window.getAttributes();
                //Set the brightness of this window
                layoutpars.screenBrightness = brightness / (float) 255;
                //Apply attribute changes to this window
                window.setAttributes(layoutpars);
                /*
                //Set the minimal brightness level
                //if seek bar is 20 or any value below
                if (progress <= 20) {
                    //Set the brightness to 20
                    brightness = 20;
                } else //brightness is greater than 20
                {
                    //Set brightness variable based on the progress bar
                    brightness = progress;
                }

                */

            }

            public void onStartTrackingTouch(SeekBar seekBar) {}
        });

        //Setting up the assistant
        assistant = new Assistant(TutorialActivity_2.this, 1);
        assistant.button = (Button) findViewById(R.id.assistantBox);
        assistant.button.setText("Now we'll set the screen brightness\n " +
                "and pressure sensitivity.\n" +
                "Please toggle the \nbrightness bar and press \nthe button below 3 times");


        assistant.button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                assistant.speakOut("Now we will set the screen brightness " +
                        "and pressure sensitivity.\n" +
                        "Please toggle the brightness bar and press the \n button below 3 times");

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tutorial_activity_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*
    * This method calculate the new pressingDuration by the current value and the duration
    * from the last measure.
    * The calculation is simple average minus 20% (to avoid false positive)
    * */
    private void updatePressingDuration(long lastDuration){
        pressingCounter++;
        pressingDuration= (pressingDuration + lastDuration ) / pressingCounter;
        pressingDuration= (long)(pressingDuration * 0.80);

        //write value to shared reference variable
        SharedPreferences userPreferences= getSharedPreferences(HomeActivity.USER_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor= userPreferences.edit();
        editor.putLong(HomeActivity.PRESSING_DURATION, pressingDuration);
        boolean succeed=editor.commit();
        Log.i("Shared Pref commit:", String.valueOf(succeed));
    }
}

