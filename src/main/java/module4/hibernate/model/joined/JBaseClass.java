package module4.hibernate.model.joined;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
public abstract class JBaseClass {
    @Id
    @GeneratedValue
    private UUID id;

    private String baseName;

    private String baseDescription;

    public JBaseClass(final String baseName, final String baseDescription) {
        this.baseName = baseName;
        this.baseDescription = baseDescription;
    }
}
