package es.uc3m.tiw.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.daos.ConciliacionEmpresaDao;
import es.uc3m.tiw.daos.ConciliacionProfesorDao;
import es.uc3m.tiw.daos.IConciliacionEmpresaDao;
import es.uc3m.tiw.daos.IConciliacionProfesorDao;
import es.uc3m.tiw.daos.IPedidoDao;
import es.uc3m.tiw.daos.PedidoDao;
import es.uc3m.tiw.model.Pedido;

/**
 * Session Bean implementation class GestionadorCobro
 */
@Stateless(mappedName = "servicioPasarela")
@LocalBean
public class GestionadorCobro {
	
	@PersistenceContext (unitName="banco-model")
	private EntityManager em;
		
	private IPedidoDao pedidoDao;
	private IConciliacionEmpresaDao conciliacionEmpresaDao;
	private IConciliacionProfesorDao conciliacionProfesorDao;
    /**
     * Default constructor. 
     */
    public GestionadorCobro() {
        // TODO Auto-generated constructor stub
    }
    
  	public String generarCobro(String codigoTarjeta, String codigoPedido,
  			double importe, java.sql.Date fechaPedido) {
  		// TODO Auto-generated method stub
    	pedidoDao = new PedidoDao(em);

    	String codigoOperacion = "";
    	Pedido nuevoPedido = null;
    	Pedido pedidoCreated = null;
  		if(codigoTarjeta!=null && !"".equalsIgnoreCase(codigoTarjeta) && codigoPedido!=null && !"".equalsIgnoreCase(codigoPedido) && importe>0 && fechaPedido!=null){
  			codigoOperacion = generarCodigoPago();
  			if(codigoOperacion!=null && !"".equalsIgnoreCase(codigoOperacion)){
  				nuevoPedido = new Pedido(codigoPedido, importe, codigoOperacion, codigoTarjeta, fechaPedido);
  				try {
					pedidoCreated = pedidoDao.createPedido(nuevoPedido);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					pedidoCreated = null;
				}
  				
  				if (pedidoCreated != null){
  					String codigoBanco = pedidoCreated.getCodigoOperacion();
  					return codigoBanco;
  				}
  			}
  		}
    	return codigoOperacion;
  	}

    public String generarCodigoPago() {
		// TODO Auto-generated method stub
		String codigoPago = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSa");
	    Date fechaActual = new Date();
	    String strDate = sdfDate.format(fechaActual);
	    codigoPago = "BANCO"+strDate;

		return codigoPago;
	}
}
