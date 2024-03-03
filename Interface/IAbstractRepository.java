package Interface;

import Model.User;

import java.util.Collection;

public interface IAbstractRepository<T> {

    public T add(T data);



    public T getById(T id);


    public Collection<T> getAll();


    public boolean update(T data);


    public boolean delete(String id);

    public boolean save();
}
