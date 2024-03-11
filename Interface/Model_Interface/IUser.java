package Interface.Model_Interface;

import java.security.NoSuchAlgorithmException;

public interface IUser {

    boolean setNickName(String nickname);
    boolean setName(String name);
    boolean setEmail(String email);
    boolean setPassword(String password) throws NoSuchAlgorithmException;
    boolean validateEmail(String email);





}
