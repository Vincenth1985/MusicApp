package mymusic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Playlist {

    private Song[] songs;
    private String playlistName;


    public Playlist(String playlistName, Song... songs) {
        this.playlistName = playlistName;
        this.songs = songs;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public String getPlaylistName() {
        return playlistName;
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

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
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
                "songs=" + Arrays.asList(songs) +
                '}';
    }
}
