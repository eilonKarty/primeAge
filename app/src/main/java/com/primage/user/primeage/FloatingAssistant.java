package com.primage.user.primeage;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by OrLak on 24/10/2015.
 */
public class FloatingAssistant extends Service {

        private WindowManager windowManager;
        private ImageView head;

        @Override public IBinder onBind(Intent intent) {
            // Not used
            return null;
        }

        @Override public void onCreate() {
            super.onCreate();

            windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

            head = new ImageView(this);
            head.setImageResource(R.drawable.assistent_button);

            WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);

            params.gravity = Gravity.BOTTOM | Gravity.LEFT;
            params.x = 0;
            params.y = 100;

            windowManager.addView(head, params);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            if (head != null) windowManager.removeView(head);
        }
    }
