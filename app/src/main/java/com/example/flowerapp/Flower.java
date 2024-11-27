package com.example.flowerapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Flower implements Parcelable {
    private String name;        // Name of the flower
    private String latinName;   // Latin name of the flower
    private String origin;      // Origin of the flower
    private String meaning;     // Meaning of the flower
    private Integer photo;      // Image resource ID of the flower

    // Constructor with parameters (to match FlowerData)
    public Flower(String name, String latinName, String origin, String meaning, Integer photo) {
        this.name = name;
        this.latinName = latinName;
        this.origin = origin;
        this.meaning = meaning;
        this.photo = photo;
    }

    // Default constructor
    public Flower() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    // Parcelable implementation
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.latinName);
        dest.writeString(this.origin);
        dest.writeString(this.meaning);
        dest.writeInt(this.photo != null ? this.photo : 0);
    }

    // Parcelable constructor
    protected Flower(Parcel in) {
        this.name = in.readString();
        this.latinName = in.readString();
        this.origin = in.readString();
        this.meaning = in.readString();
        this.photo = in.readInt();
    }

    // Parcelable Creator
    public static final Parcelable.Creator<Flower> CREATOR = new Parcelable.Creator<Flower>() {
        @Override
        public Flower createFromParcel(Parcel source) {
            return new Flower(source);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    };
}