package org.mschaeffner.metmoji.server.owm.domain;

public class Sys {

	private final String country;

	private final long sunrise;

	private final long sunset;

	public Sys(String country, long sunrise, long sunset) {
		super();
		this.country = country;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}

	public String getCountry() {
		return country;
	}

	public long getSunrise() {
		return sunrise;
	}

	public long getSunset() {
		return sunset;
	}

}
