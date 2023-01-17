package facades;

import dtos.MatchDTO;
import entities.Matches;
import entities.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlayerFacade {

    private static PlayerFacade instance;
    private static EntityManagerFactory emf;

    //private Constructor to ensure Singleton
    private PlayerFacade() {}

    public static PlayerFacade getFacade(EntityManagerFactory _emf ){
        if (instance == null){
            emf = _emf;
            instance = new PlayerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }


    public Player getPlayerById(int playerId) {
        EntityManager em = getEntityManager();
        Player player;

        try{
            em.getTransaction().begin();
            player = em.find(Player.class,playerId);
            em.getTransaction().commit();


        }finally
        {
            em.close();
        }

        return  player;
    }
}
