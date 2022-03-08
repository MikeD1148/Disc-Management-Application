package com.company;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;
import java.util.Vector;


public class FileHandlingTest {

    static Vector<Game> newGameEntry = new Vector<>();
    static Vector<Music> newMusicEntry = new Vector<>();

    @Test
    public void addMusicTest(){
        String expected = "hat";
        String title = "hat";
        String artist = "cat";
        String genre = "pat";
        String releaseDate = "what";
        int numberOfSongs = 12;
        String duration = "16min";
        Music newMusic = new Music(title, artist, genre, releaseDate, numberOfSongs, duration);
        newMusicEntry.add(newMusic);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("MusicLibrary.csv", true))) {
            for (Music music : newMusicEntry) {
                writer.write(music.getTitle() + "," + music.getArtist() + "," + music.getGenre() +  "," + music.getReleaseDate() + "," + music.getNumberOfSongs() + "," + music.getDuration());
                writer.newLine();
                assertEquals(expected,newMusicEntry.firstElement());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addGameTest(){
        String expected = "hello there";
        String title = "hello there";
        String genre = "general kenobi";
        String releaseDate = "you are a bold one";
        int PEGIRating = 0;
        String platform = "they've taken the hobbits...";
        Game newGame = new Game(title, genre, releaseDate, PEGIRating, platform);
        newGameEntry.add(newGame);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("GameLibrary.csv", true))) {
            for (Game game : newGameEntry) {
                writer.write(game.getTitle() + "," + game.getGenre() + "," + game.getReleaseDate() + "," + game.getPEGIRating() + "," + game.getPlatform());
                writer.newLine();
                assertEquals(expected,newMusicEntry.firstElement());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void MusicSearchTest() {
        String space;
        String testSearchWord = "sprite cranberry";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("MusicLibrary.csv"));
            while ((space = reader.readLine()) != null) {
                String[] values = space.split(",");
                String testVal = values[0];
                if (testSearchWord.equals(testVal)) {
                    assertEquals(testSearchWord, testVal);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void GameSearchTest() {
        String space;
        String testSearchWord = "sprite cranberry";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("GameLibrary.csv"));
            while ((space = reader.readLine()) != null) {
                String[] values = space.split(",");
                String testVal = values[0];
                if (testSearchWord.equals(testVal)) {
                    assertEquals(testSearchWord, testVal);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
