package com.example.musicplayer;

public class SongList {
    private int image;
    private int song;
    private  String songName;


    public String getSongName() {
        return songName;
    }

    public void setSongName(String pSongName) {
        songName = pSongName;
    }

    public SongList(int pImage, int pSong, String pSongName) {
        image = pImage;
        song = pSong;
        songName = pSongName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int pImage) {
        image = pImage;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int pSong) {
        song = pSong;
    }
}
