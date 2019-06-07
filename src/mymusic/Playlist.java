package mymusic;

import java.util.Arrays;
import java.util.function.Predicate;


public class Playlist {

    private Song[] songs;

    public Playlist(Song... songs) {
        this.songs = songs;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        Song[] tempArray = Arrays.copyOf(songs, songs.length + 1);
        tempArray[ tempArray.length - 1 ] = song;
        this.songs = tempArray;
    }

    public void removeSong(Song song) throws MyException {

        int a = songs.length;

        songs = Arrays.stream(songs)
                //Predicta.not inverse la condition.
                .filter(Predicate.not(e -> e.equals(song)))
                .toArray(Song[]::new);

        if (songs.length == a) {
            throw new MyException();
        }
    }

    @Override
    public String toString() {
        return "\nPlaylist{" +
                "songs=" + Arrays.toString(songs) +
                '}';
    }
}
