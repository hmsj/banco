package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.ConciliacionProfesor;

public class ConciliacionProfesorDao implements IConciliacionProfesorDao{
	private EntityManager em;
	private UserTransaction ut;

	public ConciliacionProfesorDao(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public ConciliacionProfesor createConciliacionProfesor(
			ConciliacionProfesor conciliacionProfesorNueva) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.persist(conciliacionProfesorNueva);
		ut.commit();
		return conciliacionProfesorNueva;
	}

	@Override
	public void removeConciliacionProfesor(
			ConciliacionProfesor conciliacionProfesor) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(conciliacionProfesor));
		ut.commit();
	}

	@Override
	public ConciliacionProfesor modifyConciliacionProfesor(
			ConciliacionProfesor conciliacionProfesor) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(conciliacionProfesor);
		ut.commit();
		return conciliacionProfesor;
	}

	@Override
	public ConciliacionProfesor findById(Long idConciliacionProfesor)
			throws Exception {
		// TODO Auto-generated method stub
		return em.find(ConciliacionProfesor.class, new Long(idConciliacionProfesor));
	}
}
