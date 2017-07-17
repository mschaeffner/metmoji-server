package org.mschaeffner.metmoji.server.owm.domain;

public class City {

	private final long id;

	private final String name;

	private final Coord coord;

	private final String country;

	public City(long id, String name, Coord coord, String country) {
		super();
		this.id = id;
		this.name = name;
		this.coord = coord;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Coord getCoord() {
		return coord;
	}

	public String getCountry() {
		return country;
	}

}
