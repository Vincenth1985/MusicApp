package mymusic;

//Verder is er het MusicCollection object, deze bevat een collectie van playlistsCollection.

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MusicCollection {


    private String collectionName;
    private Playlist[] playlistsCollection = new Playlist[ 0 ];

    public MusicCollection(String collectionName) {

        this.collectionName = collectionName;
    }


    public Playlist[] getPlaylistsCollection() {
        return playlistsCollection;
    }

    public void setPlaylistsCollection(Playlist[] playlistsCollection) {
        this.playlistsCollection = playlistsCollection;
    }

    public String getName() {
        return collectionName;
    }

    public void addPlayinglistToCollectino(Playlist playlistToAdd) {
        Playlist[] temp = Arrays.copyOf(playlistsCollection, playlistsCollection.length + 1);
        temp[ temp.length - 1 ] = playlistToAdd;

        this.playlistsCollection = temp;

    }

    public void removePlayList(Playlist playlistToRemove) {
        List<Playlist> playlists = new ArrayList<>();
        for (int i = 0; i < playlistsCollection.length; i++) {
            playlists.add(playlistsCollection[ i ]);
        }
        playlists.remove(playlistToRemove);

        this.playlistsCollection = playlists.stream().toArray(Playlist[]::new);

    }

    public void setName(String name) {
        this.collectionName = name;
    }

    public void addSongToPlaylist(String playListName, Song songObject) {
        for (int i = 0; i < playlistsCollection.length; i++) {
            if (playlistsCollection[ i ].getPlaylistName().equalsIgnoreCase(playListName)) {
                playlistsCollection[ i ].addSong(songObject);
            }
        }


    }

    public void removeSongFormPlaylist(String playListName, Song songObject) {
        for (int i = 0; i < playlistsCollection.length; i++) {
            if (playlistsCollection[ i ].getPlaylistName().equalsIgnoreCase(playListName)) {
                playlistsCollection[ i ].removeSong(songObject);
            }
        }


    }

    public int countOfPlaylistsInCollection() {
        return playlistsCollection.length;
    }


    public void printList() {

        for (int i = 0; i < playlistsCollection.length; i++) {
            System.out.println(playlistsCollection[ i ].getPlaylistName());

        }
    }
}
