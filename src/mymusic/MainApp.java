package mymusic;

import java.util.Comparator;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("\n\t\t\tWelcome to My Music App");
        System.out.println("-".repeat(70));
        Song song1 = new Song("Drastical", "Vincent", "Ep", "4,20");
        Song song2 = new Song("Comfortably Numb ", "Pink Floyd", "The Wall", "6,21");
        Song song3 = new Song("Natural Blues", "Moby", "Play", "4,17");
        Song song4 = new Song("Killer Queen", "Queen", "Sheer Heart Attack", "3,00");


        Playlist vincentPlayList = new Playlist("Vincent Playlist", song1, song2, song3, song4);
        Playlist vincentPLaylist2 = new Playlist("Vincent Playlist2", song1);

        System.out.println("\nSong List");
        System.out.println("*".repeat(70));
        for (Song s : vincentPlayList.getSongs()) {
            System.out.println("Song :" + s);
        }

        vincentPlayList.addSong(new Song("Bohemian Rhapsody", "Queen", "A Night At the Opera", "5,55"));


        System.out.println("\nSong List After Add Song");
        System.out.println("*".repeat(70));
        for (Song s : vincentPlayList.getSongs()) {
            System.out.println("Song :" + s);
        }


        try {

//          vincentPlayList.removeSong(new Song("DSDS", "ARTIST DE MERDE", "Album 3", "0,20"));
            vincentPlayList.removeSong(song1);
            System.out.println("\nSong List After Remove Song");
            System.out.println("*".repeat(70));
            for (Song s : vincentPlayList.getSongs()) {
                System.out.println("Song :" + s);
            }

        } catch (MyException me) {
            me.printStackTrace();
        }

        System.out.println("\nCount of songs in your List.");
        System.out.println("*".repeat(70));
        System.out.println(vincentPlayList.countOfPlayList());


        System.out.println("\nDisplay all songs in your List.");
        System.out.println("*".repeat(70));
        vincentPlayList.displayPlaylist();


        System.out.println("\nSort all songs in your List by Titel.");
        System.out.println("*".repeat(70));
        vincentPlayList.sortByName();
        vincentPlayList.displayPlaylist();


        System.out.println("\nSort all songs in your List by playing time.");
        System.out.println("*".repeat(70));
        vincentPlayList.sortByPlayingTime();
        vincentPlayList.displayPlaylist();

        System.out.println("\nSort all songs in your List by given comparator.");
        System.out.println("*".repeat(70));
        vincentPlayList.sort((Comparator.comparing(Song::getAlbum)));
        vincentPlayList.displayPlaylist();


        //Making a collection of playlists
        MusicCollection musicCollection = new MusicCollection("Vincent Playlist");

        //Adding a collection of playlists in playlistcollection.
        musicCollection.setPlaylistsCollection(vincentPlayList,vincentPLaylist2);



        //Adding songs via de addSongToPlaylist methode from de music Collection.
        musicCollection.addSongToPlaylist(vincentPlayList.getPlaylistName(),
                new Song("Hans is Driving", "Vitalic", "Voyager", "3,45"));

        //Adding a existing song to a playlist via the music Collection methode.
        musicCollection.addSongToPlaylist(vincentPLaylist2.getPlaylistName(), song2);


        System.out.println("\nSong List After adding song in the musicCollection");
        System.out.println("*".repeat(70));
        vincentPlayList.displayPlaylist();
        System.out.println();
        vincentPLaylist2.displayPlaylist();




    }
}

