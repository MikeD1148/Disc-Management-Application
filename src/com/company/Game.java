package com.company;

public class Game extends Disc {
    private String Genre;
    private int PEGIRating;
    private String platform;

    //The game subclass inherits the title and release date from the disc superclass as both the game and music classes have these variables
    public Game(String theTitle, String theReleaseDate, String theGenre, int thePEGIRating, String thePlatform){
        super(theTitle, theReleaseDate);
        this.Genre = theGenre;
        this.PEGIRating = thePEGIRating;
        this.platform = thePlatform;
    }

    //Allowing the main class to access specific genres etc. without making the variables public for security
    public String getGenre(){return this.Genre;}
    public int getPEGIRating(){return PEGIRating; }
    public String getPlatform(){ return platform; }

}
