package org.mschaeffner.metmoji.server.context;

public class CityResult {

	private final long id;

	private final String name;

	private final String country;

	public CityResult(long id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

}
