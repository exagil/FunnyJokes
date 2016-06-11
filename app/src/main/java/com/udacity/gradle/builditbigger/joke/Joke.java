package com.udacity.gradle.builditbigger.joke;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Joke implements Parcelable {
    @SerializedName("jokeDescription")
    public final String description;

    public Joke(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || !(o instanceof Joke)) return false;
        Joke thatJoke = (Joke) o;
        if ((this.description != null) && (this.description.equals(thatJoke.description)))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
    }

    protected Joke(Parcel in) {
        this.description = in.readString();
    }

    public static final Creator<Joke> CREATOR = new Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel source) {
            return new Joke(source);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
        }
    };
}
