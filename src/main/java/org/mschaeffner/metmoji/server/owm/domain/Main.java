package org.mschaeffner.metmoji.server.owm.domain;

public class Main {

	private final double temp;

	private final double pressure;

	private final int humidity;

	private final double temp_min;

	private final double temp_max;

	private final double sea_level;

	private final double grnd_level;

	public Main(double temp, double pressure, int humidity, double temp_min, double temp_max, double sea_level,
			double grnd_level) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.sea_level = sea_level;
		this.grnd_level = grnd_level;
	}

	public double getTemp() {
		return temp;
	}

	public double getPressure() {
		return pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public double getSea_level() {
		return sea_level;
	}

	public double getGrnd_level() {
		return grnd_level;
	}

}
