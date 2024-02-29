package Interface;

public interface IUser {

    //Tiene que tener name, nickname y email. Como en el diagrama de clase
    //Cuando hagas el constructor, los atributos tienen que pasar por el setter antes
    //A través del setter se validan. Valida las 3 con expresiones regulares. La del mail es como dice
    //el enunciado. Las otras 2, las discutimos si quieres, pero es necesario que esten validadas

    public void User(String name, String nickname, String email);


    public boolean setNickName(String nickname);
    public boolean setName(String name);
    public boolean setEmail(String email);

    public boolean validateEmail(String email);
    public boolean validateName(String name);
    public boolean validateNickName(String nickName);


}
