package com.primage.user.primeage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.os.Vibrator;


/**
 * Created by user on 24/10/2015.
 */
public class SimpliSystemServices {
    static long then = 0;


    public static boolean waitAfterClick(View v, MotionEvent event, Context context){
        long longClickDuration = 14;
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
           then = (long) System.currentTimeMillis();
        }

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
        return false;
    }



}
