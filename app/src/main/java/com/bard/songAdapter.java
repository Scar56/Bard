package com.bard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by shaun on 7/16/17.
 */

public class songAdapter extends BaseAdapter{
    private ArrayList<song> songs;
    private LayoutInflater songInf;
    private int use;

    public songAdapter(Context c, ArrayList<song> theSongs, int use){
        songs=theSongs;
        songInf=LayoutInflater.from(c);
        this.use = use;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //map to song layout
        LinearLayout songLay = (LinearLayout)songInf.inflate
                (R.layout.song, parent, false);
        Context context = songLay.getContext();
        //get title and artist views
        TextView songView = (TextView)songLay.findViewById(R.id.song_title);
        TextView artistView = (TextView)songLay.findViewById(R.id.song_artist);
        //get song using position
        song currSong = songs.get(position);
        //get title and artist strings
        songView.setText(currSong.getTitle());
        songView.setTextColor(configs.getColor("song",context));

        switch(use){
            case 1:
                artistView.setText(currSong.getArtist());
                break;
            case 2:
                artistView.setText(currSong.getAblum());
        }
        artistView.setTextColor(configs.getColor("song",context));
        //set position as tag
        songLay.setTag(position);
        return songLay;
    }

}
