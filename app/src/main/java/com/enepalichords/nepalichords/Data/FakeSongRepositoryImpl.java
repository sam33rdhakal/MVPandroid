package com.enepalichords.nepalichords.Data;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.ArtistFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/8/15.
 */
public class FakeSongRepositoryImpl implements SongRepository {

    @Inject
    public FakeSongRepositoryImpl() {
    }

    @Override
    public List<Artist> getAllArtist() {
        List<Artist> artists = new ArrayList<Artist>();
        Artist artist = ArtistFactory.createArtistObject("John Lennon", "1940-1980");
        artists.add(artist);
        artist = ArtistFactory.createArtistObject("Bob Dylan", "1941 - ");
        artists.add(artist);
        artist = ArtistFactory.createArtistObject("Jim Morrison", "Lead Guitarist");
        artists.add(artist);
        artist = ArtistFactory.createArtistObject("Queen", "I want to break free");
        artists.add(artist);
        artist = ArtistFactory.createArtistObject("Kurt Cobain", "Nirvana");
        artists.add(artist);
        return artists;
    }


}
