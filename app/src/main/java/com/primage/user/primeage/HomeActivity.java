package com.primage.user.primeage;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class HomeActivity extends Activity {
    Assistant assistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.assistant = new Assistant(HomeActivity.this, 1);
        setContentView(R.layout.activity_home);

        // Setting the background color to white
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(-1);
    }

    public void showApps(View v) {
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }

    // A method for starting the dialer
    public void popDialer(View v) {
        Intent i = new Intent(this, PrimeDialer.class);
        startActivity(i);
    }

    public void createAssistant(View v) {
        assistant.activateAssistantStateMainScreen();
        assistant.activateAssistantStateSecondaryScreen();
    }
}