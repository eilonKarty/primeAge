package com.primage.user.primeage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Setting the background color to white
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(-1);


        // Display date
        SimpleDateFormat sdfd = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdfm = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfdd = new SimpleDateFormat("dd");
        Date d = new Date();
        String date = sdfd.format(d) + ",\n" + sdfm.format(d) + " " + sdfdd.format(d);
        TextView tv = (TextView)findViewById(R.id.date);
        tv.setText(date);

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
}