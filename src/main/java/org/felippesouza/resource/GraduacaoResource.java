package org.felippesouza.resource;

import org.felippesouza.model.Graduacao;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/graduacao")
public class GraduacaoResource {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Graduacao> listarGraduacao() {
        return Graduacao.listAll();
    }

    @GET
    @Path("/consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Graduacao consultarGraduacao(@PathParam("id") String id) {
        return Graduacao.findById(id);
    }

    @GET
    @Path("/remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean removerGraduacao(@PathParam("id") String id) {
        return Graduacao.deleteById(id);
    }

    @POST
    @Path("/incluir")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirGraduacao(Graduacao graduacao) {
        Graduacao.persist(graduacao);
        return Response.ok(graduacao).status(201).build();
    }

    @PUT
    @Path("/alterar/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarGraduacao(@PathParam("id") String id, Graduacao graduacao) {
        Graduacao.update(id, graduacao);
        return Response.ok(graduacao).status(201).build();
    }

}
