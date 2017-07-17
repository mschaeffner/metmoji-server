package org.mschaeffner.metmoji.server.context;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.mschaeffner.metmoji.server.owm.client.ApiClient;
import org.mschaeffner.metmoji.server.owm.domain.City;

import com.google.gson.reflect.TypeToken;

import spark.Service;
import spark.resource.ClassPathResource;
import spark.resource.Resource;

public class Main {

	private static final String OPENWEATHERMAP_API_KEY = "openweathermapApiKey";

	private static final String APP_PROPERTIES_FILENAME = "app.properties";

	private static final String CITY_LIST_FILENAME = "city.list.json";

	public static void main(String[] args) throws IOException {

		final Properties props = getAppProperties();
		final String openweathermapApiKey = props.getProperty(OPENWEATHERMAP_API_KEY);

		final CityProvider cityProvider = createCityProvider();
		final ApiClient apiClient = new ApiClient(openweathermapApiKey);
		final Service http = Service.ignite();
		http.port(5000);

		new App(http, cityProvider, apiClient);
	}

	private static Properties getAppProperties() throws IOException {
		final Resource resource = new ClassPathResource(APP_PROPERTIES_FILENAME);
		final Properties result = new Properties();
		result.load(resource.getInputStream());
		return result;
	}

	private static CityProvider createCityProvider() throws IOException {
		final Resource cityListResource = new ClassPathResource(CITY_LIST_FILENAME);
		final Reader reader = new InputStreamReader(cityListResource.getInputStream());

		final Type type = new TypeToken<List<City>>() {
		}.getType();

		final Collection<City> cities = JSON.fromJson(reader, type);
		final CityProvider result = new CityProvider(cities);
		return result;
	}

}
