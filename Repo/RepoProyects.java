package Repo;

import Interface.IRepoProyects;
import Model.Proyect;
import Model.User;
import Utils.Serializator;

import java.util.HashSet;
import java.util.Set;

public class RepoProyects extends AbstractRepository<Proyect> implements IRepoProyects {

    public RepoProyects() {
        super(new HashSet<>());
    }

    public Set<Proyect> getProyects() {
        return elements;
    }


    @Override
    public Proyect getByID(String id) {
        Proyect result = null;
        for (Proyect user : elements) {
            if (user.getId().equals(id)) {
                result = user;
            }
        }
        return result;
    }

    @Override
    public Proyect update(Proyect data) {
        return data;
    }
    @Override
    public boolean delete(String id) {
        return false;
    }




}
