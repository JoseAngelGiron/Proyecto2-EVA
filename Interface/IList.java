package Interface;

public interface IList {

    //Basicamente definir un modelo y cambiar iterando a través de su elementos con el id especificado si el User EXISTE
    // comprobado previamente en el repo de usuarios
    public boolean assignCollaborator(String idTarea, String User);
    public boolean unassingCollaborator(String idTarea, String User);
}
