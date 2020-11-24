package org.felippesouza.resource;

import org.felippesouza.model.Disciplina;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/disciplina")
public class DisciplinaResource {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Disciplina> listarDisciplina() {
        return Disciplina.listAll();
    }

    @GET
    @Path("/consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Disciplina consultarDisciplina(@PathParam("id") String id) {
        return Disciplina.findById(id);
    }

    @GET
    @Path("/remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean removerDisciplina(@PathParam("id") String id) {
        return Disciplina.deleteById(id);
    }

    @POST
    @Path("/incluir")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirDisciplina(Disciplina disciplina) {
        Disciplina.persist(disciplina);
        return Response.ok(disciplina).status(201).build();
    }

    @PUT
    @Path("/alterar/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarDisciplina(@PathParam("id") String id, Disciplina disciplina) {
        Disciplina.update(id, disciplina);
        return Response.ok(disciplina).status(201).build();
    }

}
