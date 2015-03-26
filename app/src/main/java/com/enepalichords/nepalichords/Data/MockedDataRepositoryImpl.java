package com.enepalichords.nepalichords.Data;

import com.enepalichords.nepalichords.Data.Model.Artist;
import com.enepalichords.nepalichords.Data.Model.Menu;
import com.enepalichords.nepalichords.Data.Model.ModelFactory;
import com.enepalichords.nepalichords.Data.Model.Song;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by sameer on 3/8/15.
 */
public class MockedDataRepositoryImpl implements DataRepository {

    @Inject
    public MockedDataRepositoryImpl() {
    }

    @Override
    public List<Menu> getMenuList() {
        List<Menu> menus = new ArrayList<Menu>();
        Menu menu = ModelFactory.createMenu("Search", "ic_search_black_24dp");
        menus.add(menu);
        menu = ModelFactory.createMenu("Favorite", "ic_favorite_black_24dp");
        menus.add(menu);
        menu = ModelFactory.createMenu("Help", "ic_help_black_24dp");
        menus.add(menu);
        menu = ModelFactory.createMenu("About", "ic_subject_black_24dp");
        menus.add(menu);
        return menus;
    }

    @Override
    public List<Artist> getAllArtist() {
        List<Artist> artists = new ArrayList<Artist>();
        Artist artist = ModelFactory.createArtistObject(1, "John Lennon", "1940-1980", "http://media.bizj.us/view/img/3099541/bloomberg-john-lennon*400xx1837-1839-0-365.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(2, "Bob Dylan", "1941 - ", "http://www.rockbackingtracks.co.uk/images/attributes/bob_dylan-1.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(3, "Jim Morrison", "Lead Guitarist", "http://images.sfae.com/product_images/preview/360.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(4, "Queen", "I want to break free", "http://photos.prnewswire.com/prnvar/20140919/147210");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(5, "Kurt Cobain", "Nirvana", "https://bowiesongs.files.wordpress.com/2010/01/kc.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(6, "John Legend", "Great Singer", "https://pbs.twimg.com/profile_images/1170610429/John_Legend_Fans_400x400.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(7, "Bruno Mars", "Funky Singer", "http://www.men-hairstylescuts.com/wp-content/uploads/2015/01/Curly-Hairstyles-Bruno-Mars-5.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(8, "Rihanna", "Funky Singer", "https://pbs.twimg.com/profile_images/564927442838904833/vpKQt9Uh.jpeg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(9, "Pitbull", "Rap Singer", "http://static.djbooth.net/pics-artist/pitbull2.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(10, "Jennifer Lopez", "Rap Singer", "http://img2.timeinc.net/instyle/images/2009/GalxMonth/04/041409_lopez_400x400.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(11, "Norah Jones", "Classic Singer", "https://www.tradebit.com/usr/backingtracks4u/pub/9002/norah-jonesPic.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(12, "Kelly Clarkson", "Female Singer", "https://pbs.twimg.com/profile_images/216610762/l_7ef129eb9b794f5bb865de7a167777b1_400x400.jpg");
        artists.add(artist);
        artist = ModelFactory.createArtistObject(13, "Eminem", "Female Singer", "http://static.djbooth.net/pics-artist/eminem.jpg");
        artists.add(artist);
        return artists;
    }

    @Override
    public List<Song> getArtistSongs(int artistId) {

        List<Song> songs = new ArrayList<Song>();
        Song song = ModelFactory.createSong(1, "I wanna hold your hand", "Blah blah", 1);
        songs.add(song);
        song = ModelFactory.createSong(2, "Its my life", "Blah blah", 2);
        songs.add(song);
        song = ModelFactory.createSong(3, "Who you love", "Blah blah", 3);
        songs.add(song);
        song = ModelFactory.createSong(4, "Here i am", "Blah blah", 4);
        songs.add(song);
        song = ModelFactory.createSong(5, "Heart of Life", "Blah blah", 5);
        songs.add(song);
        song = ModelFactory.createSong(6, "You and me", "Scorpio", 2);
        songs.add(song);
        song = ModelFactory.createSong(7, "I am the one", "Blah blah", 3);
        songs.add(song);
        song = ModelFactory.createSong(8, "Hole Hearted", "Blah blah", 4);
        songs.add(song);
        song = ModelFactory.createSong(9, "You in heaven", "Blah blah", 5);
        songs.add(song);
        song = ModelFactory.createSong(6, "You and me", "Scorpio", 2);
        songs.add(song);
        song = ModelFactory.createSong(7, "I am the one", "Blah blah", 3);
        songs.add(song);
        song = ModelFactory.createSong(8, "Hole Hearted", "Blah blah", 4);
        songs.add(song);
        song = ModelFactory.createSong(9, "You in heaven", "Blah blah", 5);
        songs.add(song);
        song = ModelFactory.createSong(7, "I am the one", "Blah blah", 3);
        songs.add(song);
        song = ModelFactory.createSong(8, "Hole Hearted", "Blah blah", 4);
        songs.add(song);
        song = ModelFactory.createSong(9, "You in heaven", "Blah blah", 5);
        songs.add(song);
        song = ModelFactory.createSong(6, "You and me", "Scorpio", 2);
        songs.add(song);
        song = ModelFactory.createSong(7, "I am the one", "Blah blah", 3);
        songs.add(song);
        song = ModelFactory.createSong(8, "Hole Hearted", "Blah blah", 4);
        songs.add(song);
        song = ModelFactory.createSong(9, "You in heaven", "Blah blah", 5);
        songs.add(song);
        return songs;
    }
}
