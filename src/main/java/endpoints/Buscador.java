/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoints;

import controlador.ModeloVectorial;
import entidades.Documento;
import static java.nio.file.Files.list;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author agu_9
 */
@Path("/buscador")
public class Buscador {

    @Inject
    ModeloVectorial mv;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response buscar(@QueryParam("q") String q, @QueryParam("r") Integer r) {
        
        if(q.isEmpty() || r == null ){
            return Response.status(400).build();
        }
        
        List<Documento> resultado = mv.procesarBusqueda(q, r);
        return Response.ok(resultado).status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD").build();
    }

}
