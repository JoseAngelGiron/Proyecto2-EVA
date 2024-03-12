package Model.Entity;


import Interface.Model_Interface.IProyect;
import java.util.Iterator;
import java.util.Objects;


public class Proyect extends ElementTrello<Task> implements IProyect {
    private User projectCreator;

    public Proyect(){
        super();

    }
    public Proyect(String name, String id, String description, User projectCreator) {
        super(name, id, description);
        this.projectCreator = projectCreator;
    }


    public Proyect(String id, User user) {
        this.id=id;
        projectCreator = user;
    }

    public User getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(User projectCreator) {
        this.projectCreator = projectCreator;
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Metodo encargado de eliminar una tarea de un proyecto por su ID de tarea
     * @param idTarea el id de la tarea que se va a eliminar
     * @return La tarea que se ha eliminado.
     */
    @Override
    public Task deleteTask(String idTarea) {
        Task task = null;
        Iterator<Task> iterator = getElements().iterator();
        while (iterator.hasNext()) {
            Task tmpTask = iterator.next();
            if (tmpTask.getId().equals(idTarea)) {
                task = tmpTask;
                iterator.remove();
            }
        }
        return task;
    }
    @Override
    public boolean equals(Object o) {
        boolean isEquals = false;
        if (this == o) isEquals = true;
        if (o == null || getClass() != o.getClass()) isEquals = false;
        Proyect proyect = (Proyect) o;
        isEquals = Objects.equals(id, proyect.id) ;
        return isEquals;
    }


    @Override
    public String toString() {
        return " |---------------------------- " +
                "\n | Nombre proyecto:" + name + " |"+ " Nombre del creador : " + projectCreator.getName() +
                "\n |---------------------------|" + " Apodo " + projectCreator.getNickName() +
                "\n | identificador: " + id + "         |"+ " Correo electronico:" + projectCreator.getEmail() +
                "\n |--------------------------------------------------------------- " +
                "\n | descripcion proyecto:" +
                "\n | " + description;

        //Falta el atributo elements pero no lo e puesto
        // por no saber cuanto puede medir
        // elements=" + elements+
    }


}
