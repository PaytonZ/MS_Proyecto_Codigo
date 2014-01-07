package integracion.departamentos.dao.imp;

import javax.persistence.EntityManager;

import negocio.departamentos.objetonegocio.Departamento;
import integracion.departamentos.dao.DAODepartamento;

public class DAODepartamentoImp implements DAODepartamento {

	public void addDepartamento(Departamento departamentoNuevo, EntityManager entityManager) {
		
		entityManager.persist(departamentoNuevo);
	}
}
