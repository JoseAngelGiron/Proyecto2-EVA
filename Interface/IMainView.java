package Interface;

import Model.User;

public interface IMainView {

    public int mainView();

    public int loginError();

    public void registerMessage(boolean isAlreadyRegister);
    public User solicitateUser();





}
