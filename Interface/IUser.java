package Interface;

public interface IUser {

    public boolean setNickName(String nickname);
    public boolean setName(String name);
    public boolean setEmail(String email);
    public boolean setPassword(String password);

    public boolean validateEmail(String email);



}
