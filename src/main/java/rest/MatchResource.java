package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.MatchFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/match")
public class MatchResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final MatchFacade facade = MatchFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMatches() {

        List<MatchDTO> MatchDTOList = facade.getAllMatches();
        return GSON.toJson(MatchDTOList);
    }
}