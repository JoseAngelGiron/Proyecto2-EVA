package Interface;

import Model.User;

import java.util.Collection;

public interface IAbstractRepository<T> {

    public boolean add(T data);

    public Collection<T> getAll();


    public T getByID(String element);

    public T update(T data);


    public boolean delete(String id);

    //public boolean checkIfElemen
}
