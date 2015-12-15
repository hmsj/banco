package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.ConciliacionEmpresa;
import es.uc3m.tiw.model.Pedido;

public interface IConciliacionEmpresaDao {
	ConciliacionEmpresa createConciliacionEmpresa(ConciliacionEmpresa conciliacionEmpresaNueva) throws Exception;

	void removeConciliacionEmpresa(ConciliacionEmpresa conciliacionEmpresa) throws Exception;

	ConciliacionEmpresa modifyConciliacionEmpresa(ConciliacionEmpresa conciliacionEmpresa) throws Exception;

	ConciliacionEmpresa findById(Long idConciliacionEmpresa) throws Exception;
}
