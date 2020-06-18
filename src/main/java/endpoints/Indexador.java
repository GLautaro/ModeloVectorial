/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoints;

import controlador.IndexadorController;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


/**
 *
 * @author lauti
 */
@Path("/indexador")
public class Indexador {
    
    @GET
    @Path("/iniciar")
    @Produces("text/plain")
    public Response indexarDocumentos() {
        IndexadorController indexCon = new IndexadorController();
        indexCon.iniciarIndexacion();        
        return Response.ok("Documentos indexados").build();
    }
    
}
