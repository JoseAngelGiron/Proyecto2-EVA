package Interface.Model_Interface;

import Model.User;

public interface ITask {

    public boolean changeStatus(int status);
    User setColaboratorToCharge(User user);
    void addComentary(String comentary);
}
