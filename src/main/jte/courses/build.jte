@import org.example.hexlet.dto.courses.BuildCoursePage;
@param BuildCoursePage page

@template.page(
    content = @`
    <ul>
        @if(page.getErrors() != null)
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        @endif
    </ul>
    <form action="/course" method="post">
        <div>
            <label>
                Name:
                <input type="text" name="name">
            </label>
        </div>
        <div>
            <label>
                Description:
                <input type="text" name="description">
            </label>
        </div>
        <input type="submit" value="Add course">
    </form>
    `
)
