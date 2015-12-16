package es.uc3m.tiw.web;



import java.sql.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
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

import es.uc3m.tiw.daos.ConciliacionEmpresaDao;
import es.uc3m.tiw.daos.ConciliacionProfesorDao;
import es.uc3m.tiw.daos.IConciliacionEmpresaDao;
import es.uc3m.tiw.daos.IConciliacionProfesorDao;
import es.uc3m.tiw.daos.IPedidoDao;
import es.uc3m.tiw.daos.PedidoDao;
import es.uc3m.tiw.ejb.GestionadorCobro;
import es.uc3m.tiw.model.*;
/**
 *
 * @author Henar Mata
 *
 */
@Path("pasarela")
@Stateless
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
	@Path("pagoMatricula/{importe}/{codigoTarjeta}/{codigoPedido}/{fechaPedido}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String PagoMatricula(@PathParam("importe") Double importe, @PathParam("codigoTarjeta") String codigoTarjeta,
			@PathParam("codigoPedido") String codigoPedido, @PathParam("fechaPedido") Date fechaPedido) {
    	
		String codigoOperacion = "";
		
		codigoOperacion = gestionadorCobro.generarCobro(codigoTarjeta, codigoPedido, importe, fechaPedido);
		
		return codigoOperacion;
	}
    
    @GET
   	@Path("conciliacionEmpresa/{day}/{month}/{year}/{importe}/xml")
   	@Consumes(MediaType.TEXT_PLAIN)
   	@Produces(MediaType.TEXT_PLAIN)
   	public ConciliacionEmpresa DoConciliacionEmpresa(@PathParam("day") Integer day, @PathParam("month") Integer month,
   			@PathParam("year") Integer year, @PathParam("importe") Double importe) {
       	
   		ConciliacionEmpresa conEmpresa = null;
   		
   		conEmpresa = gestionadorCobro.generarConciliacionEmpresa(day, month, year, importe);
   		
   		return conEmpresa;
   	}
    
    @GET
   	@Path("conciliacionEmpresa/{day}/{month}/{year}/{importe}/{idProfesor}/xml")
   	@Consumes(MediaType.TEXT_PLAIN)
   	@Produces(MediaType.TEXT_PLAIN)
   	public ConciliacionProfesor DoConciliacionProfesor(@PathParam("day") Integer day, @PathParam("month") Integer month,
   			@PathParam("year") Integer year, @PathParam("importe") Double importe, @PathParam("idProfesor") Long idProfesor) {
       	
   		ConciliacionProfesor conProfesor = null;
   		
   		conProfesor = gestionadorCobro.generarConciliacionProfesor(day, month, year, importe, idProfesor);
   		
   		return conProfesor;
   	}
}