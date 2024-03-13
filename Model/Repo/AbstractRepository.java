package Model.Repo;

import Interface.Repo_Interface.IAbstractRepository;
import Model.Entity.Proyect;
import java.io.Serializable;
import java.util.Collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractRepository<T> implements IAbstractRepository<T>, Serializable {

    protected Set<T> elements;


    public AbstractRepository(HashSet<Proyect> proyects) {
        elements = new HashSet<>();
    }

    public Set<T> getElements() {
        return elements;
    }

    public void setElements(Set<T> elements) {
        this.elements = elements;
    }

    /**
     * Función encargada de añadir un dato a la colección de elementos, comprobando previamente que no es nulo.
     * @param data el dato que se va a añadir
     * @return true, si se pudo añadir, o false, si no fue así
     */
    @Override
    public boolean add(T data) {
        boolean added = false;
        if(data!=null) {
            if(elements.add(data)) {
                added = true;
            }
        }
        return added;
    }

    @Override
    public Collection<T> getAll() {
        return elements;
    }

    /**
     * Función que funciona en este contexto a modo de firma, para las clases concretas
     * @param element el elemento a devolver
     * @return un objeto que se especifica en la clase concreta, encontrado por su ID
     */
    @Override
    public T getByID(String element) {
        return null;
    }


    @Override
    public T update(T data) {
        return data;
    }
    @Override
    public T delete(String id) {
       T data = null;
        return data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
