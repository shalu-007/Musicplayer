package com.example.musicplayer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MyLocalBinder mMyLocalBinder = new MyLocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mMyLocalBinder;
    }
    public void setMediaPlayer(Context pContext,int song){
        MediaPlayer vMediaPlayer = MediaPlayer.create(pContext, song);
        vMediaPlayer.setLooping(true);
        vMediaPlayer.start();
        Toast.makeText(pContext, "Music", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    class MyLocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}
