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
@DiscriminatorValue("child_2")
public class SChildClass2 extends SBaseClass {
    private String childDescription;

    public SChildClass2(final String baseName, final String baseDescription, final String childDescription) {
        super(baseName, baseDescription);
        this.childDescription = childDescription;
    }
}
