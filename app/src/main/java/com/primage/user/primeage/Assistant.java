package com.primage.user.primeage;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Switch;

/**
 * Created by OrLak on 16/10/2015.
 */
public class Assistant {
    Character character;
    private TextToSpeech tts;
    Context context;

    public Assistant (Context context, int chosenCharacter) {
        switch (chosenCharacter) {
            case 1: character = new George(tts);
            default: character = new George(tts);
        }

        tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                character.onInit(status);
            }
        }
        ); }

    public void activateAssistantStateMainScreen() {
        //TODO
    }

    public void activateAssistantStateSecondaryScreen() {
        character.speakOut();
    }


}
