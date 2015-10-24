package com.primage.user.primeage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PrimeDialer extends Activity {
    boolean isAssistantMode = false;
    private Assistant assistant;

    private String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_dialer);

        assistant = new Assistant(PrimeDialer.this, 1);

        // Setting the background color to white
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(-1);
        final Context context = getApplicationContext();

        Button one = (Button) findViewById(R.id.oneButton);
        one.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SimpliSystemServices.waitAfterClick(v, event, context)) {
                    addFigure('1');
                }
                ;
                return false;
            }
        });

        Button two = (Button) findViewById(R.id.twoButton);
        two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('2');
                };
                return false;
            }
        });

        Button three = (Button) findViewById(R.id.threeButton);
        three.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('3');
                };
                return false;
            }
        });

        Button four = (Button) findViewById(R.id.fourButton);
        four.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('4');
                };
                return false;
            }
        });

        Button five = (Button) findViewById(R.id.fiveButton);
        five.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SimpliSystemServices.waitAfterClick(v, event, context)) {
                    addFigure('5');
                }
                ;
                return false;
            }
        });

        Button six = (Button) findViewById(R.id.sixButton);
        six.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('6');
                };
                return false;
            }
        });

        Button seven = (Button) findViewById(R.id.sevenButton);
        seven.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('7');
                };
                return false;
            }
        });

        Button eight = (Button) findViewById(R.id.eightButton);
        eight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('8');
                };
                return false;
            }
        });

        Button nine = (Button) findViewById(R.id.nineButton);
        nine.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('9');
                };
                return false;
            }
        });

        Button star = (Button) findViewById(R.id.starButton);
        star.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('*');
                };
                return false;
            }
        });

        Button zero = (Button) findViewById(R.id.zeroButton);
        zero.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('0');
                };
                return false;
            }
        });

        Button hash = (Button) findViewById(R.id.hashButton);
        hash.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context)){
                    addFigure('#');
                };
                return false;
            }
        });

        Button call = (Button) findViewById(R.id.callbutton);
        call.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context))
                {
                    makeCall(v);
                }
                return false;
            }
        });

        Button delete = (Button) findViewById(R.id.deletebutton);
        delete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context))
                {
                    deleteFigure(v);
                }
                return false;
            }
        });

        Button backbutton = (Button) findViewById(R.id.dialback);
        backbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context))
                {
                    finish();
                }
                return false;
            }
        });

        Button homeButton = (Button) findViewById(R.id.dialhome);
        homeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(SimpliSystemServices.waitAfterClick(v, event, context))
                {
                    goHome(v);
                }
                return false;
            }
        });

    /*
        //Listener of assitant
        Button assistantButton = (Button) findViewById(R.id.assistant_button);
        assistantButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (SimpliSystemServices.waitAfterClick(v, event, context)) {
                    if (!isAssistantMode) {
                        setAssistantMode(v);
                    } else {
                        setGeneralMode(v);
                    }
                }
                return false;
            }
        });
      */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prime_dialer, menu);
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

    public void doNothing(View v){
        // A void function
    }

    private void checkNumberSize(){
        if(number.length() == 3 || number.length() == 7){
            number += "-";
        }
    }

    public void addFigure(char fig){
        number = number + fig;
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void deleteFigure(View v) {
        if (isAssistantMode) {
            boolean flg = false;
            if (number.length() != 0) {
                if (number.length() == 5 || number.length() == 9) {
                    number = number.substring(0, number.length() - 2);
                    flg = true;
                } else {
                    number = number.substring(0, number.length() - 1);
                }

                TextView tv = (TextView) findViewById(R.id.number);
                tv.setText(number);
                if (flg) {
                    number += "-";
                }
            }
        }
        else {
            assistant.button.setText("Press here in order \n  to delete a digit \n from text box");
            assistant.speakOut("Press here in order to delete a digit from text box");
        }
    }

    public void makeCall(View v){
        if (!isAssistantMode) {
            if (number.length() != 0) {
                String str = "tel:" + number;
                Uri uri = Uri.parse(str);
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                }
                ;
            }
        }
        else {
            assistant.button.setText("Press here to make a \n call after inserting \n the number");
            assistant.speakOut("Press here to make a call after inserting the number");
        }
    }

    public void finishAct(View v){
        finish();
    }

    public void goHome(View v){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }
}
