package Repo;

import Interface.IRepoProyects;

import java.util.Set;

public class RepoProyects implements IRepoProyects {
    private final static String FILENAME = "proyects.bin";
    private Set<Proyect> proyects;

    /**
     * Se le pasa un proyecto y lo almacena en un Set
     *
     * @param proyectToAdd El proyecto que se va a almacenar
     * @return true si se a almacenado correctamente y false si a habido algun error
     */
    @Override
    public boolean addProyect(Proyect proyectToAdd) {
        boolean result = false;
        if (proyects.add(proyectToAdd)) {
            result = true;
        }
        return result;
    }
}
