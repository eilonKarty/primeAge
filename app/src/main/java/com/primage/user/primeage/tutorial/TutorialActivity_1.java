package com.primage.user.primeage.tutorial;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.primage.user.primeage.Globals;
import com.primage.user.primeage.HomeActivity;
import com.primage.user.primeage.R;

public class TutorialActivity_1 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting screen measures
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Globals.setScreenHeight(size.y);
        Globals.setScreenWidth(size.x);

        setContentView(R.layout.activity_tutorial_activity_1);

/*
        //Listener implementation
        View.OnClickListener continueTutorial1Listener = new View.OnClickListener() {
            public void onClick(View v) {
                //TODO add check that user chose page preferences
                Intent tutorial2 = new Intent(v.getContext(), TutorialActivity_2.class);
                startActivity(tutorial2);
            }
        };

        //set buttons listeners
        ImageButton pushToContinueButton= (ImageButton)findViewById(R.id.pushToContinueButton);
        pushToContinueButton.setOnClickListener(continueTutorial1Listener);


        //set buttons graphic states
        Button smallTextSize= (Button)findViewById(R.id.TextSizeButton);
        smallTextSize.setBackgroundResource(R.drawable.main_button_custom);

*/
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

}
