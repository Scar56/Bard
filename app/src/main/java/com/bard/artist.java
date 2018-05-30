package com.bard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    public void sortAlbums(){
        Collections.sort(songList,new Comparator<song>(){
            public int compare(song one, song two) {
                // compare using whichever properties of ListType you need
                        return one.getAblum().compareTo(two.getAblum());
            }});
    }
}