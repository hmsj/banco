package es.uc3m.tiw.ejb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class GestionadorCobro
 */
@Stateless(mappedName = "servicioPasarela")
@LocalBean
public class GestionadorCobro implements GestionadorCobroLocal {

    /**
     * Default constructor. 
     */
    public GestionadorCobro() {
        // TODO Auto-generated constructor stub
    }
    
    public String generarCodigoPago() {
		// TODO Auto-generated method stub
		String codigoPago = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmssSSSa");
	    Date fechaActual = new Date();
	    String strDate = sdfDate.format(fechaActual);
	    codigoPago = "ORDER"+strDate;

		return codigoPago;
	}

}
