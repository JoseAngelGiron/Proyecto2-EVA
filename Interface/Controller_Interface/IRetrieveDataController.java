package Interface.Controller_Interface;

import Model.Entity.Proyect;
import Model.Entity.Task;

public interface IRetrieveDataController {
    Proyect retrieveProyect();
    Task retrieveTask(Proyect proyect);
}
