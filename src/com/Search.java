package com;

import java.util.Collection;

import com.util.MusicItem;

public class Search {
	private String keyword;
	private Collection<MusicItem> results;
	private String artist;
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Collection<MusicItem> getResults() {
		return results;
	}
	public void setResults(Collection<MusicItem> results) {
		this.results = results;
	}
	
	

}
