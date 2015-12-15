package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Pedido;

public class PedidoDao implements IPedidoDao{
	private EntityManager em;
	private UserTransaction ut;

	public PedidoDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	@Override
	public Pedido createPedido(Pedido pedidoNuevo) throws Exception{
		ut.begin();
		em.persist(pedidoNuevo);
		ut.commit();
		return pedidoNuevo;
	}

	@Override
	public void removePedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(pedido));
		ut.commit();
	}

	@Override
	public Pedido modifyPedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(pedido);
		ut.commit();
		return pedido;
	}
	
	@Override
	public Pedido findById(Long idPedido) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Pedido.class, new Long(idPedido));
	}
}
