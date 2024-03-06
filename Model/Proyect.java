package Model;


import Interface.IProyect;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Proyect extends ElementTrello<Task> implements IProyect {
    User projectCreator;

    public Proyect(){
        super();

    }
    public Proyect(String name, String id, String description, User projectCreator) {
        super(name, id, description, new ArrayList<>());
        this.projectCreator = projectCreator;
    }
    public Proyect(String id){
    }

    public Proyect(String codigo, User user) {
        setId(id);
        projectCreator = user;
    }

    @Override
    public void setId(String nombre) {
        super.setId("P - "+nombre);
    }


    @Override
    public boolean equals(Object o) {
        boolean equal = this == o;
        if (o == null || getClass() != o.getClass()) {
            equal = false;
        }
        Proyect proyect2 = (Proyect) o;
        if(super.id.equals(proyect2.id)) {
            equal = true;
        }
        return equal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), projectCreator);
    }


    }

    /**
     * Metodo para eliminar un ususuario como colaborador de una tarea
     * @param idTarea Es la tarea que se va a sellecionar
     * @param user Es el usuario que se va a asignar como colaborador
     * @return Devolveria la eliminacion de usuario colaborador de la tarea
     */
    @Override
    public boolean unassingCollaborator(Proyect proyect, String idTarea, User user) {
        boolean isUnassigned = false;
        for (int i = 0; i < proyect.elements.size() && !isUnassigned; i++) {
            if (elements.get(i).id.equals(idTarea)) {
                for (int j = 0; j < elements.get(i).getColaboratorToCharge().length && !isUnassigned; j++) {
                    if (elements.get(i).getColaboratorToCharge()[j].equals(user)){
                        elements.get(i).getColaboratorToCharge()[j] = null;
                        isUnassigned = true;
                    }
                }
            }
        }
        return isUnassigned;
    }

    @Override
    public String toString() {
        return " |---------------------------- " +
                "\n | Nombre proyecto=" + name + " |"+ " Nombre del creador : " + projectCreator.getName() +
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
