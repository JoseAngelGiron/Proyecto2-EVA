package Interface.Model_Interface;

import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

import java.util.ArrayList;

public interface IManage {

    boolean checkLogin(User userToCheck);
    boolean checkRegister(User userToCheck);
    void setUserLoggedIn(User userToLogin);
    ArrayList<Proyect> retrieveProyects();
    Proyect deleteProyectFromCreator(String id, User userLogged);
    String checkNickname(String nickName);
    String checkEmail(String email);






}
