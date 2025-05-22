package module4.hibernate.model.tablePerClass;

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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
public abstract class TBaseClass {
    @Id
    @GeneratedValue
    private UUID id;

    private String baseName;

    private String baseDescription;

    public TBaseClass(final String baseName, final String baseDescription) {
        this.baseName = baseName;
        this.baseDescription = baseDescription;
    }
}
