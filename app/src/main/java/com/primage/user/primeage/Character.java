package com.primage.user.primeage;

import java.io.File;
import java.util.Locale;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
/**
 * Created by OrLak on 16/10/2015.
 */
public abstract class Character {
    String name;
    String gender;
    String image;
    TextToSpeech tts;

    public Character (TextToSpeech tts) {
        this.tts = tts;
    }

    public void onInit(int status) {
        if (status == tts.SUCCESS) {
            int language = tts.setLanguage(Locale.UK);
            if (language == TextToSpeech.LANG_MISSING_DATA
                    || language == TextToSpeech.LANG_NOT_SUPPORTED) {
                //TODO handle error
            } else {
                tts.setPitch(0);
                tts.setSpeechRate(1);
            }


        } else {
            //TODO handle error
        }
    }

    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        //super.onDestroy() //somthing about the activity???
    }

    abstract public void speakOut();
}
