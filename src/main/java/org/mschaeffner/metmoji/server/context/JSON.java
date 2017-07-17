package org.mschaeffner.metmoji.server.context;

import java.io.Reader;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public class JSON {

	private static final Gson GSON = new Gson();

	public static <T> T fromJson(Reader json, Type typeOfT) {
		return GSON.fromJson(json, typeOfT);
	}

	public static String toJson(Object src) {
		return GSON.toJson(src);
	}

}
