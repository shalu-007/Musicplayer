package com.example.musicplayer;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements f1.buttonClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void sendText(String text) {
        f2 frag = (f2) getSupportFragmentManager().findFragmentById(R.id.f2);
        assert frag != null;
        frag.updateText(text);
    }
}
