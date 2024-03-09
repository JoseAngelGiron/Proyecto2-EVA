package Interface.Controller_Interface;

import Model.Proyect;
import Model.Task;

public interface IRetrieveDataController {
    Proyect retrieveProyect();
    Task retrieveTask(Proyect proyect);
}
