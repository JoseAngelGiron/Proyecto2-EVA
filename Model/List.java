package Model;

import Interface.IList;

import java.util.ArrayList;


public class List implements IList {
    private ArrayList<Task> tasks;
    private ArrayList<User> users;

    public List() {
        this.tasks = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    /**
     * Método para asignar un colaborador a una tarea.
     * @param userName Nombre del usuario a asignar.
     * @return true si se asignó correctamente, false en caso contrario.
     */
    @Override
    public boolean assignCollaborator(String idTarea, String userName) {
        boolean isAssigned = false;
        if (userExists(userName)) {
            for (Task task : tasks) {
                if (task.getId().equals(idTarea)) {
                    User userToAssign = users.get(userName);
                    task.setColaboratorToCharge(userToAssign);
                    isAssigned = true;
                    break;
                }
            }
        }
        return isAssigned;
    }
    /**
     * Método para desasignar un colaborador de una tarea.
     * @param userName Nombre del usuario a desasignar.
     * @return true si se desasignó correctamente, false en caso contrario.
     */
    @Override
    public boolean unassingCollaborator(String idTarea, String userName) {
        boolean isUnassigned = false;
        for (Task task : tasks) {
            if (task.getId().equals(idTarea) && task.getColaboratorToCharge().getNickName().equals(userName)) {
                task.setColaboratorToCharge(null);
                isUnassigned = true;
                break;
            }
        }
        return isUnassigned;
    }

    // Método para verificar si el usuario existe en el repositorio
    /**
     * Este metodo verifica si el usuario existe en el repositorio
     * @param userName que se va a verificar.
     * @return True o false, si no cumple la funcion devolveria que el email no es valido
     */
    private boolean userExists(String userName) {
        boolean exists = false;
        for (User user : users) {
            if (user.getNickName().equals(userName)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}
