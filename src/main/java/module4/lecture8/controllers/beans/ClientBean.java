package module4.lecture8.controllers.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ClientBean {
    private UUID id;
    private String name;
    private String address;
    private Integer age;
}
