package com.enepalichords.nepalichords.Data.Model;

/**
 * Created by sameer on 3/3/15.
 */
public class ModelFactory {

    public static Artist createArtistObject(int id, String name, String description, String Avatar) {
        return new Artist(id, name, description, Avatar);
    }

    public static Song createSong(int id, String title, String lyrics, int artist_id) {
        return new Song(id, title, lyrics, artist_id);
    }

    public static Menu createMenu(String menu, String iconUrl) {
        return new Menu(menu, iconUrl);
    }
}
