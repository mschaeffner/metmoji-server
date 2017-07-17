package org.mschaeffner.metmoji.server.context;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.mschaeffner.metmoji.server.owm.domain.City;

public class CityProvider {

	private static final int MIN_PREFIX_FOR_COMPLETION = 2;

	private final TreeSet<City> cities;

	public CityProvider(Collection<City> cities) {
		this.cities = new TreeSet<City>(new Comparator<City>() {
			@Override
			public int compare(City city1, City city2) {
				return city1.getName().compareToIgnoreCase(city2.getName());
			}
		});

		if (cities != null) {
			this.cities.addAll(cities);
		}
	}

	public List<City> findCompletions(String prefix) {
		if (prefix == null) {
			// TODO throw an exception
			return null;
		}

		final String cleanPrefix = prefix.trim();
		if (cleanPrefix.length() < MIN_PREFIX_FOR_COMPLETION) {
			// TODO throw an exception
			return null;
		}

		final List<City> result = new LinkedList<>();
		final City prefixCity = new City(0l, cleanPrefix, null, null);
		final SortedSet<City> tailSet = cities.tailSet(prefixCity);
		for (City city : tailSet) {
			if (city.getName().startsWith(cleanPrefix)) {
				result.add(city);
			} else {
				break;
			}
		}

		return result;
	}

}
