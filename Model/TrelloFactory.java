package Model;

import Model.Entity.ElementTrello;
import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

import java.time.LocalDate;

public class TrelloFactory {

    /**
     *
     * @param elementstTrello define el tipo de elemento a crear {@link ElementstTrello}
     * @param codigo que será el atributo común que identificara a los elementos
     * @param user El usuario, que recibirá los proyectos, su creador
     * @return un objeto del tipo ElementTrello.
     */
    public static ElementTrello build(ElementstTrello elementstTrello, String codigo, User user) {
        ElementTrello result = null;

        switch (elementstTrello) {
            case TASK:
                result = new Task(codigo);
                break;
            case PROYECT:
                result = new Proyect(codigo, user);
                break;
        }
        return result;
    }

    /**
     *
     * @param elementstTrello que define el tipo de elemento a crear {@link ElementstTrello}
     * @param name El nombre del elemento
     * @param id que será el código por el que se identificaran los elementos
     * @param description La descripción del elemento
     * @param userCreator El creador del usuario, para el caso de los proyectos
     * @param beginDate la fecha de comienzo, para las fechas
     * @param endDate la fecha de fin, para las fechas
     * @return un objeto de tipo elementTrello
     */
    public static ElementTrello build(ElementstTrello elementstTrello, String name, String id, String description,
                                      User userCreator, LocalDate beginDate, LocalDate endDate) {
        ElementTrello result = null;

        switch (elementstTrello) {
            case TASK:
                result = new Task(name,id,description,beginDate,endDate);
                break;
            case PROYECT:
                result = new Proyect(name,id,description,userCreator);
        }
        return result;
    }
}



