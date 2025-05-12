package module4.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Embeddable
public class City {
    @Column(name = "city_name")
    private String name;
    @Column(name = "city_country")
    private String country;
}
