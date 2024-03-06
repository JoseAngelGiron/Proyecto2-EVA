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

    @Override
    public boolean assignCollaborator(String idTarea, User user) {
        boolean isUnassigned = false;
        for (int i=0;i<elements.size() && !isUnassigned;i++) {


        }
        return isUnassigned;



    }

    @Override
    public boolean unassingCollaborator(String idTarea, User user) {
        boolean isUnassigned = false;
        for (int i=0;i<elements.size() && !isUnassigned;i++) {
            if (elements.get(i).getId().equals(idTarea)) {
                elements.get(i).setColaboratorToCharge(null);
                isUnassigned = true;

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
