package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Pedido;

public interface IPedidoDao {

	Pedido createPedido(Pedido pedidoNuevo) throws Exception;

	void removePedido(Pedido pedido) throws Exception;

	Pedido modifyPedido(Pedido pedido) throws Exception;

	Pedido findById(Long idPedido) throws Exception;


}
