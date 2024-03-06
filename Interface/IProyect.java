package Interface;

import Model.Proyect;
import Model.User;

public interface IProyect {
    public boolean assignCollaborator(Proyect proyect, String idTarea, User user);
    public boolean unassingCollaborator(Proyect proyect, String idTarea, User user);

}