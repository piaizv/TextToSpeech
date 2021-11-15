package org.izv.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private boolean ttsReady = false;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @Override
    public void onInit(int i) {
        ttsReady = true;
        tts.setLanguage(new Locale("spa", "ES"));
    }

    private void initialize() {
        tts = new TextToSpeech(this, this);
        Button btTts = findViewById(R.id.btTts);
        EditText etText = findViewById(R.id.etText);

        btTts.setOnClickListener(view -> {
            if(ttsReady && !etText.getText().toString().isEmpty()) {
                tts.speak(etText.getText().toString(), TextToSpeech.QUEUE_ADD, null, null);
            }
        });

    }
}