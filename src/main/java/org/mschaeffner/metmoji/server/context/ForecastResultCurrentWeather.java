package org.mschaeffner.metmoji.server.context;

public class ForecastResultCurrentWeather {

	private final long dt;

	private final String icon;

	private final String description;

	private final double temp;

	public ForecastResultCurrentWeather(long dt, String icon, String description, double temp) {
		this.dt = dt;
		this.icon = icon;
		this.description = description;
		this.temp = temp;
	}

	public long getDt() {
		return dt;
	}

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public double getTemp() {
		return temp;
	}

}
