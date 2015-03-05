package com.enepalichords.nepalichords.Data.Model;

import com.activeandroid.query.Select;

import java.util.List;


/**
 * Created by sameer on 3/3/15.
 */
public class ModelFactory {

    public static Artist createArtistObject(String name, String description) {
        return new Artist(name, description);
    }

    public static Song createSongObject(Artist artist, String title, String lyrics) {
        return new Song(title, lyrics, artist);
    }

    public static List<Artist> getAll() {
        return new Select()
                .from(Artist.class)
                .execute();
    }
}
