package Repo;

import Interface.IAbstractRepository;
import Model.User;

import java.util.Collection;

public class AbstractRepository implements IAbstractRepository {
    @Override
    public Object add(User data) {
        return null;
    }

    @Override
    public Object getById(String id) {
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public Object update(User data) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean save() {
        return false;
    }
}
