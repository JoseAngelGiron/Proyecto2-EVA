package Model.DataAccess;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    /**
     * Este metodo encripta la contraseña haciendo uso de la biblioteca hash-256
     * @param password la contraseña que se va a encriptar
     * @return la contraseña encriptada.
     */
    public static String encryptPassword(String password) {
        String hexString = null;

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA3-256");

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
