package com.primage.user.primeage.pView.level_1;

import android.content.Context;
import android.util.AttributeSet;
import com.primage.user.primeage.pView.GUIConstraintException;

import android.inputmethodservice.KeyboardView;
import android.annotation.TargetApi;

/**
 * Level 1 in pView hierarchy
 *
 */

public class pKeyboardView extends KeyboardView {

    /*
    public pKeyboardView(Context context) throws GUIConstraintException{
        super(context);
        checkConstraints(context);
    }
    */

    public pKeyboardView(Context context, AttributeSet attrs) throws GUIConstraintException{
        super(context, attrs);
        checkConstraints(context, attrs);
    }


    public pKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) throws GUIConstraintException {
        super(context, attrs, defStyleAttr);
        checkConstraints(context, attrs);
    }


    @TargetApi(21)
    public pKeyboardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) throws GUIConstraintException {
        super(context, attrs, defStyleAttr, defStyleRes);
        checkConstraints(context, attrs);
    }


    /**
     * Checks that the Context and the Attributes are valid according to the specific graphical limitation
     * @throws GUIConstraintException in case attrs break the constraints for this View object
     */
    private void checkConstraints(Context context, AttributeSet... attrs) throws GUIConstraintException{
        //TODO add constrains
    }


}
