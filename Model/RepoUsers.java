package Model;

import Interface.IRepoUsers;

import java.io.Serializable;
import java.util.ArrayList;

public class RepoUsers implements IRepoUsers, Serializable {

    ArrayList<User> users;


    public RepoUsers() {
        this.users = new ArrayList<>();
    }


    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean addUser(User userToAdd) {
        boolean added = false;
        if(!users.contains(userToAdd)){
            users.add(userToAdd);
            added = true;
        }
        return added;
    }
    @Override
    public boolean checkIfUserExists(User usertoCheck) {
        return users.contains(usertoCheck);
    }

    @Override
    public boolean changeCreator(String user) {
        return false;
    }
}






