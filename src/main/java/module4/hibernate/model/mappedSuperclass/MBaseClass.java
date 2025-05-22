package module4.hibernate.model.mappedSuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@ToString
public abstract class MBaseClass {
    @Id
    @GeneratedValue
    private UUID id;

    private String baseName;

    private String baseDescription;

    public MBaseClass(final String baseName, final String baseDescription) {
        this.baseName = baseName;
        this.baseDescription = baseDescription;
    }
}
