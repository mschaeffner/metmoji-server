package org.mschaeffner.metmoji.server.context;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mschaeffner.metmoji.server.owm.domain.City;

public class CityProviderTest {

	@Test
	public void testFindCompletionsWithNullValue() {
		final Collection<City> cities = null;
		final CityProvider cityProvider = new CityProvider(cities);

		final String prefix = null;
		final List<City> result = cityProvider.findCompletions(prefix);
		assertThat(result, is(nullValue()));
	}
	
	@Test
	public void testFindCompletionsWithEmptyValue() {
		final Collection<City> cities = null;
		final CityProvider cityProvider = new CityProvider(cities);

		final String prefix = "";
		final List<City> result = cityProvider.findCompletions(prefix);
		assertThat(result, is(nullValue()));
	}

	@Test
	public void testFindCompletionsWithTooShortValue() {
		final Collection<City> cities = null;
		final CityProvider cityProvider = new CityProvider(cities);

		final String prefix = "A";
		final List<City> result = cityProvider.findCompletions(prefix);
		assertThat(result, is(nullValue()));
	}
	
	@Test
	public void testFindCompletions() {
		final Collection<City> cities = new LinkedList<>();
		cities.add(createCity("Doe"));
		cities.add(createCity("Baaa"));
		cities.add(createCity("Booo"));
		cities.add(createCity("Dee"));
		cities.add(createCity("Doa"));
		cities.add(createCity("Duouo"));
		cities.add(createCity("Aaaa"));
		cities.add(createCity("Daaa"));
		cities.add(createCity("Doooo"));
		cities.add(createCity("Eeee"));
		final CityProvider cityProvider = new CityProvider(cities);

		final String prefix = "Do";
		final List<City> result = cityProvider.findCompletions(prefix);
		assertThat(result, hasSize(3));
		assertThat(result.get(0).getName(), is("Doa"));
		assertThat(result.get(1).getName(), is("Doe"));
		assertThat(result.get(2).getName(), is("Doooo"));
	}
	
	private City createCity(String name) {
		return new City(0l, name, null, null);
	}
	
}
