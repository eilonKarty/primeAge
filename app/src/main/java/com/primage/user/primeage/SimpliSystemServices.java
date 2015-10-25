package com.primage.user.primeage;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.os.Vibrator;


/**
 * Created by user on 24/10/2015.
 */
public class SimpliSystemServices {
    static long then = 0;
    static long startTime = 0;
    static long estimatedTime = 0;

    // A function that delays a press
    public static boolean waitAfterClick(View v, MotionEvent event, Context context){
        Log.e("OR-HOMO---------------", "YES");
        long longClickDuration = 100;
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        //start measure time
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
           then = (long) System.currentTimeMillis();
            return false;
        }

        //start vibarate after trashold
        if((System.currentTimeMillis() - then) > longClickDuration){
            vibrator.vibrate(100);
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            if ((System.currentTimeMillis() - then) > longClickDuration) {
                System.out.println("Long Click has happened!: " + (System.currentTimeMillis() - then));
                return true;
            } else {
                /* Implement short click behavior here or do nothing */
                System.out.println("Short Click has happened..." + (System.currentTimeMillis() - then));
                return false;
            }
        }
        then = 0;
        startTime = 0;
        estimatedTime = 0;
        return false;
    }

    // A function that measures
    public static long timeMeasure(View v, MotionEvent event, Context context){
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            startTime = System.currentTimeMillis();
        }

        if(event.getAction() == MotionEvent.ACTION_UP){
                estimatedTime = System.currentTimeMillis() - startTime;
        }

        return estimatedTime;
    }

}
