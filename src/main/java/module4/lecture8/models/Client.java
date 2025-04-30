package module4.lecture8.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Client {
    private UUID id;
    private String name;
    private String address;
    private int age;
    private boolean active;
}
