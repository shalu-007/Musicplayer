package com.example.musicplayer;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<SongList> mSongLists;
    private MyService mMyService;
    private boolean mStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.song_list_view);
        mSongLists = new ArrayList<>();
        mStarted = false;
        mSongLists.add(new SongList(R.drawable.ic_launcher_background, R.raw.song, "song 1"));
        mSongLists.add(new SongList(R.drawable.ic_launcher_background, R.raw.song, "song 2"));
        mSongLists.add(new SongList(R.drawable.ic_launcher_background, R.raw.song, "song 3"));
        mSongLists.add(new SongList(R.drawable.ic_launcher_background, R.raw.song, "song 4"));
        ListAdapter vAdapter = new ListAdapter(this, mSongLists);
        mListView.setAdapter(vAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMyService.setMediaPlayer(MainActivity.this, mSongLists.get(position).getSong());
                Toast.makeText(mMyService, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onStartClick(View v) {
        if (!mStarted) {
            Intent i = new Intent(MainActivity.this, MyService.class);
            bindService(i, mServiceConnection, BIND_AUTO_CREATE);
            mStarted = true;
        } else {
            onStopClick(v);
        }
    }

    public void onStopClick(View v) {
        if (mStarted) {
            unbindService(mServiceConnection);
            mStarted = false;
        }
    }

    MyService.MyLocalBinder vMyLocalBinder;
    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            vMyLocalBinder = (MyService.MyLocalBinder) service;
            mMyService = vMyLocalBinder.getService();
            Toast.makeText(mMyService, "Inside", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            vMyLocalBinder = null;
        }
    };
}
