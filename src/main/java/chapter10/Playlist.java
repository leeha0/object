package chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {

    private List<Song> tracks = new ArrayList<>();
    // 가수별 노래 제목 관리 요구사항 추가
    private Map<String, String> singers = new HashMap<>();

    public void append(Song song) {
        getTracks().add(song);
        singers.put(song.getSinger(), song.getTitle());
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSingers() {
        return singers;
    }
}
