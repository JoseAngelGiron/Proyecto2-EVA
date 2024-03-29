package Model.Entity;

import Interface.Model_Interface.ITask;
import Model.TaskStatus;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Task extends ElementTrello<Task> implements ITask, Serializable {
    private LocalDate startDate;
    private LocalDate endDate;
    private TaskStatus state;
    private User[] colaboratorsToCharge;
    private ArrayList<String> feedback;

    public Task() {
        super();

    }

    public Task(String name,String id,String description, LocalDate startDate, LocalDate endDate) {
        super(name,id,description);
        setStartDate(startDate);
        setEndDate(endDate);
        state = TaskStatus.NOT_STARTED;
        inicializeColaborators();
        feedback = new ArrayList<>();
        checkDates();
    }

    public Task(String codigo) {
        super("",codigo,"");
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

    /**
     * Setter modificado para verificar que la fecha de inicio no es posterior a la fecha actual
     * @param startDate una fecha que establecer como fecha de incio
     * @return true si se consiguio establecer la fecha correctamente, o false si no fue así
     * y se establecio la fecha actual como fecha de inicio
     */
    public boolean setStartDate(LocalDate startDate) {
        boolean assign = false;
        if(startDate.isBefore(LocalDate.now())){
            this.startDate = LocalDate.now();
        }else{
            this.startDate = startDate;
            assign = true;
        }
        return assign;
    }

    /**
     * setter modificado para comprobar si la fecha de fin es anterior a la fecha actual y ademas, comprueba si es anterior
     * a la fecha inicio usando el metodo "checkDates"
     * @param endDate que será la fecha que se va a asignar
     * @return la true si se asigno la fecha correctamente, o false si se asigno la fecha actual
     */
    public boolean setEndDate(LocalDate endDate) {
        boolean assign = false;
        if(endDate.isBefore(LocalDate.now())){
            this.endDate = LocalDate.now();
        }else{
            this.endDate = endDate;
            assign = true;
        }
        checkDates();
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
            if(colaboratorsToCharge[i].getName().equalsIgnoreCase("SinNick")
            || colaboratorsToCharge[i].getEmail().equalsIgnoreCase("example@gmail.com")){
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
                colaboratorsToCharge[i] = new User();
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

    /**
     * Función encargada a iniciar la lista de colaboradores con usuarios por defecto, de forma que se muestre
     * sin datos en primer lugar.
     */
    private void inicializeColaborators() {
        colaboratorsToCharge = new User[3];
        for (int i =0;i<colaboratorsToCharge.length;i++){
            colaboratorsToCharge[i] = new User();
        }
    }

    /**
     * Función que se encarga de comprobar si la fecha de inicio es posterior a la de fin.
     * En tal caso, asigna la fecha actual
     */
    private void checkDates() {
        if(startDate.isAfter(endDate)){
            startDate = LocalDate.now();
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
        return String.format(" -------------------------------------------------------------------------------------------------------------------------------------------------------------------- " +
                "\n | identificador: %-30s | Nombre: " + name + "Colaboradores:  " +
                "\n | Estado de la tarea: %-25s | Nombre: " + colaboratorsToCharge[0].getName() +" "+ colaboratorsToCharge[1].getName() +" "+ colaboratorsToCharge[2].getName()+
                "\n | Inicio de la tarea: %d/%d/%-19d |" + " apodo: " + colaboratorsToCharge[0].getNickName() +" "+ colaboratorsToCharge[1].getNickName() +" "+colaboratorsToCharge[2].getNickName()+
                "\n | Final de la tarea: %d/%d/%-20d | Correo electronico:" + colaboratorsToCharge[0].getEmail() +" "+ colaboratorsToCharge[1].getEmail()+" "+colaboratorsToCharge[2].getEmail()+
                "\n ------------------------------------------------------------------------------------------------------------------------------------------------------- ",
                id, state,
                startDate.getDayOfMonth(),startDate.getMonthValue(),startDate.getYear(),
                endDate.getDayOfMonth(), endDate.getMonthValue(), endDate.getYear());
    }
}
