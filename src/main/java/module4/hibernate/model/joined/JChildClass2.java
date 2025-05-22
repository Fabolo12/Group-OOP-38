package module4.hibernate.model.joined;

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
public class JChildClass2 extends JBaseClass {
    private String childDescription;

    public JChildClass2(final String baseName, final String baseDescription, final String childDescription) {
        super(baseName, baseDescription);
        this.childDescription = childDescription;
    }
}
