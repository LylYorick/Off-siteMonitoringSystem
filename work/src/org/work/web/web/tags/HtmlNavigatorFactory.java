package org.work.web.web.tags;

public abstract class HtmlNavigatorFactory {
	public static final String CLASSICAL = "classical";
	public static final String GOOGLE = "google";
	public static final String IMAGE = "image";

	public static HtmlNavigator getInstance(String style) {
		if (style == null || style.trim().length() == 0 || CLASSICAL.equalsIgnoreCase(style)) {
			return new ClassicalHtmlNavigator();
		}
		else if (GOOGLE.equalsIgnoreCase(style)) {
			return new GoogleHtmlNavigator();
		}
		else if (IMAGE.equalsIgnoreCase(style)) {
			return new ImageHtmlNavigator();
		}
		else {
			return new ClassicalHtmlNavigator();
		}
	}
}
