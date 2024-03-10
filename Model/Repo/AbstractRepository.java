package Model.Repo;

import Interface.Repo_Interface.IAbstractRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractRepository<T> implements IAbstractRepository<T>, Serializable {
    //En las clases concretas he puesto un hashset
    protected Set<T> elements;

    public AbstractRepository(){

    }
    public AbstractRepository(Set<T> elements) {
        this.elements = new HashSet<>();
    }

    public Set<T> getElements() {
        return elements;
    }

    public void setElements(Set<T> elements) {
        this.elements = elements;
    }

    @Override
    public boolean add(T data) {
        return elements.add(data);
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
