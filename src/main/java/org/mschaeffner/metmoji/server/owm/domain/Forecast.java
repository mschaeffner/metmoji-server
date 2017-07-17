package org.mschaeffner.metmoji.server.owm.domain;

import java.util.List;

public class Forecast {

	private final City city;

	private final List<CurrentWeather> list;

	public Forecast(City city, List<CurrentWeather> list) {
		this.city = city;
		this.list = list;
	}

	public City getCity() {
		return city;
	}

	public List<CurrentWeather> getList() {
		return list;
	}

}
