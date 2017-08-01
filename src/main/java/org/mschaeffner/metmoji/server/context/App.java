package org.mschaeffner.metmoji.server.context;

import java.util.List;
import java.util.stream.Collectors;

import org.mschaeffner.metmoji.server.owm.client.ApiClient;
import org.mschaeffner.metmoji.server.owm.domain.CurrentWeather;
import org.mschaeffner.metmoji.server.owm.domain.Forecast;

import spark.Service;

public class App {

	public App(Service http, CityProvider cityProvider, ApiClient apiClient) {

		http.get("/api/v1/cities", (request, response) -> {
			final String q = request.queryParamOrDefault("q", "");
			final List<CityResult> result = cityProvider.findCompletions(q) //
					.stream() //
					.map(x -> new CityResult(x.getId(), x.getName(), x.getCountry())) //
					.collect(Collectors.toList());
			return result;
		}, JSON::toJson);

		http.get("/api/v1/forecasts/:cityId", (request, response) -> {
			final String cityIdParam = request.params("cityId");
			final long cityId;

			try {
				cityId = new Long(cityIdParam).longValue();
			} catch (NumberFormatException e) {
				// TODO better logging
				e.printStackTrace();
				return null;
			}

			final Forecast forecastData = apiClient.getForecastByCityId(cityId);
			final CurrentWeather currentData = apiClient.getCurrentWeatherByCityId(cityId);

			final List<ForecastResultItem> forecast = forecastData.getList() //
					.stream() //
					.map(x -> new ForecastResultItem(x.getDt(), //
							x.getWeather().get(0).getIcon(), //
							x.getWeather().get(0).getDescription(), //
							x.getMain().getTemp_min(), //
							x.getMain().getTemp_max() //
			)) //
					.collect(Collectors.toList());

			final ForecastResultCurrentWeather currentWeather = new ForecastResultCurrentWeather(currentData.getDt(),
					currentData.getWeather().get(0).getIcon(), currentData.getWeather().get(0).getDescription(),
					currentData.getMain().getTemp());

			return new ForecastResult(currentWeather, forecast);
		}, JSON::toJson);

		enableCors(http);
	}

	private void enableCors(Service http) {
		http.options("/*", (request, response) -> {

			final String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			}

			final String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if (accessControlRequestMethod != null) {
				response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			}

			return "OK";
		});

		http.before((request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Request-Method", "*");
			response.header("Access-Control-Allow-Headers", "*");
			response.type("application/json");
		});
	}

}
