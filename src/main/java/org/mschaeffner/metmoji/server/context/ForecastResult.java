package org.mschaeffner.metmoji.server.context;

import java.util.List;

public class ForecastResult {

	private final ForecastResultCurrentWeather currentWeather;

	private final List<ForecastResultItem> forecast;

	public ForecastResult(ForecastResultCurrentWeather currentWeather, List<ForecastResultItem> forecast) {
		this.currentWeather = currentWeather;
		this.forecast = forecast;
	}

	public ForecastResultCurrentWeather getCurrentWeather() {
		return currentWeather;
	}

	public List<ForecastResultItem> getForecast() {
		return forecast;
	}

}
