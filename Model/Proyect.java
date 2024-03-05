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




}
