import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maximumSongs) {
        if (maximumSongs < 0) throw new IllegalArgumentException("Maximum size cannot be negative");
        songs = new String[maximumSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (song == null || songCount == songs.length) {
            System.out.println("Song could not be added");
            return;
        }
        songs[songCount++] = song;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
