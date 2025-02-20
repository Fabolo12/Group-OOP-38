package module3.lecture8.todo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskGetter {
    public List<Task> get(final String id, final Map<UUID, Task> taskMap) {
        if (id == null) {
            return taskMap.values().stream().toList();
        }
        return List.of(taskMap.get(UUID.fromString(id)));
    }
}
