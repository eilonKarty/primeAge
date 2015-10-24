package com.primage.user.primeage;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class HomeActivity extends Activity {

    boolean isAssistantMode = false;
    private Assistant assistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.assistant = new Assistant(HomeActivity.this, 1);
        startService(new Intent(HomeActivity.this, FloatingAssistant.class));

        // Setting the background color to white
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(-1);
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
}