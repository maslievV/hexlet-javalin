package gg.jte.generated.ondemand;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,19,19,19,19,22,22,22,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\"\n          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n    <title>Main Page</title>\n</head>\n<body>\n    <header>\n        <ul>\n            <li><a href=\"/\">Main Page</a></li>\n            <li><a href=\"/course\">Courses</a></li>\n        </ul>\n    </header>\n    ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n    <footer><a href=\"https://github.com/maslievV\">MaslievV</a></footer>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
