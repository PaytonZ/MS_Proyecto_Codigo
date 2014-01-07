package integracion.departamentos.dao;

import javax.persistence.EntityManager;

import negocio.departamentos.objetonegocio.Departamento;

public interface DAODepartamento {

	public void addDepartamento(Departamento departamentoNuevo, EntityManager entityManager);
}
