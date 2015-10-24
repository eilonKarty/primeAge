package com.primage.user.primeage.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        //Listener implementation
        View.OnClickListener continueTutorial1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add check that user chose page preferences
                Intent tutorial2 = new Intent(getApplicationContext(), TutorialActivity_2.class);
                startActivity(tutorial2);
                finish();
            }
        };

        final ToggleButton smallTextSizeButton = (ToggleButton) findViewById(R.id.smallTextSizeButton);
        final ToggleButton mediumTextSizeButton = (ToggleButton) findViewById(R.id.mediumTextSizeButton);
        final ToggleButton bigTextSizeButton = (ToggleButton) findViewById(R.id.bigTextSizeButton);

        View.OnTouchListener textSizeListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //TODO take user choice (text size) into shared preferenced
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ArrayList<ToggleButton> buttons = new ArrayList(2);
                    if (v != smallTextSizeButton)
                        buttons.add(smallTextSizeButton);
                    if (v != mediumTextSizeButton)
                        buttons.add(mediumTextSizeButton);
                    if (v != bigTextSizeButton)
                        buttons.add(bigTextSizeButton);

                    checkSingleButton((ToggleButton) v, buttons.get(0), buttons.get(1));

                }
                return true;
            }
        };


        //set buttons listeners
        ImageButton pushToContinueButton = (ImageButton) findViewById(R.id.pushToContinueButton);
        pushToContinueButton.setOnClickListener(continueTutorial1Listener);

        //set text size buttons listeners
        smallTextSizeButton.setOnTouchListener(textSizeListener);
        mediumTextSizeButton.setOnTouchListener(textSizeListener);
        bigTextSizeButton.setOnTouchListener(textSizeListener);


        //set input-name button
        EditText nameTextButton = (EditText) findViewById(R.id.nameFieldButton);
        final TextView nameLine= (TextView) findViewById(R.id.nameLine);
        nameTextButton.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i("KeyBoard", "Inside the Edit Text");
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                    CharSequence name= v.getText();
                    v.setText("");
                    v.setHint("");
                    Log.i("User Entered name: ", name.toString());
                    nameLine.setText("Name:    "+name);
                }
                return true;
            }
        });
    }

    //This function keeps only one button pressed
    private void checkSingleButton(ToggleButton pressed, ToggleButton... others) {
        if (pressed.isChecked()) {
            pressed.toggle();
        } else {
            for (ToggleButton button : others) {
                button.setChecked(false);
            }
            pressed.setChecked(true);
        }

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
