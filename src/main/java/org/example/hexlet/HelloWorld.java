package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.text.StringEscapeUtils;

public class HelloWorld {

    public static List<Course> COURSES = new ArrayList<>(
            List.of(
            new Course("You are gonna be Php dev", "Php-DEV", 1L),
            new Course("You are gonna be Java dev", "Java-DEV", 2L),
            new Course("You are gonna be Python dev", "Python-DEV", 3L)
            )
    );

    public static void main(String[] args) {
        var app = getApp();
        app.start(7070);
    }

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/course", ctx -> {
            var term = ctx.queryParam("term");
            List<Course> courses;
            if (term != null) {
                courses = COURSES.stream()
                        .filter(c -> c.getName().startsWith(term))
                        .toList();
            } else {
                courses = COURSES;
            }
            var page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/course/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var escapedId = StringEscapeUtils.escapeHtml4(String.valueOf(id));
            var course = COURSES.stream()
                    .filter(c -> c.getId().equals(Long.valueOf(escapedId)))
                    .findFirst().orElseThrow();
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        return app;
    }
}
