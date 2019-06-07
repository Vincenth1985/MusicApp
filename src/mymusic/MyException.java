package mymusic;

public class MyException extends RuntimeException {
    public MyException() {
        super("This song is not in the playlist");
    }
}
