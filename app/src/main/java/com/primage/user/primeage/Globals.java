package com.primage.user.primeage;

import android.app.Activity;
import android.widget.LinearLayout;

/**
 * Created by Tzion on 10/17/15.
 */
public class Globals extends Activity{



    static private int screenWidth;
    static private int screenHeight;


    static public int getScreenHeight() {
        return screenHeight;
    }

    static public int getScreenWidth() {
        return screenWidth;
    }

    static public void setScreenWidth(int screenWidth) {
        screenWidth = screenWidth;
    }

    static public void setScreenHeight(int screenHeight) {
        screenHeight = screenHeight;
    }






}
