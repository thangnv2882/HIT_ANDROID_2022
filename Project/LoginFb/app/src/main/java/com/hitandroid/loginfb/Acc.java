package com.hitandroid.loginfb;

import android.os.Parcel;
import android.os.Parcelable;

public class Acc implements Parcelable {

    private String user;
    private String pass;

    public Acc() {
    }

    public Acc(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }


    protected Acc(Parcel in) {
        user = in.readString();
        pass = in.readString();
    }

    public static final Creator<Acc> CREATOR = new Creator<Acc>() {
        @Override
        public Acc createFromParcel(Parcel in) {
            return new Acc(in);
        }

        @Override
        public Acc[] newArray(int size) {
            return new Acc[size];
        }
    };

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(user);
        parcel.writeString(pass);
    }
}
