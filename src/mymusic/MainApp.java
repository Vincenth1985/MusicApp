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
        Song song5 = new Song("Bohemian Rhapsody", "Queen", "A Night At the Opera", "5,55");
        Song song6 = new Song("Hans is Driving", "Vitalic", "Voyager", "3,45");

        Playlist vincentPlaylist = new Playlist("Vincent Playlist", song1, song2, song3, song4);
        Playlist vincentPLaylist2 = new Playlist("Vincent Playlist2", song1);
        Playlist vincentPlaylist3 = new Playlist("Vincent Playlist3", song4);

        System.out.println("\nSong List");
        System.out.println("*".repeat(70));
        for (Song s : vincentPlaylist.getSongs()) {
            System.out.println("Song :" + s);
        }

        vincentPlaylist.addSong(song5);


        System.out.println("\nSong List After Add Song");
        System.out.println("*".repeat(70));
        for (Song s : vincentPlaylist.getSongs()) {
            System.out.println("Song :" + s);
        }


        try {

//          vincentPlayList.removeSong(new Song("DSDS", "ARTIST DE MERDE", "Album 3", "0,20"));
            vincentPlaylist.removeSong(song1);
            System.out.println("\nSong List After Remove Song");
            System.out.println("*".repeat(70));
            for (Song s : vincentPlaylist.getSongs()) {
                System.out.println("Song :" + s);
            }

        } catch (MyException me) {
            me.printStackTrace();
        }

        System.out.println("\nCount of songs in your List.");
        System.out.println("*".repeat(70));
        System.out.println(vincentPlaylist.countOfPlayList());


        System.out.println("\nDisplay all songs in your List.");
        System.out.println("*".repeat(70));
        vincentPlaylist.displayPlaylist();


        System.out.println("\nSort all songs in your List by Titel.");
        System.out.println("*".repeat(70));
        vincentPlaylist.sortByName();
        vincentPlaylist.displayPlaylist();


        System.out.println("\nSort all songs in your List by playing time.");
        System.out.println("*".repeat(70));
        vincentPlaylist.sortByPlayingTime();
        vincentPlaylist.displayPlaylist();

        System.out.println("\nSort all songs in your List by given comparator.");
        System.out.println("*".repeat(70));
        vincentPlaylist.sort((Comparator.comparing(Song::getAlbum)));
        vincentPlaylist.displayPlaylist();


        //Making a collection of playlists
        MusicCollection musicCollection = new MusicCollection("Vincent Collection");


        //Adding playlist to the collection of playlist
        musicCollection.addPlayinglistToCollectino(vincentPlaylist);

        musicCollection.addPlayinglistToCollectino(vincentPLaylist2);
        musicCollection.addPlayinglistToCollectino(vincentPLaylist2);
        musicCollection.addPlayinglistToCollectino(vincentPlaylist3);
        //removing playlist of the collection
        musicCollection.removePlayList(vincentPLaylist2);


        //Count of playlist in the collection.
        System.out.println("\nCount of playlists in the Collection");
        System.out.println("*".repeat(70));
        System.out.println(musicCollection.countOfPlaylistsInCollection());

        System.out.println("\nPlaylists in the collection");
        System.out.println("*".repeat(70));
        musicCollection.printList();

        //Adding songs via de addSongToPlaylist methode from de music Collection.
        musicCollection.addSongToPlaylist(vincentPlaylist.getPlaylistName(), song6);
        musicCollection.addSongToPlaylist(vincentPLaylist2.getPlaylistName(), song5);
        musicCollection.addSongToPlaylist("Vincent Playlist3", song2);

        musicCollection.removeSongFormPlaylist(vincentPLaylist2.getPlaylistName(), song5);

        System.out.println("\nSong List After adding song in the musicCollection");
        System.out.println("*".repeat(70));
        System.out.println("\n" + vincentPlaylist.getPlaylistName());
        System.out.println("-".repeat(20));
        vincentPlaylist.displayPlaylist();

        System.out.println("\n" + vincentPLaylist2.getPlaylistName());
        System.out.println("-".repeat(20));
        vincentPLaylist2.displayPlaylist();

        System.out.println("\n" + vincentPlaylist3.getPlaylistName());
        System.out.println("-".repeat(20));
        vincentPlaylist3.displayPlaylist();

    }

}


