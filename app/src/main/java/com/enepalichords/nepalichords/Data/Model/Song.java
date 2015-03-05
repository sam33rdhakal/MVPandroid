package com.enepalichords.nepalichords.Data.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;


/**
 * Created by sameer on 3/3/15.
 */
@Table(name = "Song")
public class Song extends Model {

    @Column(name = "song_title")
    public String title;

    @Column(name = "song_lyrics")
    public String lyrics;

    @Column(name = "song_year")
    public int year;

    @Column(name = "artist")
    public Artist artist;

    public Song() {
        super();
    }

    public Song(String title, String lyrics, Artist artist) {
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
    }

}
