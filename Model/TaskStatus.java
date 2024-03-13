package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum relacionado con el estado de las tareas, que representa los diferentes estados de una tarea
 */
public enum TaskStatus implements Serializable {
    NOT_STARTED(1),
    IN_PROGRESS(2),
    COMPLETED(3);

    private final int value;
    private static final Map<Integer, TaskStatus> map = new HashMap<>();

    static {
        for (TaskStatus status : TaskStatus.values()) {
            map.put(status.value, status);
        }
    }

    TaskStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TaskStatus fromNumber(int number) {
        return map.get(number);
    }
}
