package Model.Entity;

import Interface.Model_Interface.IUser;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Pattern;
import static Model.DataAccess.Security.encryptPassword;

public class User implements IUser, Serializable  {
    private String name;
    private String nickName;
    private String email;
    private String password;
    private final int MIN_LENGTH = 8;
    private final int MAX_LENGTH = 20;

    public User(){
        this("","","example@gmail.com","");
    }

    public User(String name, String nickName, String email, String password){
        setName(name);
        setNickName(nickName);
        setEmail(email);
        setPassword(password);
    }

    public User(String nickName, String password){
        setNickName(nickName);
        setPassword(password);
    }
    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean setName(String name) {
        boolean added = false;
        if (validateNoSpacesAndLimitedCharacters(name)) {
            this.name = name;
            added =true;
        }
        return added;
    }

    @Override
    public boolean setNickName(String nickName) {
        boolean added = false;
        if (validateNoSpacesAndLimitedCharacters(nickName)) {
            this.nickName = nickName;
            added =true;
        }
        return added;
    }

    @Override
    public boolean setEmail(String email) {
        boolean added = false;
        if (validateEmail(email)){
            this.email = email;
            added= true;
        }
        return added;
    }

    @Override
    public boolean setPassword(String password)  {
        boolean isPasswordSet = false;
        if (password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH && passwordIntroducedIsStrong(password)) {
            this.password = encryptPassword(password);
            isPasswordSet = true;
        }
        return isPasswordSet;
    }

    @Override
    public boolean equals(Object o) {
        boolean equal;

        User user = (User) o;
        if (o == null || getClass() != o.getClass()) {
            equal = false;
        } else equal = (Objects.equals(nickName, user.nickName) || Objects.equals(email, user.email));

        return equal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, email, password);
    }

    /**
     * Este metodo valida si el name y el nickName no tiene espacios dentro de el campo.
     * @param text que se va a validar.
     * @return Si no cumple la funcion devolveria que el apodo no es valido
     */
    private boolean validateNoSpacesAndLimitedCharacters(String text) {
        Pattern pattern = Pattern.compile("^(?!.*\\s)\\w{4,12}$");
        return pattern.matcher(text).matches();
    }

    /**
     * Este metodo valida si el email empieza con un texto y termina en .com o .es
     * @param email que se va a validar.
     * @return True o false, si no cumple la funcion devolveria que el email no es valido
     */
    @Override
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(".+@.+\\.(com|es)$");

        return pattern.matcher(email).matches();
    }

    /**
     * Comprueba que la contraseña introducida, tiene al menos 3 digitos, 3 minúsculas y 1 mayúscula*
     * @param password la contraseña que se va a validar
     * @return true o false, en función de si la contraseña cumple con los requisitos o no
     */
    private boolean passwordIntroducedIsStrong(String password) {
        boolean result;

        result = (checkAmountLowerCase(password) && checkAmountUpperCase(password) && checkAmountOfNumbers(password));

        return result;
    }

    /**
     *  Función que comprueba si la contraseña que se le pasa tiene una cierta cantidad de números
     *  @param password la contraseña a comprobar
     *  @return true o false, en función si cumple con la condición
     */
    private boolean checkAmountOfNumbers(String password) {
        int acu = 0;
        for (int i = 0; i < password.length(); i++) {

            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                acu++;
            }
        }
        return acu >= 3;
    }
    /**
     * Función que comprueba si la contraseña que se le pasa tiene una cierta cantidad de mayúsculas
     * @param password la contraseña a comprobar
     * @return true o false, en función si cumple con la condición
     */
    private boolean checkAmountUpperCase(String password) {
        int acu = 0;
        for (int i = 0; i < password.length(); i++) {

            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                acu++;
            }
        }
        return acu >= 1;
    }
    /**
     * Función que comprueba si la contraseña que se le pasa tiene una cierta cantidad de minúsculas
     * @param password la contraseña a comprobar
     * @return true o false, en función si cumple con la condición
     */
    private boolean checkAmountLowerCase(String password) {
        int acu = 0;
        for (int i = 0; i < password.length(); i++) {

            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                acu++;
            }
        }
        return acu >= 3;
    }

    @Override
    public String toString() {
        return "name: '" + name + '\'' +
                ", nickName: '" + nickName + '\'' +
                ", email: " + email + '\'' +
                ", password: " + password + '\'';
    }
}