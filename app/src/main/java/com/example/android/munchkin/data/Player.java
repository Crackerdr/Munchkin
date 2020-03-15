package com.example.android.munchkin.data;

import android.os.Parcel;
import android.os.Parcelable;


public class Player implements Parcelable {
    private String mPlayer;
    private int mScore;

    public Player(String player, int score) {
        mPlayer = player;
        mScore = score;

    }


    protected Player(Parcel in) {
        mPlayer = in.readString();
        mScore = in.readInt();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getPlayer() {
        return mPlayer;
    }

    public int getScore() {
        return mScore;
    }

    public void setPlayer(String player) {
        mPlayer = player;
    }

    public void setScore(int score) {
        mScore = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mPlayer);
        parcel.writeInt(mScore);
    }

}
