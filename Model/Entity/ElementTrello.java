package Model.Entity;

import Interface.Model_Interface.IElementTrello;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class ElementTrello<T> implements IElementTrello<T>, Serializable {
    protected String id;
    protected String name;
    protected String description;
    protected List<T> elements;

    public ElementTrello() {
        this("","","");
    }
    public ElementTrello(String name, String id, String description  ) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.elements = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public Collection<T> getElements() {
        return elements;
    }
    @Override
    public void setElements(ArrayList<T> elements) {
        this.elements = elements;
    }

    /**
     * Función encargada de añadir un elemento al elemento de la lista
     * @param obj el objeto que se va a añadir
     * @return el objeto que se va a añadir, que será null si ya se encontraba y no pudo ser añadido
     */
   @Override
   public T addElement(T obj){
        T tmpObj = null;
        if(!elements.contains(obj)){
            elements.add(obj);
            tmpObj = obj;
        }
        return tmpObj;

   }

    /**
     * Función encargada de eliminar un elemento de la lista.
     * @param obj el objeto que se va a eliminar
     * @return true o false, en función de si se encuentra el elemento y es eliminado, o false si no es así
     */
    @Override
    public boolean removeElement(T obj) {
        return elements.remove(obj);
    }

    //ESTAS 2 SE PUEDE PASAR PARA ABAJO
    @Override
    public T findElement(String id) {
        return null;
    }
    @Override
    public boolean updateElement(T obj) {

        return false;
    }

    @Override
    public boolean equals(Object o) {
        boolean equal = false;
        if (this == o) equal = true;
        if (!(o instanceof ElementTrello<?> that)) equal = false;
        equal = Objects.equals(id, this.id);
        return equal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
