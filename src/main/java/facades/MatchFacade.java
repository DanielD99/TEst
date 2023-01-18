package facades;

import dtos.MatchDTO;
import entities.Matches;
import entities.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
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



    public Matches addPlayerToMatch(Player player, Matches matches){
        EntityManager em = getEntityManager();


        try{
            em.getTransaction().begin();

            if(!em.contains(matches)){
            em.merge(matches);

            }
            matches.getPlayers().add(player);
            em.merge(matches);
            em.getTransaction().commit();

        }finally
        {
            em.close();
        }
        return matches;

    }



    public void removePlayer(Player player) {
        EntityManager em = emf.createEntityManager();
        if(player.getId() == null) {
            throw new EntityNotFoundException("Selected player does not exist, with player id: "+ player.getId());
        }

        try {
            em.getTransaction().begin();
            if(!em.contains(player)){
                player = em.merge(player);
            }
            em.remove(player);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    public Matches getMatchById(int id) {

        EntityManager em = getEntityManager();
        Matches matches;

        try{
            em.getTransaction().begin();
            matches = em.find(Matches.class,id);
            em.getTransaction().commit();


        }finally
        {
        em.close();
        }

        return  matches;
    }
}
