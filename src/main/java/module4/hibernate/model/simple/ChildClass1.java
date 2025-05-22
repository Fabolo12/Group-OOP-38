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
public class ChildClass1 extends BaseClass {

    private String childName;

    public ChildClass1(final String baseName, final String baseDescription, final String childName) {
        super(baseName, baseDescription);
        this.childName = childName;
    }
}
