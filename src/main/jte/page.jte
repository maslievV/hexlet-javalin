@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Main Page</title>
</head>
<body>
    <header>
        <ul>
            <li><a href="/">Main Page</a></li>
            <li><a href="/course">Courses</a></li>
            <li><a href="/users">Users</a></li>
            <li><a href="/users/build">Add user</a></li>
            <li><a href="/course/build">Add course</a></li>
        </ul>
    </header>
    ${content}
    <footer><a href="https://github.com/maslievV">MaslievV</a></footer>
</body>
</html>