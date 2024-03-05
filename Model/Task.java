package Model;

import Interface.ITask;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task implements ITask, Serializable {
    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private TaskStatus state; // Enumeración TaskStatus
    private User colaboratorToCharge;

    public Task(String id, LocalDate startDate, LocalDate endDate, TaskStatus state, User colaboratorToCharge) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.colaboratorToCharge = colaboratorToCharge;
    }

    public String getId() {
        return this.id;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public TaskStatus getState() {
        return this.state;
    }

    public User getColaboratorToCharge() {
        return this.colaboratorToCharge;
    }
    /**
     * Método para establecer el colaborador asignado a la tarea.
     * @param user Usuario colaborador a asignar.
     */
    public void setColaboratorToCharge(User user) {
        this.colaboratorToCharge = user;
    }

    /**
     * Implementación del método changeStatus de la interfaz ITask.
     * @return true si se cambió el estado correctamente, false en caso contrario.
     */
    @Override
    public boolean changeStatus(int status) {
        boolean statusChanged = false;
        TaskStatus[] statuses = TaskStatus.values();

        if (status >= 0 && status < statuses.length) {
            this.state = statuses[status];
            statusChanged = true;
        }

        return statusChanged;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object) isEquals = true;
        if (object == null || getClass() != object.getClass()) isEquals = false;
        Task task = (Task) object;
        isEquals = Objects.equals(id, task.id) && Objects.equals(startDate, task.startDate) && Objects.equals(endDate, task.endDate) && state == task.state && Objects.equals(colaboratorToCharge, task.colaboratorToCharge);
        return isEquals;
    }

}
