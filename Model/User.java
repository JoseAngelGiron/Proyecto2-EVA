package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String nickName;
    private String email;
    private String password;

    private final int MIN_LENGTH = 8;
    private final int MAX_LENGTH = 20;

    public User(String name, String nickName, String email, String password) {
        setName(name);
        setNickName(nickName);
        if (validateEmail(email)) {
            setEmail(email);
        } else {
            this.email = "default@email.com";
        }
        setPassword(password);
    }

    public User(String name, String nickName, String email) {
        setName(name);
        setNickName(nickName);
        if (validateEmail(email)) {
            setEmail(email);
        } else {
            this.email = "default@email.com";
        }
        this.password = "";
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

    public void setName(String name) {
        if (validateNoSpaces(name)) {
            this.name = name;
        } else {
            System.out.println("El nombre no puede contener espacios");
        }
    }

    public void setNickName(String nickName) {
        if (validateNoSpaces(nickName)) {
            this.nickName = nickName;
        } else {
            System.out.println("El apodo no puede contener espacios");
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean setPassword(String password) {
        boolean isPasswordSet = false;
        if (password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH && passwordIntroducedIsStrong(password)) {
            this.password = encryptPassword(password);
            isPasswordSet = true;
        }
        return isPasswordSet;
    }


    private boolean validateNoSpaces(String text) {
        Pattern pattern = Pattern.compile("^\\S*$");
        return pattern.matcher(text).matches();
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(".+@.+\\.(com|es)$");
        return pattern.matcher(email).matches();
    }

    private boolean passwordIntroducedIsStrong(String password) {
        return true;
    }

    /**

     Este metodo encripta la contraseña haciendo uso de la biblioteca hash-256
     @param password la contraseña que se va a encriptar
     @return la contraseña encriptada.*/
    public String encryptPassword(String password) {
        String hexString = null;

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(password.getBytes());

            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexStringBuilder.append('0');
                }
                hexStringBuilder.append(hex);
            }

            hexString = hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString;
    }
}