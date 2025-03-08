package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.User;
import org.example.hexlet.model.Course;
import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

public class HelloWorld {

    private static final List<Course> COURSES = CourseRepository.getEntities();

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
        app.get("/course/build", ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });

        app.get("/course/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var escapedId = StringEscapeUtils.escapeHtml4(String.valueOf(id));
            var course = COURSES.stream()
                    .filter(c -> c.getId().equals(Long.valueOf(escapedId)))
                    .findFirst()
                    .orElseThrow();
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.post("/course", ctx -> {
           String name = "";
           String description = "";
           try {
               name = ctx.formParamAsClass("name", String.class)
                       .check(value -> value.length() > 2,
                               "The name should be longer than 2 characters")
                       .get();
               description = ctx.formParamAsClass("description", String.class)
                       .check(value -> value.length() > 10,
                               "The description should be more than 10 characters")
                       .get();
               var course = new Course(name, description);
               CourseRepository.save(course);
               ctx.redirect("/course");
           } catch (ValidationException ex) {
                var page = new BuildCoursePage(name, description, ex.getErrors());
                ctx.render("courses/build.jte", model("page", page));
           }
        });

        app.get("/users/build", ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.post("/users", ctx ->{
            var username = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            try {
                var confirmedPassword = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(p -> p.equals(confirmedPassword), "Password are not hte same")
                        .get();
                var user = new User(username, email, password);
                UserRepository.save(user);
                ctx.redirect("/users");
            } catch (ValidationException ex) {
                var page = new BuildUserPage(username, email, ex.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });

        app.get("/users", ctx -> {
            ctx.render("users/show.jte");
        });

        return app;
    }
}
