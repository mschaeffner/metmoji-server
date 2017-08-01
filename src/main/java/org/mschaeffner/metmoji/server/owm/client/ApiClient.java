package org.mschaeffner.metmoji.server.owm.client;

import org.mschaeffner.metmoji.server.owm.domain.CurrentWeather;
import org.mschaeffner.metmoji.server.owm.domain.Forecast;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiClient {

	private final String apiKey;

	public ApiClient(String apiKey) {
		this.apiKey = apiKey;

		Unirest.setObjectMapper(new ObjectMapper() {
			final Gson gson = new Gson();

			public <T> T readValue(String value, Class<T> valueType) {
				return gson.fromJson(value, valueType);
			}

			public String writeValue(Object value) {
				return gson.toJson(value);
			}

		});
	}

	public CurrentWeather getCurrentWeatherByCityId(long cityId) throws UnirestException {
		final HttpResponse<CurrentWeather> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather")
				.queryString("APPID", apiKey) //
				.queryString("id", cityId) //
				.queryString("units", "metric") //
				.asObject(CurrentWeather.class);
		final CurrentWeather result = response.getBody();
		return result;
	}

	public Forecast getForecastByCityId(long cityId) throws UnirestException {
		final HttpResponse<Forecast> response = Unirest.get("http://api.openweathermap.org/data/2.5/forecast")
				.queryString("APPID", apiKey) //
				.queryString("id", cityId) //
				.queryString("units", "metric") //
				.asObject(Forecast.class);
		final Forecast result = response.getBody();
		return result;
	}

}
