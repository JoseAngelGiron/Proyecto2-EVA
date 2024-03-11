package Model.Repo;

import Interface.Repo_Interface.IAbstractRepository;
import Model.Entity.Proyect;


import java.io.Serializable;
import java.util.Collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractRepository<T> implements IAbstractRepository<T>, Serializable {

    protected Set<T> elements;


    public AbstractRepository(HashSet<Proyect> proyects) {
        elements = new HashSet<>();
    }

    public Set<T> getElements() {
        return elements;
    }

    public void setElements(Set<T> elements) {
        this.elements = elements;
    }

    /**
     * Función encarga
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        boolean added = false;
        if(data!=null) {
            if(elements.add(data)) {
                added = true;
            }
        }
        return added;
    }

    @Override
    public Collection<T> getAll() {
        return elements;
    }


    @Override
    public T getByID(String element) {
        return null;
    }


    @Override
    public T update(T data) {
        return data;
    }
    @Override
    public T delete(String id) {
       T data = null;
        return data;
    }





}
