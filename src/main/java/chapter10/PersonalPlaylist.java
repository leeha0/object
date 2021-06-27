package chapter10;

public class PersonalPlaylist extends Playlist {

    public void remove(Song song) {
        getTracks().remove(song);
        // 부모 클래스의 변경사항에 맞춰 자식 클래스도 변경해야 한다.
        getSingers().remove(song.getSinger());
    }
}
