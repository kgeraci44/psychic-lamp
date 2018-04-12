package test;

public class Greeting {

    private  String title;
    private  String artist;
    private  String album;
    private  String location;

    public Greeting(String title, String artist, String album, String location) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}