package facades;

import dtos.MatchDTO;
import entities.Matches;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class MatchFacade {

    private static MatchFacade instance;
    private static EntityManagerFactory emf;

    //private Constructor to ensure Singleton
    private MatchFacade() {}

    public static MatchFacade getFacade(EntityManagerFactory _emf ){
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
    EntityManager em = getEntityManager();
    try
    {
        TypedQuery<Matches> query = em.createQuery("SELECT m FROM Matches m", Matches.class);
        List<Matches> matches = query.getResultList();
        //returner liste af MatchDTOs
        return MatchDTO.getDTOs(matches);

    }finally
    {
        em.close();
    }

    }
}
