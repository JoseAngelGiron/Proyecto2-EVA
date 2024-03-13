package Interface.Model_Interface;

import java.util.ArrayList;
import java.util.Collection;

public interface IElementTrello <T>{

        public T addElement(T obj);

        public boolean removeElement(T obj);

        public String getName();


        public void setName(String name);


        public String getId();

        public void setId(String id);

        public String getDescription();

        public void setDescription(String description);

        public Collection<T> getElements();

        public void setElements(ArrayList<T> elements);

        public T findElement(String id);
        public boolean updateElement(T obj );

}
