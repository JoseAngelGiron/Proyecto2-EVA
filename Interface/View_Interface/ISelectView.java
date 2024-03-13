package Interface.View_Interface;

import java.time.LocalDate;

public interface ISelectView {

    int selectTypeOfTask();
    int selectTypeOfProyect();

    String solicitateName();
    String solicitateCod();
    String solicitateDescription();
    LocalDate solicitateDate(String msg);



}
