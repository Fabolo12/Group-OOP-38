package module4.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDate modifiedAt;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    private Boolean premium;

    @Embedded
    private City city;

    private LocalTime time;

    private LocalDate date;

    private LocalDateTime dateTime;

    @PrePersist
    public void prePersist() {
        if (age == 0) {
            age = 18;
        }
    }
}
