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
public class JChildClass1 extends JBaseClass {
    private String childName;

    public JChildClass1(final String baseName, final String baseDescription, final String childName) {
        super(baseName, baseDescription);
        this.childName = childName;
    }
}
