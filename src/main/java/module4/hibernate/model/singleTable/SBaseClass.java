package module4.hibernate.model.singleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
@ToString
public abstract class SBaseClass {
    @Id
    @GeneratedValue
    private UUID id;

    private String baseName;

    private String baseDescription;

    public SBaseClass(final String baseName, final String baseDescription) {
        this.baseName = baseName;
        this.baseDescription = baseDescription;
    }
}
