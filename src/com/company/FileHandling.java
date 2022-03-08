package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class FileHandling{

    static Scanner scanner = new Scanner(System.in);
    private static Scanner delete;
    static Vector<Game> newGameEntry = new Vector<>();
    static Vector<Music> newMusicEntry = new Vector<>();

    //This function adds music to the music library by asking the user for information to put in a vector to then be added to the csv file
    public static void addMusic(String addEdit) {
        System.out.println("Please Enter A " + addEdit + "Title: ");
        String title = scanner.nextLine();
        System.out.println("Please Enter " + addEdit + "Artist: ");
        String artist = scanner.nextLine();
        System.out.println("Please Select A " + addEdit + "Genre:\nPress 1: Rock\nPress 2: Jazz\nPress 3: Pop\nPress 4: Musical Theatre\nPress 5: Hip Hop");
        String genre;
        switch (scanner.nextInt()) {
            case 1:genre = "Rock";break;
            case 2:genre = "Jazz";break;
            case 3:genre = "Pop";break;
            case 4:genre = "Musical Theatre";break;
            case 5:genre = "Hip Hop";break;
            default:genre = "Invalid, please try again";
        }
        System.out.println("Please Enter A " + addEdit + "Release Date: ");
        String dummy = scanner.nextLine();
        String releaseDate = scanner.nextLine();
        System.out.println("Please Enter The " + addEdit + "Number Of Songs:");
        int numberOfSongs = scanner.nextInt();
        System.out.println("Please Enter The " + addEdit + "Duration Of The Song:");
        String filler = scanner.nextLine();
        String duration = scanner.nextLine();
        Music newMusic = new Music(title, artist, genre, releaseDate, numberOfSongs, duration);
        newMusicEntry.add(newMusic);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("MusicLibrary.csv", true))) {
            for (Music music : newMusicEntry) {
                writer.write(music.getTitle() + "," + music.getArtist() + "," + music.getGenre() +  "," + music.getReleaseDate() + "," + music.getNumberOfSongs() + "," + music.getDuration());
                writer.newLine();
                System.out.println("Success");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //This function adds games to the game library by asking the user for information to put in a vector to then be added to the csv file
    public static void addGame(String addEdit) {

        System.out.println("Please Enter A " + addEdit + "Title: ");
        String title = scanner.nextLine();
        System.out.println("Please Select A " + addEdit + "Genre:\n1: Action\n2: Action-Adventure\n3: Adventure\n4: Role-playing\n5: Simulation");
        String genre;
        switch (scanner.nextInt()) {
            case 1:genre = "Action";break;
            case 2:genre = "Action-Adventure";break;
            case 3:genre = "Adventure";break;
            case 4:genre = "Role-playing";break;
            case 5:genre = "Simulation";break;
            default:genre = "Invalid, please try again";
        }
        System.out.println("Please Enter A " + addEdit + "Release Date:");
        String dummy = scanner.nextLine();
        String releaseDate = scanner.nextLine();
        System.out.println("Please Select A " + addEdit + "PEGI Rating:\n1: PEGI 3\n2: PEGI 7\n3: PEGI 12\n4: PEGI 16\n5: PEGI 18");
        int PEGIRating = 0;
        switch (scanner.nextInt()) {
            case 1:PEGIRating = 3;break;
            case 2:PEGIRating = 7;break;
            case 3:PEGIRating = 12;break;
            case 4:PEGIRating = 16;break;
            case 5:PEGIRating = 18;break;
            default:System.out.println("Invalid, please try again");
        }
        System.out.println("Please Select A " + addEdit + "Platform:\nPress 1: For PC\nPress 2: For PS4\nPress 3: For XboxOne\nPress 4: For PS5\nPress 5: For XboxX");
        String platform = "";
        switch (scanner.nextInt()) {
            case 1:platform = "PC";break;
            case 2:platform = "PS4";break;
            case 3:platform = "XboxOne";break;
            case 4:platform = "PS5";break;
            case 5:platform = "XboxX";break;
            default:System.out.println("Invalid, please try again");
        }
        Game newGame = new Game(title, genre, releaseDate, PEGIRating, platform);
        newGameEntry.add(newGame);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("GameLibrary.csv", true))) {
            for (Game game : newGameEntry) {
                writer.write(game.getTitle() + "," + game.getGenre() + "," + game.getReleaseDate() + "," + game.getPEGIRating() + "," + game.getPlatform());
                writer.newLine();
                System.out.println("Success");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //This function will ask you for a game title, read through the game csv file and then print out an array for the row your title was on
    public static void searchForGame(){
        String space;
        System.out.println("Please Enter A Game Title:");
        Scanner scanner = new Scanner(System.in);
        String specifiedGame = scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("GameLibrary.csv"));
            while ((space = reader.readLine()) != null) {
                String[] values = space.split(",");
                String testVal = values[0];
                if (specifiedGame.equals(testVal))
                    System.out.println("Success, here are the results of your search: " + values[0] + "," + values[1] + "," + values[2] + "," + values[3] + "," + values[4]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //This function will ask you for a music title, read through the music csv file and then print out an array for the row your title was on
    public static void searchForMusic(){
        String space;
        System.out.println("Please Enter A Music Title:");
        Scanner scanner = new Scanner(System.in);
        String specifiedMusic = scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("MusicLibrary.csv"));
            while ((space = reader.readLine()) != null) {
                String[] values = space.split(",");
                String testVal = values[0];
                if (specifiedMusic.equals(testVal))
                    System.out.println("Success, here are the results of your search: " + values[0] + "," + values[1] + "," + values[2] + "," + values[3] + "," + values[4] + "," + values[5]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //This function will ask you for a game title read through the game csv file rewrite everything in there except for the row your title was on into a new file, delete the old file and then rename the new file to the name of the original file
    public static void deleteGame(String deleteEdit){
        String filepath = "GameLibrary.csv";
        System.out.println("Please Enter The Title Of The Game You Want To " + deleteEdit);
        String removeTerm = scanner.nextLine();
        String tempFile = "temp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String title = "";String genre = "";String releaseDate = "";String PEGIRating = "";String platform = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            delete = new Scanner(new File(filepath));
            delete.useDelimiter("[,\n]");

            while(delete.hasNext())
            {
                title = delete.next();
                genre = delete.next();
                releaseDate = delete.next();
                PEGIRating = delete.next();
                platform = delete.next();
                if(!title.equals(removeTerm))
                {
                    pw.println(title + "," + genre + "," + releaseDate + "," + PEGIRating + "," + platform);
                }
            }
            delete.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //This function will ask you for a music title read through the music csv file rewrite everything in there except for the row your title was on into a new file, delete the old file and then rename the new file to the name of the original file
    public static void deleteMusic(String deleteEdit){
        String filepath = "MusicLibrary.csv";
        System.out.println("Please Enter The Title Of The Music You Want To "  + deleteEdit);
        String removeTerm = scanner.nextLine();
        String tempFile = "temp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String title = "";String artist = "";String genre = "";String releaseDate = "";String numberOfSongs = "";String duration = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            delete = new Scanner(new File(filepath));
            delete.useDelimiter("[,\n]");

            while(delete.hasNext())
            {
                title = delete.next();
                genre = delete.next();
                releaseDate = delete.next();
                artist = delete.next();
                numberOfSongs = delete.next();
                duration = delete.next();
                if(!title.equals(removeTerm))
                {
                    pw.println(title + "," + genre + "," + releaseDate + "," + artist + "," + numberOfSongs + "," + duration);
                }
            }
            delete.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //The edit function will call the delete and add functions back to back to delete and then add a game
    public static void editGame(){

        deleteGame("edit");
        addGame("new ");
    }

    //The edit function will call the delete and add functions back to back to delete and then add music
    public static void editMusic(){

        deleteMusic("edit");
        addMusic("new ");
    }

}