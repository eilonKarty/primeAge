package com.primage.user.primeage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

        Button assistantButton = (Button) findViewById(R.id.assistant_button);
        assistantButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SimpliSystemServices.waitAfterClick(v, event, HomeActivity.this)) {
                    if (!isAssistantMode) {
                        setAssistantMode(v);
                    } else {
                        setGeneralMode(v);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onDestroy() {
        assistant.destroyAssistant();
        super.onDestroy();

        // Display date
        SimpleDateFormat sdfd = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdfm = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfdd = new SimpleDateFormat("dd");
        Date d = new Date();
        String date = sdfd.format(d) + ",\n" + sdfm.format(d) + " " + sdfdd.format(d);
        TextView tv = (TextView) findViewById(R.id.date);
        tv.setText(date);

        //Listener of settings button
        Button settingsButton = (Button) findViewById(R.id.apps_button6);
        settingsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent tutorial = new Intent(getApplicationContext(), TutorialActivity_1.class);
                startActivity(tutorial);
                return true;
            }
        });
    }
    

    @Override
    public void onPause() {
        assistant.destroyAssistant();
        super.onPause();
    }

    // Apps display method
    public void showApps(View v) {
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }

    @Override
    public void onStop() {
        assistant.destroyAssistant();
        super.onStop();
    }

    public void openPhone(View v) {
        if (!isAssistantMode) {
            Intent i = new Intent(this, PrimeDialer.class);
            startActivity(i);
        }
        else {
            assistant.button.setText(" This is the dialer.\n if you want to call \n someone, press here");
            assistant.speakOut("This is the dialer, if you want to call someone, press here!");
        }
    }

    public void openMessages(View v) {
        if (!isAssistantMode) {
/*            Intent i = new Intent(this, openMessages.class);
            startActivity(i);*/
        }
        else {
            assistant.button.setText(" Here you can send \n and read SMS and \n online messages.");
            assistant.speakOut("Here you can send and read es em es and online messages");
        }
    }

    public void openClock(View v) {
        if (!isAssistantMode) {
/*            Intent i = new Intent(this, openMessages.class);
            startActivity(i);*/
        }
        else {
            assistant.button.setText(" Set an alarm clock \n and i will wake \n you up");
            assistant.speakOut("set an alarm clock and i will wake you up");
        }
    }

    public void openContacts(View v) {
        if (!isAssistantMode) {
/*            Intent i = new Intent(this, openMessages.class);
            startActivity(i);*/
        }
        else {
            assistant.button.setText(" Look for one of \n your contacts in \n order to call");
            assistant.speakOut("look for one of your contacts in order to call");
        }
    }

    public void openFlashlight(View v) {
        if (!isAssistantMode) {
/*            Intent i = new Intent(this, openMessages.class);
            startActivity(i);*/
        }
        else {
            assistant.button.setText(" With one button you \n can use a great \n flashlight");
            assistant.speakOut("with one press you can use a great flashlight");
        }
    }

    public void openCamera(View v) {
        if (!isAssistantMode) {
/*            Intent i = new Intent(this, openMessages.class);
            startActivity(i);*/
        }
        else {
            assistant.button.setText(" With one press you \n can take a photo  \n and it will be saved");
            assistant.speakOut("With one press you can take a photo and it will be saved");
        }
    }

    public void openNews(View v) {
        if (!isAssistantMode) {
/*            Intent i = new Intent(this, openMessages.class);
            startActivity(i);*/
        }
        else {
            assistant.button.setText(" Here you can catch-up \n with the news");
            assistant.speakOut("Here you can catch-up with the news");
        }
    }

    public void openSetting(View v) {
        if (!isAssistantMode) {
/*            Intent i = new Intent(this, openMessages.class);
            startActivity(i);*/
        }
        else {
            assistant.button.setText(" Here you can set \n some properties \n about your phone");
            assistant.speakOut("Here you can set some properties about your phone");
        }
    }

    public void openApps(View v) {
        if (!isAssistantMode) {
            Intent i = new Intent(this, AppsListActivity.class);
            startActivity(i);
        }
        else {
            assistant.button.setText(" Here are all the \n applications, you can \n use existing or \n download new ones");
            assistant.speakOut("Here are awl the applications, \n\n\n you can use existing or download new ones");        }
    }

    /* SWITCH BETWEEN ASSISTANT MODE AND GENERAL MODE */

    public void setGeneralMode(View view) {
        setContentView(R.layout.activity_home);
        isAssistantMode = false;
    }

    public void setAssistantMode(View view) {
        setContentView(R.layout.activity_home_mode_assistant);
        assistant.speakOut(" Hi again, \n welcome to the main page, \n don't forget that we are always together");
        assistant.button = (Button) findViewById(R.id.assistant_button);
        assistant.button.setText(" Hi again, welcome to \n the main page, \n don't forget that we \n are always together");
        isAssistantMode = true;
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
}