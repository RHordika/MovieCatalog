package com.example.moviecatalog;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Movie implements Parcelable {
    private String tittle;
    private double rate;
    private int year;
    private String director;
    private List<String> stars;
    private String summary;
    private String poster;
    private String genere;

    protected Movie(Parcel in) {
        tittle = in.readString();
        rate = in.readDouble();
        year = in.readInt();
        director = in.readString();
        stars = in.createStringArrayList();
        summary = in.readString();
        poster = in.readString();
        genere = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tittle);
        parcel.writeDouble(rate);
        parcel.writeInt(year);
        parcel.writeString(director);
        parcel.writeStringList(stars);
        parcel.writeString(summary);
        parcel.writeString(poster);
        parcel.writeString(genere);
    }
}
