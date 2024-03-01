package Model;

import Interface.IElementTrello;

import java.util.ArrayList;

public abstract class ElementTrello<T> implements IElementTrello {
    protected String name;
    protected int id;
    protected String description;
    protected ArrayList<T> elements;

    @Override
    public boolean addElement(Object obj) {
        return false;
    }
    @Override
    public boolean removeElement(Object obj) {
        return false;
    }
    @Override
    public T showElement(int id) {
        return null;
    }
    @Override
    public ArrayList<T> showAll() {
        return null;
    }
    @Override
    public T findElement(int id) {
        return null;
    }

    public boolean updateElement(Object obj) {
        return false;
    }

}
