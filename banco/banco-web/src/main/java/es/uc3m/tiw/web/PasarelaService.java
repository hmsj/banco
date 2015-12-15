package es.uc3m.tiw.web;



import java.sql.Date;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import es.uc3m.tiw.ejb.GestionadorCobro;
import es.uc3m.tiw.model.*;
/**
 * La url de acceso sera: 
 * Para getText() -- http://localhost:8080/banco/pasarela/prueba 
 * Para getDatos() -- http://localhost:8080/resources/pasarela/prueba/23/david 

 * @author Henar Mata
 *
 */
@Path("pasarela")
public class PasarelaService {

    @EJB
	private GestionadorCobro gestionadorCobro;
    /**
     * Default constructor. 
     */
    public PasarelaService() {
        // TODO Auto-generated constructor stub
    }

    @GET
	@Path("pagoMatricula/{importe}/{codigoTarjeta}/{codigoPedido}/{fechaPedido}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String PagoMatricula(@PathParam("codigoTarjeta") String codigoTarjeta,
			@PathParam("codigoPedido") String codigoPedido,
			@PathParam("importe") double importe, @PathParam("fechaPedido") Date fechaPedido) {

		String codigoOperacion = null;

		codigoOperacion = gestionadorCobro.generarCobro(codigoTarjeta, codigoPedido, importe, fechaPedido);

		return codigoOperacion;

	}
    

}