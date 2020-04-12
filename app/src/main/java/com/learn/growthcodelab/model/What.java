package com.learn.growthcodelab.model;

import android.os.Parcel;
import android.os.Parcelable;

public class What implements Parcelable {
    private final String name;

    public What(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected What(Parcel in) {
        name = "No name";
    }

    public static final Creator<What> CREATOR = new Creator<What>() {
        @Override
        public What createFromParcel(Parcel in) {
            return new What("WHAT!");
        }

        @Override
        public What[] newArray(int size) {
            return new What[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(name);
    }
}
