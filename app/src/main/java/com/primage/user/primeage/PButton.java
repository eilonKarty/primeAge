package com.primage.user.primeage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;


public class PButton extends Button {
    public PButton(Context context, AttributeSet attrs){
            super(context, attrs);
            final int check = this.getPaddingBottom();
            Log.d("FIRSTCHECK", ""+check);
            if ((check == 30) || (check == 29)) {
                Log.d("check123", ""+check);
                //TODO-STUFF
            }

        }
}


