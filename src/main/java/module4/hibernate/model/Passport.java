package module4.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
public class Passport {
    @Id
    @GeneratedValue
    public UUID id;

    @OneToOne(mappedBy = "passportField")
    private User user;

    public void setUser(final User user) {
        this.user = user;
        if (user.getPassportField() == null) {
            this.user.setPassport(this);
        }
    }
}
