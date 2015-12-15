package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.ConciliacionProfesor;

public interface IConciliacionProfesorDao {
	ConciliacionProfesor createConciliacionProfesor(ConciliacionProfesor conciliacionProfesorNueva) throws Exception;

	void removeConciliacionProfesor(ConciliacionProfesor conciliacionProfesor) throws Exception;

	ConciliacionProfesor modifyConciliacionProfesor(ConciliacionProfesor conciliacionProfesor) throws Exception;

	ConciliacionProfesor findById(Long idConciliacionProfesor) throws Exception;
}
