@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Course</title>
</head>
<body>
    @template.page(content = @`
        <h2>${page.getCourse().getName()}</h2>
        <p>${page.getCourse().getDescription()}</p>
    `)
</body>
</html>