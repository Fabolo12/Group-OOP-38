package module4.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.time.LocalDate;
import java.util.UUID;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(
                name = "getByEmail",
                query = "from User where email = :email"
        )
})
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, name = "user_age")
    private int age;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "modified_at")
    private LocalDate modifiedAt;
}
