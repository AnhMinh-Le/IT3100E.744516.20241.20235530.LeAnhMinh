package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks; 

    
    public String getArtist() {
        return artist;
    }


    public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
        this.tracks = new ArrayList<>();
	}
	

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
        this.tracks = new ArrayList<>();
	}

	public CompactDisc(String title, String category) {
		super(title, category);
        this.tracks = new ArrayList<>();
	}

	public CompactDisc(String title) {
		super(title);
        this.tracks = new ArrayList<>();
	}

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track does not exist in CD.");
        }
    }
    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
}