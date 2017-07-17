package org.mschaeffner.metmoji.server.owm.domain;

import java.util.List;

public class CurrentWeather {

	private final Coord coord;

	private final List<Weather> weather;

	private final String base;

	private final Main main;

	private final Wind wind;

	private final Rain rain;

	private final Clouds clouds;

	private final long dt;

	private final Sys sys;

	private final long id;

	private final String name;

	public CurrentWeather(Coord coord, List<Weather> weather, String base, Main main, Wind wind, Rain rain,
			Clouds clouds, long dt, Sys sys, long id, String name) {
		this.coord = coord;
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.wind = wind;
		this.rain = rain;
		this.clouds = clouds;
		this.dt = dt;
		this.sys = sys;
		this.id = id;
		this.name = name;
	}

	public Coord getCoord() {
		return coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public String getBase() {
		return base;
	}

	public Main getMain() {
		return main;
	}

	public Wind getWind() {
		return wind;
	}

	public Rain getRain() {
		return rain;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public long getDt() {
		return dt;
	}

	public Sys getSys() {
		return sys;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
