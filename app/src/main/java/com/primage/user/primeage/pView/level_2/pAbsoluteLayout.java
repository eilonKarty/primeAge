package com.primage.user.primeage.pView.level_2;

import android.content.Context;
import android.util.AttributeSet;
import com.primage.user.primeage.pView.GUIConstraintException;

import android.widget.AbsoluteLayout;
import android.annotation.TargetApi;

/**
 * Level 2 in pView hierarchy
 *
 */

public class pAbsoluteLayout extends AbsoluteLayout {

    public pAbsoluteLayout(Context context) throws GUIConstraintException{
        super(context);
        checkConstraints(context);
    }


    public pAbsoluteLayout(Context context, AttributeSet attrs) throws GUIConstraintException{
        super(context, attrs);
        checkConstraints(context, attrs);
    }


    public pAbsoluteLayout(Context context, AttributeSet attrs, int defStyleAttr) throws GUIConstraintException {
        super(context, attrs, defStyleAttr);
        checkConstraints(context, attrs);
    }


    @TargetApi(21)
    public pAbsoluteLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) throws GUIConstraintException {
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
