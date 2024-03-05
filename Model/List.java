package Model;

import Interface.IList;

import java.io.Serializable;
import java.util.ArrayList;


public class List extends ElementTrello<Task> implements IList {



    public List() {
        elements = new ArrayList<>();
    }

    /**
     * Método para asignar un colaborador a una tarea.
     * @param user Nombre del usuario a asignar.
     * @return true si se asignó correctamente, false en caso contrario.
     */
    @Override
    public boolean assignCollaborator(String idTarea, User user) {
        boolean isAssigned = false;
        for (int i=0;i<elements.size() && !isAssigned;i++) {
            if (elements.get(i).getId().equals(idTarea)) {
                elements.get(i).setColaboratorToCharge(user);
                isAssigned = true;
            }
        }

        return isAssigned;
    }

    /**
     * Método para desasignar un colaborador de una tarea.
     * @param user Nombre del usuario a desasignar.
     * @return true si se desasignó correctamente, false en caso contrario.
     */
    @Override
    public boolean unassingCollaborator(String idTarea, User user) {
        boolean isUnassigned = false;
        for (int i=0;i<elements.size() && !isUnassigned;i++) {
            if (elements.get(i).getId().equals(idTarea)) {
                elements.get(i).setColaboratorToCharge(null);
                isUnassigned = true;

            }
        }
        return isUnassigned;
    }
}
