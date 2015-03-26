package com.enepalichords.nepalichords.Data.Model;


import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by sameer on 3/3/15.
 */


public class Artist implements Parcelable {

    int id;

    public String name;

    public String description;

    public String avatar;



    public Artist() {
    }

    public Artist(int id, String name, String description, String avatar) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avatar = avatar;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(avatar);
    }

    public Artist(Parcel input) {
        id = input.readInt();
        name = input.readString();
        description = input.readString();
        avatar = input.readString();
    }

    public static final Parcelable.Creator<Artist> CREATOR
            = new Parcelable.Creator<Artist>() {
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}
