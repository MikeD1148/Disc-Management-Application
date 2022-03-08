package com.company;

import java.util.*;

public class Main {

    //This is the Main Menu where the user can select to go to different functions in the application
    //It uses a switch statement to quickly and efficiently cycle through the options
    //The menu will reappear whenever the uses completes an application and will end when the user chooses 10
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean interest = true;
        while (interest == true) {
            System.out.println("Hello, this Application will allow you to store discs in a file library, search through that library and remove items from that library\nPress 1: To add a new Game\nPress 2: To add new Music\nPress 3: To search Music by Title\nPress 4: To search Games by Title\nPress 5: To delete Music\nPress 6: To delete a Game\nPress 7: To edit Music\nPress 8: To edit Games\nPress 9: To print the list in reverse\nPress 10: To exit Application");
            switch (in.nextInt()) {
                case 1:
                    FileHandling.addGame("");break;
                case 2:
                    FileHandling.addMusic("");break;
                case 3:
                    FileHandling.searchForMusic();break;
                case 4:
                    FileHandling.searchForGame();break;
                case 5:
                    FileHandling.deleteMusic("delete");break;
                case 6:
                    FileHandling.deleteGame("delete");break;
                case 7:
                    FileHandling.editMusic();break;
                case 8:
                    FileHandling.editGame();break;
                case 9:
                    ManagementOfDiscInformation.printLibraryInReverse();break;
                case 10:
                    interest = false;break;
                default:
                    System.out.println("That was not a valid input please try again");
                    main(null);break;
            }
        }

    }
}