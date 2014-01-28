/**
 * 
 */
package negocio.departamentos.servicioaplicacion.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.departamentos.servicioaplicacion.SADepartamentos;
import negocio.empleados.objetonegocio.Empleado;
import negocio.excepciones.BSoDException;
import negocio.jpa.EntityManagerFactoryS;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SADepartamentosImp implements SADepartamentos {

    public SADepartamentosImp() {
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#anadirDepartamento(Departamento departamentoNuevo)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Departamento anadirDepartamento(Departamento departamentoNuevo)
	    throws BSoDException {
	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS.getEntityManagerFactory();
	
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	Departamento resultado = null;
	departamentoNuevo.setActivo(true);
	//Necesita su propia query porque debe buscar elementos dados de baja tambien
	TypedQuery<Departamento> query = null;
	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Departamento.QUERY_BUSCAR_DEPARTAMENTO_POR_NOMBRE_ALTA, Departamento.class);
	    query.setParameter("nombre", departamentoNuevo.getNombre());
	    resultado = query.getSingleResult();
	    //Si no canta es que existe la tarea
	    if(resultado.getActivo()){
		entityManager.getTransaction().rollback();
		 //Cierre de entidades de persistencia
		 entityManager.close();
		
		 throw new BSoDException("Ya existe el departamento en la base de datos");
	    }
	    else{
		resultado.setActivo(true);
		entityManager.merge(resultado);
		entityManager.getTransaction().commit();
		//Cierre de entidades de persistencia
		entityManager.detach(resultado);
		entityManager.close();
		
		return resultado;
	    }
	} catch (NoResultException ex) {// No se encontro la tarea.
	    entityManager.persist(departamentoNuevo);
	    
	    entityManager.getTransaction().commit();

	    resultado = query.getSingleResult();

	    departamentoNuevo.setID(resultado.getID());
	    //No hace falta el merge, en principio basta con un refresh//
	    entityManager.refresh(departamentoNuevo);
	    entityManager.detach(departamentoNuevo);
	    //Cierre de entidades de persistencia
	    entityManager.close();
	  
	} catch (Exception e) {
	    
	    throw new BSoDException(e.getLocalizedMessage());
	}
	
	return departamentoNuevo;
	
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#borrarDepartamento(Object idDepartamento)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Boolean borrarDepartamento(Departamento departamento) throws BSoDException {
	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	
	Boolean borrado = false;

	try {
	    entityManager.getTransaction().begin();

	    TypedQuery<Empleado> empleadosQuery = entityManager.createNamedQuery(Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DEPARTAMENTO, Empleado.class);
	    empleadosQuery.setParameter("departamento", departamento);
	    
	    List<Empleado> empleados = empleadosQuery.getResultList();
	    
	    if ( !empleados.isEmpty() ) {
		throw new BSoDException("No se puede borrar un departamento con empleados");
	    }
	    
	    TypedQuery<Departamento> query = entityManager.createNamedQuery("negocio.departamentos.objetonegocio.Departamento.findBynombre", Departamento.class);
	    query.setParameter("nombre", departamento.getNombre());

	    Departamento depto = query.getSingleResult();

	    depto.setActivo(false);

	    entityManager.getTransaction().commit();
	    
	    borrado = true;

	} catch (NoResultException nr) {

	    entityManager.getTransaction().rollback();
	   throw new BSoDException(nr.getLocalizedMessage());
	}catch (Exception ex) {
	    entityManager.getTransaction().rollback();
	    if(ex instanceof BSoDException) throw ex;
	    else{
		throw new BSoDException(ex.getLocalizedMessage());
	    }
	} finally {

	    entityManager.close();
	  
	}

	return borrado;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#actualizarDepartamento(Departamento departamento)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Departamento actualizarDepartamento(Departamento departamento)
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	TypedQuery<Departamento> query = null;
	Departamento resultado = null;

	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery("negocio.departamentos.objetonegocio.Departamento.findByid", Departamento.class);
	    query.setParameter("id", departamento.getID());

	    resultado = query.getSingleResult();

	    resultado.setNombre(departamento.getNombre());

	    entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No existe el departamento");

	} catch (Exception ex) {
	    if(ex instanceof BSoDException) throw ex;
	    else{
		 entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
	    }
	} finally {
	    if ( resultado != null )
		entityManager.detach(resultado);
	    entityManager.close();
	  
	}

	return departamento;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#obternerDepartamento(Object idDepartamento)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Departamento obternerDepartamento(String nombreDepartamento)
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory =EntityManagerFactoryS.getEntityManagerFactory();

	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	entityManager.getTransaction().begin();

	Departamento d = null;

	try {

	    TypedQuery<Departamento> query = entityManager.createNamedQuery("negocio.departamentos.objetonegocio.Departamento.findBynombre", Departamento.class);
	    query.setParameter("nombre", nombreDepartamento);
	    
	    d = query.getSingleResult();
	    

	} catch (NoResultException nr) {

	    entityManager.getTransaction().rollback();
	    
	    throw new BSoDException("No existe el departamento");
	}catch (Exception ex) {
	    if(ex instanceof BSoDException) throw ex;
	    else{
		 entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
	    } 
	}finally {
	    if ( d != null) {
		entityManager.detach(d);
	    }
	    entityManager.close();
	    
	}

	return d;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#obtenerTodoslosDepartamentos()
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public List<Departamento> obtenerTodoslosDepartamentos()
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	List<Departamento> departamentos = null;
	
	try {
	    entityManager.getTransaction().begin();
	    departamentos = entityManager.createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
	    //Nada que commitear
//	    entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No se encontraron empleados");
	} catch (Exception ex) {
	    if(ex instanceof BSoDException) throw ex;
	    else{
		 entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
	    }
	} finally {
	    
	    for ( Departamento dpto : departamentos) {
		entityManager.detach(dpto);
	    }

	    entityManager.close();
	    
	}
	
	return departamentos;
    }

}