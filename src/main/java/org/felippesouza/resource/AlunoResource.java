package org.felippesouza.resource;

import org.felippesouza.model.Aluno;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/aluno")
public class AlunoResource {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aluno> listarAluno() {
        return Aluno.listAll();
    }

    @GET
    @Path("/consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno consultarAluno(@PathParam("id") String id) {
        return Aluno.findById(id);
    }

    @GET
    @Path("/remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean removerAluno(@PathParam("id") String id) {
        return Aluno.deleteById(id);
    }

    @POST
    @Path("/incluir")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirAluno(Aluno aluno) {
        Aluno.persist(aluno);
        return Response.ok(aluno).status(201).build();
    }

    @PUT
    @Path("/alterar/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarAluno(@PathParam("id") String id, Aluno aluno) {
        Aluno.update(id, aluno);
        return Response.ok(aluno).status(201).build();
    }

}
