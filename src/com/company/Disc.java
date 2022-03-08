package com.company;

//The superclass variables
public class Disc {
    private String title;
    private String releaseDate;

    public Disc(String theTitle, String theReleaseDate){
        this.title = theTitle;
        this.releaseDate = theReleaseDate;
    }

    public String getTitle(){ return title; }
    public String getReleaseDate(){ return releaseDate; }

}
