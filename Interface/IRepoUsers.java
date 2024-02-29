package Interface;

import Model.User;

public interface IRepoUsers {

    public boolean addUser(User userToAdd);

    public boolean checkIfUserExists(User usertoCheck);
}
