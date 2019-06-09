package mymusic;

//Verder is er het MusicCollection object, deze bevat een collectie van playlistsCollection.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicCollection {


    public MusicCollection musicCollection;
    private String collectionName;
    private Playlist[] playlistsCollection;

    public MusicCollection(String collectionName) {

        this.collectionName = collectionName;
    }


    public Playlist[] getPlaylistsCollection() {
        return playlistsCollection;
    }

    public void setPlaylistsCollection(Playlist... playlistsCollection) {
        this.playlistsCollection = playlistsCollection;
    }

    public String getName() {
        return collectionName;
    }

    public void addPlayinglistToCollectino(Playlist playlist) {
        List<Playlist> playlists = new ArrayList<>();
        playlists = Stream.of(playlistsCollection).collect(Collectors.toList());

    }

    public void setName(String name) {
        this.collectionName = name;
    }

    public void addSongToPlaylist(String playListName, Song songObject) {
        this.playlistsCollection = Stream.of(playlistsCollection)
                                         .collect(Collectors.toList())
                                         .stream()
                                         .peek(s -> s.addSong(songObject))
                                         .toArray(Playlist[]::new);
    }

    @Override
    public String toString() {
        return "MusicCollection{" +
                "musicCollection=" + musicCollection +
                ", collectionName='" + collectionName + '\'' +
                ", playlistsCollection=" + Arrays.toString(playlistsCollection) +
                '}';
    }
}
