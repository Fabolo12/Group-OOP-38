package module3.lecture8.todo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private UUID id;
    private String title;
    private String description;
    private boolean done;
}
