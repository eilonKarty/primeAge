package com.primage.user.primeage;

import android.annotation.TargetApi;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

/**
 * Created by OrLak on 16/10/2015.
 */
public class George extends Character {
    String name = "George";
    String gender = "male";
    String image = "file.jpg";
    TextToSpeech tts;

    public George(TextToSpeech tts) {
        super(tts);
    }

    @Override
    public void onInit(int status) {
        super.onInit(status);
        speakOut();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(21)
    public void speakOut() {
        String text = "hi, i am george, its really nice to meet you!";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "BEGINNING");
    }
}
