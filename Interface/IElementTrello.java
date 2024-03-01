package Interface;

import java.util.ArrayList;

public interface IElementTrello <T>{

        //Define el modelo según el diagrama de clases  y haz la lógica de las funciones

        public boolean addElement(Object obj);

        public boolean removeElement(Object obj);

        public T showElement(int id);

        public ArrayList<T> showAll();

        public T findElement(int id);
        public boolean updateElement(Object obj );

}
