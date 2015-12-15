package es.uc3m.tiw.ejb;

import javax.ejb.Local;

import es.uc3m.tiw.model.Pedido;

@Local
public interface GestionadorCobroLocal {

	public String generarCodigoPago();

	public Pedido generarCobro(String codigoTarjeta, String codigoPedido,
			double importe);

	
}
