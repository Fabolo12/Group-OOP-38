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
public class MChildClass1 extends MBaseClass {
    private String childName;

    public MChildClass1(final String baseName, final String baseDescription, final String childName) {
        super(baseName, baseDescription);
        this.childName = childName;
    }
}
