package es.uc3m.tiw.ejb;

import java.sql.Date;

import javax.ejb.Local;

import es.uc3m.tiw.model.Pedido;

@Local
public interface GestionadorCobroLocal {

	public String generarCodigoPago();

	public String generarCobro(String codigoTarjeta, String codigoPedido,
			double importe, Date fechaPedido);

	
}
