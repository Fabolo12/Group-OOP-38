package module4.hibernate.model.tablePerClass;

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
public class TChildClass2 extends TBaseClass {
    private String childDescription;

    public TChildClass2(final String baseName, final String baseDescription, final String childDescription) {
        super(baseName, baseDescription);
        this.childDescription = childDescription;
    }
}
