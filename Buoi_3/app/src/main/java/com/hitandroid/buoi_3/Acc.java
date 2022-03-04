package com.hitandroid.buoi_3;

import android.os.Parcel;
import android.os.Parcelable;

public class Acc implements Parcelable {

    private String tk;
    private String mk;

    public Acc() {
    }

    public Acc(String tk, String mk) {
        this.tk = tk;
        this.mk = mk;
    }

    protected Acc(Parcel in) {
        tk = in.readString();
        mk = in.readString();
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

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tk);
        parcel.writeString(mk);
    }
}
