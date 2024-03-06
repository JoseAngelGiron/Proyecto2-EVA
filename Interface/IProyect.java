package Interface;

import Model.User;

public interface IProyect {
    public boolean assignCollaborator(String idTarea, User user);
    public boolean unassingCollaborator(String idTarea, User user);

}