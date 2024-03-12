package Model.Entity;

import Interface.Model_Interface.ITask;
import Model.TaskStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Task extends ElementTrello<Task> implements ITask, Serializable {

    private LocalDate startDate;
    private LocalDate endDate;
    private TaskStatus state;
    private User[] colaboratorsToCharge;
    private ArrayList<String> feedback;

    public Task() {

    }

    public Task(String name,String id,String description, LocalDate startDate, LocalDate endDate) {
        super(name,id,description);
        setStartDate(startDate);
        setEndDate(endDate);
        state = TaskStatus.NOT_STARTED;
        inicializeColaborators();
        feedback = new ArrayList<>();
    }


    public Task(String codigo) {
        setId(codigo);
        state = TaskStatus.NOT_STARTED;
        startDate = LocalDate.now();
        endDate = LocalDate.now();
        inicializeColaborators();
        feedback = new ArrayList<>();

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

    public boolean setStartDate(LocalDate startDate) {
        boolean assign = false;
        if(startDate.isAfter(endDate)){
            this.startDate = LocalDate.now();

        }else{
            this.startDate = startDate;
            assign = true;
        }
        return assign;
    }

    public boolean setEndDate(LocalDate endDate) {
        boolean assign = false;
        if(startDate.isBefore(endDate)){
            this.endDate = LocalDate.now();
        }else{
            this.endDate = endDate;
            assign = true;
        }
        return assign;
    }

    public void setState(TaskStatus state) {
        this.state = state;
    }

    public User[] getColaboratorsToCharge() {
        return colaboratorsToCharge;
    }

    public void setColaboratorsToCharge(User[] colaboratorsToCharge) {
        this.colaboratorsToCharge = colaboratorsToCharge;
    }

    public ArrayList<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }

    /**
     * Método para establecer el colaborador asignado a la tarea.
     *
     * @param user Usuario colaborador a asignar.
     * @return El colaborador que se asigno. Si no se encuentra, devuelve un colaborador 'null'
     */
    @Override
    public User setColaboratorToCharge(User user) {
        boolean added = false;
        User userToReturn = null;
        for(int i=0;i<colaboratorsToCharge.length && !added;i++){
            if(colaboratorsToCharge[i] ==null){
                colaboratorsToCharge[i]=user;
                added =true;
                userToReturn = colaboratorsToCharge[i];
            }
        }
        return userToReturn;
    }

    /**
     * Metodo encargado de desasignar colaboradores de una tarea
     * @param user el usuario que se va a desasignar
     * @return El colaborador que se desasigno. Si no se encuentra, devuelve un colaborador 'null'
     */
    @Override
    public User unassignColaborator(User user) {
        User tmpUser = null;
        boolean isUnassigned = false;
        for (int i = 0; i < colaboratorsToCharge.length && !isUnassigned; i++) {
            if (colaboratorsToCharge[i].equals(user)){
                tmpUser = colaboratorsToCharge[i];
                colaboratorsToCharge[i] = null;
                isUnassigned = true;
            }
        }
        return tmpUser;

    }



    /**
     * Este metodo cambia el estado de la tarea en función del número que se le pasa. Siendo 1, NOT_STARTED, 2 IN_PROGRESS
     * 3, COMPLETED
     * @param status que será un número que se correspondera con un estado en concreto
     * @return true, si se cambio el estado correctamente, o false, si no fue así
     */
    @Override
    public boolean changeStatus(int status) {
        boolean statusChanged = false;
        TaskStatus newStatus = TaskStatus.fromNumber(status);
        if (newStatus != null) {
            state = newStatus;
            statusChanged =true;
        }

        return statusChanged;
    }

    /**
     * Metodo que se encarga de añadir un comentario a la lista de comentarios que tiene una tarea
     * @param comentary el dato que introduce el usuario para que sea añadido
     */
    @Override
    public void addComentary(String comentary){
        feedback.add(comentary);
    }


    private void inicializeColaborators() {
        colaboratorsToCharge = new User[3];
        for (int i =0;i<colaboratorsToCharge.length;i++){
            colaboratorsToCharge[i] = new User();
        }
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
                "\n | identificador: " + id + "                       |" + " Colaboradores:  " +
                "\n | Estado de la tarea: " + state + "        |" + " Nombre: " + colaboratorsToCharge[0].getName() + colaboratorsToCharge[1].getName() + colaboratorsToCharge[2].getName()+
                "\n | Inicio de la tarea: " + startDate.getDayOfMonth() + "/" + startDate.getMonthValue() + "/" + startDate.getYear() + "         |" + " apodo: " + colaboratorsToCharge[0].getNickName() + colaboratorsToCharge[1].getNickName() +colaboratorsToCharge[2].getNickName()+
                "\n | Final de la tarea: " + endDate.getDayOfMonth() + "/" + endDate.getMonthValue() + "/" + endDate.getYear() + "          |"    + " Correo electronico:" + colaboratorsToCharge[0].getEmail() + colaboratorsToCharge[1].getEmail()+colaboratorsToCharge[2].getEmail()+
                "\n ----------------------------------------------------------------------------------- ";
    }
}
