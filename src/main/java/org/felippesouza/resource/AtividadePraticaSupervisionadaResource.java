package org.felippesouza.resource;

import org.felippesouza.model.AtividadePraticaSupervisionada;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/trabalhoAcademico")
public class AtividadePraticaSupervisionadaResource {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AtividadePraticaSupervisionada> listarAtividadePraticaSupervisionada() {
        return AtividadePraticaSupervisionada.listAll();
    }

    @GET
    @Path("/consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AtividadePraticaSupervisionada consultarAtividadePraticaSupervisionada(@PathParam("id") String id) {
        return AtividadePraticaSupervisionada.findById(id);
    }

    @GET
    @Path("/remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean removerAtividadePraticaSupervisionada(@PathParam("id") String id) {
        return AtividadePraticaSupervisionada.deleteById(id);
    }

    @POST
    @Path("/incluir")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirAtividadePraticaSupervisionada(AtividadePraticaSupervisionada atividadePraticaSupervisionada) {
        AtividadePraticaSupervisionada.persist(atividadePraticaSupervisionada);
        return Response.ok(atividadePraticaSupervisionada).status(201).build();
    }

    @PUT
    @Path("/alterar/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarAtividadePraticaSupervisionada(@PathParam("id") String id, AtividadePraticaSupervisionada atividadePraticaSupervisionada) {
        AtividadePraticaSupervisionada.update(id, atividadePraticaSupervisionada);
        return Response.ok(atividadePraticaSupervisionada).status(201).build();
    }

}
