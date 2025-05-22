package module4.hibernate.model.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class BaseClass {
    @Id
    @GeneratedValue
    private UUID id;

    private String baseName;

    private String baseDescription;

    public BaseClass(final String baseName, final String baseDescription) {
        this.baseName = baseName;
        this.baseDescription = baseDescription;
    }
}
