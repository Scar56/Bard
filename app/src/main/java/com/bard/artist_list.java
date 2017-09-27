package com.bard;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.shaun.musicapp.R;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Shaun Carpenter on 9/19/17.
 */

public class artist_list extends Base{
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.item_list);

        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);

// MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
// app-defined int constant

                return;
            }}

        artistView = (ListView)findViewById(R.id.song_list);
        getArtistList();

        Collections.sort(artistList, new Comparator<artist>(){
            public int compare(artist a, artist b){
                return a.getName().compareTo(b.getName());
            }
        });

        artistAdapter artistAdt = new artistAdapter(this, artistList);
        artistView.setAdapter(artistAdt);
        setController();
    }

    //connect to the service
//    private ServiceConnection musicConnection = new ServiceConnection(){
//
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            MusicService.MusicBinder binder = (MusicService.MusicBinder)service;
//            //get service
//            musicSrv = binder.getService();
//            //pass list
//            musicSrv.setList(songList);
//            musicBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            musicBound = false;
//        }
//    };
    public void getArtistList() {
        //retrieve song info
        ContentResolver musicResolver = getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            int albumColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ALBUM);
            //add songs to list

            do {
                boolean added = false;
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                String thisAlbum = musicCursor.getString(albumColumn);

                for (artist i:artistList) {
                    if(i.getName().equals(thisArtist)){
                        added = true;
                        i.addSong(new song(thisId, thisTitle, thisArtist, thisAlbum, null));
                        break;
                    }
                }

                if(!added)
                    artistList.add(new artist(thisArtist, new song(thisId, thisTitle, thisArtist, thisAlbum, null)));
            }
            while (musicCursor.moveToNext());
        }
    }
}
