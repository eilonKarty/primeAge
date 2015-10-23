package com.primage.user.primeage;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.primage.user.primeage.tutorial.TutorialActivity_1;

import java.text.SimpleDateFormat;
import java.util.Date;



public class HomeActivity extends Activity {

    //shared preferences conventions to be used by any activity that needs them
    public static final String USER_PREFERENCES="userPreference";
    public static final String FIRST_RUN="firstRun";
    public static SharedPreferences userPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting user preferences from previous session
        userPreferences= getSharedPreferences(USER_PREFERENCES, MODE_PRIVATE);
        //checking if this is the first run
        boolean firstRun= userPreferences.getBoolean(FIRST_RUN,true);

        if (firstRun){
            Intent tutorial= new Intent(this, TutorialActivity_1.class);
            startActivity(tutorial);
        }


        setContentView(R.layout.activity_home);
        // Setting the background color to white- Tzion: "Why? I'm cancel that"
        /*
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(-1);
        */





        // Display date
        SimpleDateFormat sdfd = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdfm = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfdd = new SimpleDateFormat("dd");
        Date d = new Date();
        String date = sdfd.format(d) + ",\n" + sdfm.format(d) + " " + sdfdd.format(d);
        TextView tv = (TextView)findViewById(R.id.date);
        tv.setText(date);


        ImageButton button = (ImageButton)findViewById(R.id.apps_button2);
        button.setOnTouchListener(new View.OnTouchListener() {
            long startTime = 0;
            long estimatedTime = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //start calculate your time here
                    startTime = System.currentTimeMillis();
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    estimatedTime = System.currentTimeMillis() - startTime;
                    TextView tv = (TextView) findViewById(R.id.date);
                    tv.setText("" + estimatedTime);
                }
                return true;
            }
        });

    }


    // Apps display method
    public void showApps(View v) {
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }

    // A method for starting the dialer
    public void popDialer(View v) {
        Intent i = new Intent(this, PrimeDialer.class);
        startActivity(i);
    }
}