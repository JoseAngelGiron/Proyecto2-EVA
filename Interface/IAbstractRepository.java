package Interface;

import Model.User;

import java.util.Collection;

public interface IAbstractRepository<T> {

    public T add(User data);

    public T getById(String id);

    public Collection<T> getAll();

    public T update(User data);


    public boolean delete(String id);

    public boolean save();
}
