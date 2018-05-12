package com.bard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shaun on 9/27/17.
 */

public class artistAdapter extends BaseAdapter {
    private ArrayList<artist> artists;
    private LayoutInflater songInf;

    public artistAdapter(Context c, ArrayList<artist> theArtists){
        artists=theArtists;
        songInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return artists.size();
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
        LinearLayout artistLay = (LinearLayout) songInf.inflate
                (R.layout.artist, parent, false);
        //get title and artist views
        TextView artistView = (TextView) artistLay.findViewById(R.id.artistName);
        //get song using position
        artist currArtist = artists.get(position);
        //get title and artist strings
        artistView.setText(currArtist.getName());
        //set position as tag
        artistLay.setTag(position);
        return artistLay;
    }
}
