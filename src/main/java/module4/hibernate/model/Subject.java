package module4.hibernate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@ToString
@Getter
@Setter
@Entity
public class Subject {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> users;
}
