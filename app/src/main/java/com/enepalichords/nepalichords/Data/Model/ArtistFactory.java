package com.enepalichords.nepalichords.Data.Model;

/**
 * Created by sameer on 3/3/15.
 */
public class ArtistFactory {

    public static Artist createArtistObject(String name, String description) {
        return new Artist(name, description);
    }

}
