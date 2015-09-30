package com.primage.user.primeage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showApps(View v) {
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }

    public static class PButton extends Button {
        public PButton(Context context, AttributeSet attrs) {
            super(context, attrs);
            System.out.print("THIS IS MY MF CONSTRUCTOR!!!");
            Log.d("THIS IS ALSO", "MY MF LOG");
            //TODO - STUFF
        }
    }


}