package module4.lecture8.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SoftDelete(columnName = "active2", strategy = SoftDeleteType.ACTIVE)
public class Client {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String address;
    private int age;
    private boolean active;
}
