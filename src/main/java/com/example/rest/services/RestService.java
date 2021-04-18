package com.example.rest.services;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.rest.models.UserRepository;
import com.example.rest.models.Utilisateur;

@Path("/android")
public class RestService {

    private UserRepository userRepository;


    public RestService(){
		userRepository = UserRepository.getInstance();
	}
	/**
     * Method handling HTTP GET requests. The returned livres will be sent
     * to the client as JSON or XML  media type.
     *
     * @return Array of Livres  that will be returned as a JSON or XML response.
     */
	@Path("/utilisateurs")
    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    public List<Utilisateur> getUtilisateurs(){
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }
	/**
	 * Method handling HTTP GET requests. The returned livres will be sent
	 * to the client as JSON or XML  media type.
	 *
	 * @return Livre that will be returned as a JSON or XML response.
	 */
	@Path("/utilisateurs/{idP}")
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Utilisateur getUtilisateur(@PathParam(value  = "idP")int idP){
		System.out.println("search by identity");
		System.out.println(userRepository.find(idP)+ "par id ");
    	return userRepository.find(idP);
	}

	/**
	 * Method handling HTTP PUT requests.
	 * to the client as JSON or XML media type.
	 *
	 */
	@Path("/utilisateurs")
    @POST
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public String create(Utilisateur utilisateur ){
    	userRepository.save(utilisateur);
    	return "PUT done";

	}
	/**
	 * Method handling HTTP DELETE requests.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@Path("/utilisateurs/{id}")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public String delete(@PathParam(value  = "id")int id ){
		userRepository.delete(id);
		return id+"is deleted";
	}
}

