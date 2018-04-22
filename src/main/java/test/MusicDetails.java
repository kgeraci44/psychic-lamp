package test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MusicDetails {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer idmusic_details;
	 
	 private String title;
	 private Integer artist;
	 private String location;
	 
	public Integer getIdmusic_details() {
		return idmusic_details;
	}
	public void setIdmusic_details(Integer idmusic_details) {
		this.idmusic_details = idmusic_details;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getArtist() {
		return artist;
	}
	public void setArtist(Integer artist) {
		this.artist = artist;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 
	 
}
