package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MatchFacade {

    private static MatchFacade instance;
    private static EntityManagerFactory emf;

    //private Constructor to ensure Singleton
    private MatchFacade() {}

    public static MatchFacade getInstance(EntityManagerFactory _emf ){
        if (instance == null){
            emf = _emf;
            instance = new MatchFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }


    public List<MatchDTO> getAllMatches() {


    }
}
