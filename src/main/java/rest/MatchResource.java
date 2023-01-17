package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MatchDTO;
import entities.Matches;
import entities.Player;
import facades.MatchFacade;
import facades.PlayerFacade;
import org.glassfish.grizzly.http.util.HttpStatus;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("match")
public class MatchResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final MatchFacade facade = MatchFacade.getFacade(EMF);
    private static final PlayerFacade playerFacade = PlayerFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMatches() {

        List<MatchDTO> matchDTOList = facade.getAllMatches();
        return GSON.toJson(matchDTOList);
    }

    @PUT
    @Path("{id}/player/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlayerToMatch(@PathParam("id")int id,@PathParam("playerId")int playerId) {
        Player player = playerFacade.getPlayerById(playerId);
        Matches matches = facade.getMatchById(id);
        Matches matchUpdated = facade.addPlayerToMatch(player, matches);
        MatchDTO matchDTO = new MatchDTO(matchUpdated);
        return Response.status(HttpStatus.OK_200.getStatusCode()).entity(GSON.toJson(matchDTO)).build();
    }
}