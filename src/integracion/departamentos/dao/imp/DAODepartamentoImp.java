package integracion.departamentos.dao.imp;

import integracion.departamentos.dao.DAODepartamento;

import javax.persistence.EntityManager;

import negocio.departamentos.objetonegocio.Departamento;

public class DAODepartamentoImp implements DAODepartamento {

	public void addDepartamento(Departamento departamentoNuevo, EntityManager entityManager) {
		
		entityManager.persist(departamentoNuevo);
	}
}
