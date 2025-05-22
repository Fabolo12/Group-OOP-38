package module4.hibernate.model.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ChildClass2 extends BaseClass {

    private String childDescription;

    public ChildClass2(final String baseName, final String baseDescription, final String childDescription) {
        super(baseName, baseDescription);
        this.childDescription = childDescription;
    }
}
