package com.bard;

/**
 * Created by shaun on 7/15/17.
 */

public class song implements Comparable<song>{
    private long id;
    private String title;
    private String artist;
    private String album;
    private String genre;

    public song(long songID, String songTitle, String songArtist, String songAlbum, String songGenre) {
        id = songID;
        title = songTitle;
        artist = songArtist;
        album = songAlbum;
        genre = songGenre;
    }

    public long getID(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getAblum(){
        return album;
    }
    public String getGenre(){
        return genre;
    }

    public int compareTo(song other) {
        return album.compareTo(other.album);
    }
}
