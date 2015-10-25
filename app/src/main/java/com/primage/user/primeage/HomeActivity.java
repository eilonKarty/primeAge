package com.primage.user.primeage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

import com.primage.user.primeage.tutorial.TutorialActivity_1;
import com.primage.user.primeage.tutorial.TutorialActivity_2;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HomeActivity extends Activity {

    //shared preferences conventions to be used by any activity that needs them
    public static final String USER_PREFERENCES = "userPreference";
    public static final String FIRST_RUN = "firstRun";
    public static final String PRESSING_DURATION = "pressingDuration";
    public static SharedPreferences userPreferences;

    boolean isAssistantMode = false;
    private Assistant assistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting user preferences from previous session
        userPreferences = getSharedPreferences(USER_PREFERENCES, MODE_PRIVATE);
        //checking if this is the first run
        boolean firstRun = userPreferences.getBoolean(FIRST_RUN, true);

        if (firstRun) {
            Intent tutorial = new Intent(this, TutorialActivity_1.class);
            startActivity(tutorial);
        }

        setContentView(R.layout.activity_home);

        this.assistant = new Assistant(HomeActivity.this, 1);


        // Setting the background color to white
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(-1);

        // run listeners initilization
        setListeners();
    }


    // A method for setting date and listeners
    private void setListeners(){
        // Display date
        SimpleDateFormat sdfd = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdfm = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfdd = new SimpleDateFormat("dd");
        Date d = new Date();
        String date = sdfd.format(d) + ",\n" + sdfm.format(d) + " " + sdfdd.format(d);
        TextView tv = (TextView)findViewById(R.id.date);
        tv.setText(date);

        // Setting buttons listeners

        assistant.button = (Button)findViewById(R.id.assistant_button);
        if (isAssistantMode) {
            assistant.button.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())) {
                        setGeneralMode(v);
                    }
                    return false;
                }
            });
        }
        else {
            assistant.button.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())) {
                        setAssistantMode(v);
                    }
                    return false;
                }
            });
        }

        Button phone = (Button)findViewById(R.id.phone_button);
        phone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())) {
                    if(isAssistantMode){
                        assistant.speakOut("This is the dialer, if you want to call someone, press here!");
                        assistant.button.setText("This is the dialer.\\n if you want to call \\n someone, press here");
                    }
                    else{
                        popDialer(v);
                    }
                }
                return false;
            }
        });

        Button messages = (Button)findViewById(R.id.messages_button);
        messages.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())){

                    if(isAssistantMode){
                        assistant.speakOut("Here you can send and read es em es and online messages");
                        assistant.button.setText("Here you can send \\n and read SMS and \\n online messages.");
                    }
                    else{
                        // TODO
                    }
                }
                return false;
            }
        });

        final Button alarmClock = (Button)findViewById(R.id.clock_button);
        alarmClock.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())){
                    if(isAssistantMode){
                        assistant.speakOut("set an alarm clock and i will wake you up");
                        assistant.button.setText(" Set an alarm clock \\n and i will wake \\n you up");
                    }
                    else{
                        // TODO
                    }
                }
                return false;
            }
        });

        Button contacts = (Button)findViewById(R.id.contacts_button);
        contacts.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())){
                    if(isAssistantMode){
                        assistant.speakOut("look for one of your contacts in order to call");
                        assistant.button.setText("Look for one of \\n your contacts in \\n order to call");
                    }
                    else{
                        popContacts(v);
                    }
                }
                return false;
            }
        });

        Button flashlight = (Button)findViewById(R.id.flashlight_button);
        flashlight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())){
                    if(isAssistantMode){
                        assistant.speakOut("with one press you can use a great flashlight");
                        assistant.button.setText("With one button you \\n can use a great \\n flashlight");
                    }
                    else{
                        // TODO
                    }
                }
                return false;
            }
        });

        Button camera = (Button)findViewById(R.id.camera_button);
        camera.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())){
                    if(isAssistantMode){
                        assistant.speakOut("With one press you can take a photo and it will be saved");
                        assistant.button.setText(" With one press you \\n can take a photo  \\n and it will be saved");
                    }
                    else{
                        // TODO
                    }
                }
                return false;
            }
        });

        Button news = (Button)findViewById(R.id.news_button);
        news.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())){

                    if(isAssistantMode){
                        assistant.speakOut("Here you can catch-up with the news");
                        assistant.button.setText("Here you can catch-up \\n with the news");
                    }
                    else{
                        // TODO
                    }
                }
                return false;
            }
        });

        Button settings = (Button)findViewById(R.id.settings_button);
        settings.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())) {
                    if(isAssistantMode){
                        assistant.speakOut("Here you can set some properties about your phone");
                        assistant.button.setText("Here you can set \\n some properties \\n about your phone");
                    }
                    else{
                        popSettings(v);
                    }
                }
                return false;
            }
        });

        Button apps = (Button)findViewById(R.id.apps_button);
        apps.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())) {
                    if(isAssistantMode){
                        assistant.speakOut("Here are awl the applications, \\n\\n\\n you can use existing or download new ones");
                        assistant.button.setText("Here are all the \\n applications, you can \\n use existing or \\n download new ones");
                    }
                    else{
                        showApps(v);
                    }
                }
                return false;
            }
        });

        if (!isAssistantMode) {
            Button backButton = (Button) findViewById(R.id.back_button);
            backButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())) {
                        finish();
                    }
                    return false;
                }
            });

            Button homeButton = (Button) findViewById(R.id.home_button);
            homeButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (SimpliSystemServices.waitAfterClick(v, event, getApplicationContext())) {
                        goHome(v);
                    }
                    return false;
                }
            });
        }
    }

    // A method to invoke home page
    public void goHome(View v) {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    // A method to invoke settings
    public void popSettings(View v) {
        Intent i = new Intent(this, TutorialActivity_1.class);
        startActivity(i);
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

    // A method for opening contacts
    public void popContacts(View v) {
        Intent i = new Intent(this, ContactsActivity.class);
        startActivity(i);
    }

    @Override
    public void onDestroy() {
        assistant.destroyAssistant();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        assistant.destroyAssistant();
        super.onPause();
    }


    @Override
    public void onStop() {
        assistant.destroyAssistant();
        super.onStop();
    }

    /* SWITCH BETWEEN ASSISTANT MODE AND GENERAL MODE */

    public void setGeneralMode(View view) {
        setContentView(R.layout.activity_home);
        isAssistantMode = false;
        setListeners();
    }

    public void setAssistantMode(View view) {
        setContentView(R.layout.activity_home_mode_assistant);
        assistant.speakOut(" Hi again, \n welcome to the main page, \n don't forget that we are always together");
        assistant.button = (Button) findViewById(R.id.assistant_button);
        assistant.button.setText(" Hi again, welcome to \n the main page, \n don't forget that we \n are always together");
        isAssistantMode = true;
        setListeners();
    }
}