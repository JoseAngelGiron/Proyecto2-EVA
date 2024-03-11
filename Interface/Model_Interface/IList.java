package Interface.Model_Interface;


import Model.Entity.User;

public interface IList {

    //Basicamente definir un modelo y cambiar iterando a través de su elementos con el id especificado si el User EXISTE
    // comprobado previamente en el repo de usuarios
    public boolean assignCollaborator(String idTarea, User user);
    public boolean unassingCollaborator(String idTarea, User user);
}
