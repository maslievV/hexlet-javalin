@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<html lang="en">
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
    </head>
    <body>
    <div>
        <main>
        <h1>${page.getHeader()}</h1>
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
        </main>
    </div>
    </body>
</html>