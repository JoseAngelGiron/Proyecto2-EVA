package Interface;

public interface IManage {
    // Define este modelo según el diagrama de clases  y haz las dos funciones
    // Ambas buscan en el repo de usuarios y proyectos y cargan según coincidencias de usuario automaticamente
    public void retrieveUserProjects();
    public void retrieveCollaboratorProjects();
}
