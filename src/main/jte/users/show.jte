@import org.example.hexlet.repository.UserRepository
@param UserRepository us

@template.page(
    content = @`
    @for(var user : UserRepository.getEntities())
        <h3>${user.getUsername()} ${user.getEmail()}</h3>
    @endfor
    `
)