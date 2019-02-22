package com.example.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private  Context mContext;
    private  ArrayList<SongList> mSongLists;
    ListAdapter(Context pContext, ArrayList<SongList> pSongLists){
        mContext=pContext;
        mSongLists=pSongLists;
    }
    @Override
    public int getCount() {
        return mSongLists==null?0:mSongLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mSongLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.custom_list_layout,parent,false);
        TextView song_name=v.findViewById(R.id.song_name);
        ImageView song_image=v.findViewById(R.id.song_image);
        song_name.setText(mSongLists.get(position).getSongName());
        song_image.setImageResource(mSongLists.get(position).getImage());
        return v;
    }
}
