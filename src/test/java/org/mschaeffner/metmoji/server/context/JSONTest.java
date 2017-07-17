package org.mschaeffner.metmoji.server.context;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;
import org.mschaeffner.metmoji.server.owm.domain.City;
import org.mschaeffner.metmoji.server.owm.domain.Coord;

public class JSONTest {

	@Test
	public void testFromJson() {
		final String json = "{\"id\":123,\"name\":\"Berlin\",\"coord\":{\"lat\":123.456,\"lon\":-789.012},\"country\":\"DE\"}";

		final Reader reader = new InputStreamReader(new ByteArrayInputStream(json.getBytes()));
		final City city = JSON.fromJson(reader, City.class);

		assertThat(city.getId(), is(123l));
		assertThat(city.getName(), is("Berlin"));
		assertThat(city.getCountry(), is("DE"));
		assertThat(city.getCoord().getLat(), is(123.456));
		assertThat(city.getCoord().getLon(), is(-789.012));
	}

	@Test
	public void testToJson() {
		final String expectedJson = "{\"id\":123,\"name\":\"Berlin\",\"coord\":{\"lat\":123.456,\"lon\":-789.012},\"country\":\"DE\"}";

		final Coord coord = new Coord(123.456, -789.012);
		final City city = new City(123l, "Berlin", coord, "DE");
		final String result = JSON.toJson(city);

		assertThat(result, is(expectedJson));
	}

}
