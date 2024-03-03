package Model;


import Interface.IProyect;

import java.awt.*;
import java.util.ArrayList;


public class Proyect extends ElementTrello<List> implements IProyect {
    User projectCreator;

    public Proyect(){
        super();

    }
    public Proyect(String name, int id, String description, User projectCreator) {
        super(name, id, description, new ArrayList<>());
        this.projectCreator = projectCreator;
    }



}
