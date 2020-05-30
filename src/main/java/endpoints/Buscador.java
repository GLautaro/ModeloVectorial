/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoints;

import controlador.ModeloVectorial;
import entidades.Documento;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author agu_9
 */
@Path("/buscador")
public class Buscador {

    @GET
    @Path("/")
    @Produces("application/json")
    public Response cargar() {

        ModeloVectorial mv = new ModeloVectorial();
        ArrayList<Documento> resultado = mv.procesarBusqueda("Copyright", 2);
        return Response.ok(resultado).build();
    }

}
