package com.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Episode {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long EpisodeId;
	private String name;
	private String descript;
	private String airdate;
	private String elenght;
	private String views;

	public Episode() {
}

public Episode(String name, String descript, String airdate, String elenght, String views) {
	super();
	this.name = name;
	this.descript = descript;
	this.airdate = airdate;
	this.elenght = elenght;
	this.views = views;
}





public Long getEpisodeId() {
	return EpisodeId;
}

public void setEpisodeId(Long episodeId) {
	EpisodeId = episodeId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescript() {
	return descript;
}

public void setDescript(String descript) {
	this.descript = descript;
}

public String getAirdate() {
	return airdate;
}

public void setAirdate(String airdate) {
	this.airdate = airdate;
}

public String getElenght() {
	return elenght;
}

public void setElenght(String elenght) {
	this.elenght = elenght;
}

public String getViews() {
	return views;
}

public void setViews(String views) {
	this.views = views;
}


}





