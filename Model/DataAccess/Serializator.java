package Model.DataAccess;

import java.io.*;

public class Serializator {
    /**
     * Metodo que serializa en disco cualquier tipo de objeto serializable
     * @param obj debe ser un objeto que implement la interfaz Serializable
     * @param filename nombre del archivo donde serializar el objeto
     * @return true si ha ido correctamente.
     * @param <T> Tipo de objeto a serializar.
     */
    public static<T> boolean serialize(T obj, String filename){
        boolean result=false;
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename)
        )){
            oos.writeObject(obj);
            result = true;
        }catch (IOException e){


        }

        return result;
    }
    /**
     * Metodo que desearializa  cualquier tipo de objeto deserializable
     * @param filename nombre del archivo que deserializar el objeto
     * @return true si ha ido correctamente.
     * @param <T> Tipo de objeto a serializar.
     */
    public static<T> T desearize (String filename){
        T result = null;

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename)
        )){
            result = (T)ois.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }

        return result;
    }

}
