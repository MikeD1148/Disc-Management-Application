package com.company;

public class Music extends Disc {
    private String artist;
    private String genre;
    private int numberOfSongs;
    private String duration;

    //The music subclass inherits the title and release date from the disc superclass as both the game and music classes have these variables
    public Music(String theTitle, String theReleaseDate,String theArtist, String theGenre, int theNumberOfSongs, String theDuration){
        super(theTitle, theReleaseDate);
        this.artist = theArtist;
        this.genre = theGenre;
        this.numberOfSongs = theNumberOfSongs;
        this.duration = theDuration;
    }

    //Allowing the main class to access specific artists etc. without making the variables public for security
    public String getArtist(){
        return this.artist; }
    public String getGenre(){
        return this.genre; }
    public int getNumberOfSongs(){
        return this.numberOfSongs; }
    public String getDuration(){ return this.duration; }

}