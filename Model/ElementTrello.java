package Model;

import Interface.IElementTrello;


import java.util.Collection;
import java.util.Objects;

public abstract class ElementTrello<T> implements IElementTrello<T> {
    protected String name;
    protected int id;
    protected String description;
    protected Collection<T> elements;

    public ElementTrello() {

    }

    public ElementTrello(String name, int id, String description, Collection<T> elements ) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<T> getElements() {
        return elements;
    }

    public void setElements(Collection<T> elements) {
        this.elements = elements;
    }

    @Override
    public boolean addElement(T obj) {
        return elements.add(obj);
    }
    @Override
    public boolean removeElement(T obj) {
        return elements.remove(obj);
    }
    @Override
    public Collection<T> showAll() {
        return elements;
    }
    @Override
    public T showElement(int id) {
        return null;
    }

    @Override
    public T findElement(int id) {
        return null;
    }
    @Override
    public boolean updateElement(T obj) {

        return false;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
