package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

//This prints both csv files to the console
public class ManagementOfDiscInformation {
    public static void printLibraryInReverse(){
        List<String> libraryData = new ArrayList<>();
        String row;
        try {
            //reading the music csv file and adding each row to an array
            BufferedReader brMusic = new BufferedReader(new FileReader("MusicLibrary.csv"));
            while ((row = brMusic.readLine()) != null) {
                libraryData.add(row);
            }
            //reading the game csv file and adding each row to an array
            BufferedReader brGame = new BufferedReader(new FileReader("GameLibrary.csv"));
            while ((row = brGame.readLine()) != null) {
                libraryData.add(row);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //Optimisation if there's only 1 row of data that will print normally either way
        if (libraryData.size() <= 1) {
            System.out.println(libraryData);
        }
        else {
            //Making the array print the library in reverse
            List<String> reverseIt = new ArrayList<>();
            reverseIt.add(libraryData.get(libraryData.size() - 1));
            reverseIt.addAll(libraryData.subList(0, libraryData.size() - 1));
            System.out.println(reverseIt);
        }
    }
}
