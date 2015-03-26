package com.enepalichords.nepalichords.Data.Model;


import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by sameer on 3/9/15.
 */


public class Song implements Parcelable {

    int id;
    public String title;
    public String lyrics;
    int artist_id;

    public Song() {

    }

    public Song(int id, String title, String lyrics, int artist_id) {
        this.id = id;
        this.title = title;
        this.lyrics = lyrics;
        this.artist_id = artist_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(lyrics);
        parcel.writeInt(artist_id);
    }

    public Song(Parcel input) {
        id = input.readInt();
        title = input.readString();
        lyrics = input.readString();
        artist_id = input.readInt();
    }

    public static final Parcelable.Creator<Song> CREATOR
            = new Parcelable.Creator<Song>() {
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

}


