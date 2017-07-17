package org.mschaeffner.metmoji.server.context;

import java.util.List;

import org.mschaeffner.metmoji.server.owm.client.ApiClient;
import org.mschaeffner.metmoji.server.owm.domain.City;
import org.mschaeffner.metmoji.server.owm.domain.Forecast;

import spark.Service;

public class App {

	public App(Service http, CityProvider cityProvider, ApiClient apiClient) {

		http.get("/api/v1/cities", (request, response) -> {
			final String q = request.queryParamOrDefault("q", "");
			final List<City> result = cityProvider.findCompletions(q);
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

			final Forecast result = apiClient.getForecastByCityId(cityId);
			return result;
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
