package org.mschaeffner.metmoji.server.owm.domain;

import com.google.gson.annotations.SerializedName;

public class Rain {

	@SerializedName("3h")
	private final double _3h;

	public Rain(double _3h) {
		this._3h = _3h;
	}

	public double get3h() {
		return _3h;
	}

}
