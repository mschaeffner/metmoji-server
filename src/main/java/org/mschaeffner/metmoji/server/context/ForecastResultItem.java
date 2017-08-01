package org.mschaeffner.metmoji.server.context;

public class ForecastResultItem {

	private final long dt;

	private final String icon;

	private final String description;

	private final double minTemp;

	private final double maxTemp;

	public ForecastResultItem(long dt, String icon, String description, double minTemp, double maxTemp) {
		this.dt = dt;
		this.icon = icon;
		this.description = description;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public long getDt() {
		return dt;
	}

	public String getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

}
