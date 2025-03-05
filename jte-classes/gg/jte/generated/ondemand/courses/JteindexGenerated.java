package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,12,12,12,12,13,13,15,15,16,16,18,18,18,19,19,19,21,21,22,22,26,26,26,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n<html lang=\"en\">\n    <head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Hello Hexlet!</title>\n    </head>\n    <body>\n    <div>\n        <main>\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\n            ");
		if (page.getCourses().isEmpty()) {
			jteOutput.writeContent("\n                <p>There is no courses yet</p>\n            ");
		} else {
			jteOutput.writeContent("\n                ");
			for (var course : page.getCourses()) {
				jteOutput.writeContent("\n                    <div>\n                        <h2>");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(course.getName());
				jteOutput.writeContent("</h2>\n                        <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(course.getDescription());
				jteOutput.writeContent("</p>\n                    </div>\n                ");
			}
			jteOutput.writeContent("\n            ");
		}
		jteOutput.writeContent("\n        </main>\n    </div>\n    </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
