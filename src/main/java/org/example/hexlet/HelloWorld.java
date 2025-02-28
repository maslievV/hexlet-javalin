package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = getApp();
        app.start(7070);
    }

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users/{user_id}/post/{post_id}", ctx -> {
            var userId = ctx.pathParam("user_id");
            var postId = ctx.pathParam("post_id");
            ctx.result("User: " + userId + "; Post: " + postId);
        });
        return app;
    }
}
