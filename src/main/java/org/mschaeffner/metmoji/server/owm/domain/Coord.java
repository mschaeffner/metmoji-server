package org.mschaeffner.metmoji.server.owm.domain;

public class Coord {

	private final double lat;

	private final double lon;

	public Coord(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

}
