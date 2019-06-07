package mymusic;


public class Song {

    private String titel;
    private String artiest;
    private String album;
    private String speelduur;

    public Song(String titel, String artiest, String album, String speelduur) {
        this.titel = titel;
        this.artiest = artiest;
        this.album = album;
        this.speelduur = speelduur;
    }

    public Song() {

    }


    public String getTitel() {
        return this.titel;
    }

    public String getArtiest() {
        return this.artiest;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getSpeelduur() {
        return speelduur;
    }


    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setArtiest(String artiest) {
        this.artiest = artiest;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setSpeelduur(String speelduur) {
        this.speelduur = speelduur;
    }

    @Override
    public String toString() {
        return String.format("%-20s\t%10s\t%6s\t%6s ",getAlbum(), getArtiest(), getSpeelduur(), getTitel());
    }


}
