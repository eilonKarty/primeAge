package com.primage.user.primeage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PrimeDialer extends Activity {

    private String number = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_dialer);
        // Setting the background color to white
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(-1);

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

    public void addOne(View v){
        number = number + "1";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addTwo(View v){
        number = number + "2";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addThree(View v){
        number = number + "3";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addFour(View v){
        number = number + "4";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addFive(View v){
        number = number + "5";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addSix(View v){
        number = number + "6";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addSeven(View v){
        number = number + "7";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addEight(View v){
        number = number + "8";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addNine(View v){
        number = number + "9";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addZero(View v){
        number = number + "0";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addHash(View v){
        number = number + "#";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void addStar(View v){
        number = number + "*";
        TextView tv = (TextView)findViewById(R.id.number);
        tv.setText(number);
        checkNumberSize();
    }

    public void deleteFigure(View v) {
        boolean flg = false;
        if (number.length() != 0){
            if (number.length() == 5 || number.length() == 9) {
                number = number.substring(0, number.length() - 2);
                flg = true;
            } else {
                number = number.substring(0, number.length() - 1);
            }

            TextView tv = (TextView) findViewById(R.id.number);
            tv.setText(number);
            if (flg){
                number += "-";
            }
        }
    }

    public void makeCall(View v){
        if(number.length() !=0) {
            String str = "tel:" + number;
            Uri uri = Uri.parse(str);
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            startActivity(intent);
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
