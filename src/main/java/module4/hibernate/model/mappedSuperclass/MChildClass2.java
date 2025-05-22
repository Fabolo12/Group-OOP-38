package module4.hibernate.model.mappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class MChildClass2 extends MBaseClass {
    private String childDescription;

    public MChildClass2(final String baseName, final String baseDescription, final String childDescription) {
        super(baseName, baseDescription);
        this.childDescription = childDescription;
    }
}
