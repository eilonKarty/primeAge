package com.primage.user.primeage;

import android.annotation.TargetApi;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by OrLak on 16/10/2015.
 */
public class Assistant {
    private Character character;
    private TextToSpeech textToSpeech;
    private Context context;
    public Button button;
    public final int numOfCharsInRow = 20;


    public Assistant (Context context, int chosenCharacter) {
        this.context = context;
        switch (chosenCharacter) {
            case 1: character = new George();
//            case 2: character = new Jane();
        }

        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int language = textToSpeech.setLanguage(Locale.UK);
                    if (language == TextToSpeech.LANG_MISSING_DATA || language == TextToSpeech.LANG_NOT_SUPPORTED) {
                        textToSpeech.setLanguage(Locale.US);
                        Log.e("error", "This Language is not supported");
                    }

                    textToSpeech.setPitch(0);
                    textToSpeech.setSpeechRate(1);
                }
                else {
                    Log.e("error", "Initilization Failed!");        }
            }
        }
        ); }

    public void destroyAssistant() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    public String setTextToWriteByBox(String text) {
        String result = "";
        String charsArray[] = text.split("");
        int numOfRows = charsArray.length/numOfCharsInRow;
        for (int i = 0; i < numOfRows; i++) {
            result += Arrays.copyOfRange(charsArray, i*numOfCharsInRow, i+numOfCharsInRow-1).toString() + "\n";
        }
        result += Arrays.copyOfRange(charsArray, numOfCharsInRow*(numOfRows+1), charsArray.length);
        return result;
    }

    @TargetApi(21)
    public void speakOut(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "startWindow");
    }
}
