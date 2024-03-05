package Interface;

import java.util.ArrayList;
import java.util.Collection;

public interface  IElementTrello <T>{

        //Define el modelo según el diagrama de clases  y haz la lógica de las funciones

        public boolean addElement(T obj);

        public boolean removeElement(T obj);

        public T showElement(int id);

        public Collection<T> showAll();

        public T findElement(int id);
        public boolean updateElement(T obj );

}
