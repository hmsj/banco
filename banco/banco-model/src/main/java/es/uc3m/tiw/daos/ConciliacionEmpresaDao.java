package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.ConciliacionEmpresa;
import es.uc3m.tiw.model.Pedido;

public class ConciliacionEmpresaDao implements IConciliacionEmpresaDao{
	private EntityManager em;
	private UserTransaction ut;

	public ConciliacionEmpresaDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	public ConciliacionEmpresaDao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public ConciliacionEmpresa createConciliacionEmpresa(
			ConciliacionEmpresa conciliacionEmpresaNueva) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.persist(conciliacionEmpresaNueva);
		ut.commit();
		return conciliacionEmpresaNueva;
	}

	@Override
	public void removeConciliacionEmpresa(
			ConciliacionEmpresa conciliacionEmpresa) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(conciliacionEmpresa));
		ut.commit();
	}

	@Override
	public ConciliacionEmpresa modifyConciliacionEmpresa(
			ConciliacionEmpresa conciliacionEmpresa) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(conciliacionEmpresa);
		ut.commit();
		return conciliacionEmpresa;
	}

	@Override
	public ConciliacionEmpresa findById(Long idConciliacionEmpresa)
			throws Exception {
		// TODO Auto-generated method stub
		return em.find(ConciliacionEmpresa.class, new Long(idConciliacionEmpresa));
	}
}
