package org.felippesouza.resource;

import org.felippesouza.model.TrabalhoAcademico;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/trabalhoAcademico")
public class TrabalhoAcademicoResource {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TrabalhoAcademico> listarTrabalhoAcademico() {
        return TrabalhoAcademico.listAll();
    }

    @GET
    @Path("/consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TrabalhoAcademico consultarTrabalhoAcademico(@PathParam("id") String id) {
        return TrabalhoAcademico.findById(id);
    }

    @GET
    @Path("/remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean removerTrabalhoAcademico(@PathParam("id") String id) {
        return TrabalhoAcademico.deleteById(id);
    }

    @POST
    @Path("/incluir")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirTrabalhoAcademico(TrabalhoAcademico trabalhoAcademico) {
        TrabalhoAcademico.persist(trabalhoAcademico);
        return Response.ok(trabalhoAcademico).status(201).build();
    }

    @PUT
    @Path("/alterar/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarTrabalhoAcademico(@PathParam("id") String id, TrabalhoAcademico trabalhoAcademico) {
        TrabalhoAcademico.update(id, trabalhoAcademico);
        return Response.ok(trabalhoAcademico).status(201).build();
    }

}
