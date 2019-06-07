package mymusic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

    public int countOfPlayList() {
        return songs.length;

    }

    public void displayPlaylist() {

        Arrays.stream(songs).forEach(song -> System.out.println(song));
    }

    public void sortByName() {
        songs = Arrays.stream(songs).sorted(Comparator.comparing(Song::getTitel))
                .toArray(Song[]::new);
    }

    public void sortByPlayingTime() {
        songs = Arrays.stream(songs).sorted(Comparator.comparing(Song::getSpeelduur))
                .toArray(Song[]::new);
    }

    public void sort(Comparator<Song> comparator) {

        songs = Arrays.stream(songs).sorted(comparator)
                .toArray(Song[]::new);
    }


    @Override
    public String toString() {
        return "\nPlaylist{" +
                "songs=" + Arrays.toString(songs) +
                '}';
    }
}
