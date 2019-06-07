package mymusic;


import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Welcome to My Music App");
        System.out.println("-".repeat(40));
        Song song1 = new Song("Drastical", "Vincent", "Ep", "4,20");
        Song song2 = new Song("Comfortably Numb ", "Pink Floyd", "The Wall", "6,21");
        Song song3 = new Song("Natural Blues", "Moby", "Play", "4,17");
        Song song4 = new Song("Killer Queen", "Queen", "Sheer Heart Attack", "3,00");


        Playlist playlist = new Playlist(song1, song2, song3, song4);

        System.out.println("\nSong List");
        System.out.println("*".repeat(40));
        for (Song s : playlist.getSongs()) {
            System.out.println("Song :" + s);
        }

        playlist.addSong(new Song("Bohemian Rhapsody", "Queen", "A Night At the Opera", "5,55"));


        System.out.println("\nSong List After Add Song");
        System.out.println("*".repeat(40));
        for (Song s : playlist.getSongs()) {
            System.out.println("Song :" + s);
        }


        try {

//            playlist.removeSong(new Song("DSDS", "ARTIST DE MERDE", "Album 3", "0,20"));

            playlist.removeSong(song1);
            System.out.println("\nSong List After Remove Song");
            System.out.println("*".repeat(40));
            for (Song s : playlist.getSongs()) {
                System.out.println("Song :" + s);
            }

        } catch (MyException me) {
            me.printStackTrace();
        }

    }

}

