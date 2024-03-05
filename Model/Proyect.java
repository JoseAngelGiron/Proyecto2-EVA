package Model;


import Interface.IProyect;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Proyect extends ElementTrello<List> implements IProyect {
    User projectCreator;

    public Proyect(){
        super();

    }
    public Proyect(String name, String id, String description, User projectCreator) {
        super(name, id, description, new ArrayList<>());
        this.projectCreator = projectCreator;
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
    public String toString() {
        return " |---------------------------- " +
                "\n | Nombre proyecto=" + name + " |"+ " Nombre: " + projectCreator.getName() +
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
