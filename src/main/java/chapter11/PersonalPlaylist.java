package chapter11;

import chapter10.Playlist;
import chapter10.Song;

public class PersonalPlaylist {

    private Playlist playlist = new Playlist();

    public void append(Song song) {
        playlist.append(song);
    }

    public void remove(Song song) {
        playlist.getTracks().remove(song);
        playlist.getSingers().remove(song.getSinger());
    }
}
