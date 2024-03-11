package Interface.Model_Interface;

import Model.Entity.User;

public interface ITask {

    public boolean changeStatus(int status);
    User setColaboratorToCharge(User user);
    void addComentary(String comentary);
    User unassignColaborator(User user);

}
