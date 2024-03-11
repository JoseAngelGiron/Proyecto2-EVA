package Interface.Model_Interface;

import java.util.ArrayList;
import java.util.Collection;

public interface IElementTrello <T>{

        public T addElement(T obj);

        public boolean removeElement(T obj);

        public T showElement(int id);

        public Collection<T> showAll();

        public T findElement(String id);
        public boolean updateElement(T obj );

}
