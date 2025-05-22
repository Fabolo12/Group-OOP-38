package module4.hibernate.model.singleTable;

import jakarta.persistence.DiscriminatorValue;
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
@DiscriminatorValue("child_1")
public class SChildClass1 extends SBaseClass {
    private String childName;

    public SChildClass1(final String baseName, final String baseDescription, final String childName) {
        super(baseName, baseDescription);
        this.childName = childName;
    }
}
