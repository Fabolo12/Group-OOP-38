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
public class TChildClass1 extends TBaseClass {
    private String childName;

    public TChildClass1(final String baseName, final String baseDescription, final String childName) {
        super(baseName, baseDescription);
        this.childName = childName;
    }
}
