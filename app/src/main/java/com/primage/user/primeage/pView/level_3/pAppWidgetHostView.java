package com.primage.user.primeage.pView.level_3;

import android.content.Context;
import android.util.AttributeSet;
import com.primage.user.primeage.pView.GUIConstraintException;

import android.appwidget.AppWidgetHostView;
import android.annotation.TargetApi;

/**
 * Level 3 in pView hierarchy
 *
 */

public class pAppWidgetHostView extends AppWidgetHostView {

    public pAppWidgetHostView(Context context) throws GUIConstraintException{
        super(context);
        checkConstraints(context);
    }

    public pAppWidgetHostView(Context context, int animationIn, int animationOut) throws GUIConstraintException {
        super(context,animationIn, animationOut);
        checkConstraints(context, animationIn, animationOut);
    }


    /**
     * Checks that the Context and the Attributes are valid according to the specific graphical limitation
     * @throws GUIConstraintException in case attrs break the constraints for this View object
     */

    private void checkConstraints(Context context, int animationIn, int animationOut, AttributeSet... attrs)
            throws GUIConstraintException{
        //TODO add constrains
    }


    //sending to checkConstraints( , , ,...) with defaults values
    private void checkConstraints(Context context) throws GUIConstraintException{
        this.checkConstraints(context, 0, 0);
    }




}
