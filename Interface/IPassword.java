package Interface;

public interface IPassword {

    // Necesito que la contraseña tenga longitud minima 8 y maxima 20.
    // 2 constructores, uno que reciba la contraseña y la valide, otro que no reciba nada y haga la contraseña
    // automaticamente teniendo en cuenta la long min y max. Que incluya 3 minusculas, 1 mayuscula y 3 numeros

    // La validación, a través del setter y los constructores.
    // He optado no poner ninguna función privada para que lo hagas tu. Si quieres pongo privadas, pero no quería
    // acotarte.


    public void Password();
    public void Password(String Password);

    public String getPassword();
    public boolean setPassword();

    //Antes asignar la contraseña, la encriptas con la biblioteca de sha-256
    public String encryptPassword(String password);

}
