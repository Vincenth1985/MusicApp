package mymusic;

//Een PlayList object daarentegen bevat een collectie van songs.

import java.util.Arrays;

public class Playlist {

    private Song[] songs;


    public Playlist(Song[] songs) {
        this.songs = songs;
    }


    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }


    @Override
    public String toString() {
        return "Playlist{" +
                "songs=" + Arrays.toString(songs) +
                '}';
    }
}
