package com.bard;

import java.util.ArrayList;

/**
 * Created by shaun on 9/20/17.
 */

public class artist {
    private String name;
    private ArrayList<song> songList = new ArrayList<song>();

    artist(String name, song song){
        this.name = name;
        songList.add(song);
    }
    public String getName(){
        return name;
    }

    public void addSong(song song){
        songList.add(song);
    }

    public ArrayList<song> getsongs(){
        return songList;
    }
}
