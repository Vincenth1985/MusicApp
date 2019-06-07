package mymusic;

//Verder is er het MusicCollection object, deze bevat een collectie van playlists.


import java.util.Arrays;

public class MusicCollection {


    private Playlist[] playlists;

    public MusicCollection(Playlist[] playlists) {
        this.playlists = playlists;
    }


    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "MusicCollection{" +
                "playlists=" + Arrays.toString(playlists) +
                '}';
    }
}
