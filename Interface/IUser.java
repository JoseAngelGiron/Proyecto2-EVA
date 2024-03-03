package Interface;

import java.security.NoSuchAlgorithmException;

public interface IUser {

    public boolean setNickName(String nickname);
    public boolean setName(String name);
    public boolean setEmail(String email);
    public boolean setPassword(String password) throws NoSuchAlgorithmException;

    public boolean validateEmail(String email);





}
