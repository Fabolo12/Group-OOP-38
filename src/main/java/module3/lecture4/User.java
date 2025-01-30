package module3.lecture4;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private Date updatedAt;

    public User(final int id, final String name) {
        this.id = id;
        this.name = name;
        this.updatedAt = new Date();
    }
}
