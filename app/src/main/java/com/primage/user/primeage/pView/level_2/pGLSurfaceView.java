package com.primage.user.primeage.pView.level_2;

import android.content.Context;
import android.util.AttributeSet;
import com.primage.user.primeage.pView.GUIConstraintException;

import android.opengl.GLSurfaceView;
import android.annotation.TargetApi;

/**
 * Level 2 in pView hierarchy
 *
 */

public class pGLSurfaceView extends GLSurfaceView {

    public pGLSurfaceView(Context context) throws GUIConstraintException{
        super(context);
        checkConstraints(context);
    }


    public pGLSurfaceView(Context context, AttributeSet attrs) throws GUIConstraintException{
        super(context, attrs);
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
