package co.edu.udea.compumovil.ahorcatooth.webservices.restful.impl;

abstract class AbstractWSContext {

	private static final String AMPERSAND = "&";
	private static final String SLASH = "/";
	private static final String EQUAL = "=";

	public static final String CONTENT_TYPE_KEY = "content-type";
	public static final String CONTENT_TYPE_VALUE = "application/json";

	public AbstractWSContext() {
	}
}