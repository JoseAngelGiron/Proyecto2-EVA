package Model;

import Interface.ITask;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Task extends ElementTrello<Task> implements ITask, Serializable {

    private LocalDate startDate;
    private LocalDate endDate;
    private TaskStatus state;
    private User[] colaboratorsToCharge;
    private String[] feedback;

    public Task() {

    }

    public Task(String id, LocalDate startDate, LocalDate endDate, TaskStatus state) {
        setId(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.colaboratorsToCharge = new User[3];
    }

    public Task(String codigo) {
        setId(codigo);

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

    public User[] getColaboratorToCharge() {
        return this.colaboratorsToCharge;
    }

    /**
     * Método para establecer el colaborador asignado a la tarea.
     *
     * @param user Usuario colaborador a asignar.
     * @return true, si se añade el colaborador o false, si no se añade
     */
    public boolean setColaboratorToCharge(User user) {
        this.colaboratorsToCharge = new User[]{user};
        return false;
    }
    //ESTO PARA CAMBIARLO
    /**
     * Implementación del método changeStatus de la interfaz ITask.
     *
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
        isEquals = Objects.equals(id, task.id) ;
        return isEquals;
    }

    @Override
    public String toString() {
        return " ------------------------------------------------------------------------------------- " +
                "\n | identificador: " + id + "                       |" + " Colaboradores: " +
                "\n | Estado de la tarea: " + state + "        |" + " Nombre: " + colaboratorsToCharge[0].getName() +
                "\n | Inicio de la tarea: " + startDate.getDayOfMonth() + "/" + startDate.getMonthValue() + "/" + startDate.getYear() + "         |" + " apodo " + colaboratorsToCharge[0].getNickName() +
                "\n | Final de la tarea: " + endDate.getDayOfMonth() + "/" + endDate.getMonthValue() + "/" + endDate.getYear() + "          |"    + " Correo electronico:" + colaboratorsToCharge[0].getEmail() +
                "\n ----------------------------------------------------------------------------------- ";
    }
}
