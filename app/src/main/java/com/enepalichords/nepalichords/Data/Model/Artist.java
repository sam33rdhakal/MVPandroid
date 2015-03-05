package com.enepalichords.nepalichords.Data.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;


/**
 * Created by sameer on 3/3/15.
 */
@Table(name = "Artist")
public class Artist extends Model {

    @Column(name = "artist_name")
    public String name;

    @Column(name = "artist_introduction")
    public String description;

    public List<Song> songs() {
        return getMany(Song.class, "artist");
    }

    public Artist() {
        super();
    }

    public Artist(String name, String description){
        this.name = name;
        this.description = description;
    }
}
