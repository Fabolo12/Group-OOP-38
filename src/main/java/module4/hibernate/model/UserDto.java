package module4.hibernate.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserDto {
    private UUID id;
    private String email;

    public UserDto(final UUID id, final String email) {
        this.id = id;
        this.email = email;
    }
}
