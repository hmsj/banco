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
public class GestionadorCobro implements GestionadorCobroLocal {

	@PersistenceContext (unitName="banco-model")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private IPedidoDao pedidoDao;
	private IConciliacionEmpresaDao conciliacionEmpresaDao;
	private IConciliacionProfesorDao conciliacionProfesorDao;
	
	@PostConstruct
	private void configurador(){
		pedidoDao = new PedidoDao(em, ut);
		conciliacionEmpresaDao = new ConciliacionEmpresaDao(em, ut);
		conciliacionProfesorDao = new ConciliacionProfesorDao(em, ut);
	}
    /**
     * Default constructor. 
     */
    public GestionadorCobro() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
  	public String generarCobro(String codigoTarjeta, String codigoPedido,
  			double importe, java.sql.Date fechaPedido) {
  		// TODO Auto-generated method stub
    	String codigoOperacion = "";
    	Pedido nuevoPedido = new Pedido();
    	Pedido pedidoCreado = null;
  		if(codigoTarjeta!=null && !"".equalsIgnoreCase(codigoTarjeta) && codigoPedido!=null && !"".equalsIgnoreCase(codigoPedido) && importe>0 && fechaPedido!=null){
  			codigoOperacion = generarCodigoPago();
  			if(codigoOperacion!=null && !"".equalsIgnoreCase(codigoOperacion)){
  				nuevoPedido.setCodigoOperacion(codigoOperacion);
  				nuevoPedido.setCodigoPedido(codigoPedido);
  				nuevoPedido.setCodigoTarjeta(codigoTarjeta);
  				nuevoPedido.setFechaPedido(fechaPedido);
  				nuevoPedido.setImporte(importe);
  				try {
					pedidoCreado = pedidoDao.createPedido(nuevoPedido);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					pedidoCreado = null;
				}
  			}
  		}
    	return codigoOperacion;
  	}
    
    @Override
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
