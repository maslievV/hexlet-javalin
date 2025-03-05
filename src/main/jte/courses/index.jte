@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
    </head>
    <body>
    @template.page(
        content = @`
        @if(page.getCourses().isEmpty())
            <p>There is no courses yet</p>
        @else
            @for(var course : page.getCourses())
                <div>
                    <h2>${course.getName()}</h2>
                    <p>${course.getDescription()}</p>
                </div>
            @endfor
        @endif
        <form action="/course" method="get">
            <input type="search" required name="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </form>
        `
    )
    </body>
</html>