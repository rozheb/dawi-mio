package org.ciberfarma.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ciberfarma.modelo.Usuario;



public class JPATest01 {

	public static void main(String[] args) {
		
		// Crear un objeto de Usuario a grabar
		Usuario u = new Usuario();
		//u.setCodigo(10); // cuando es auto incrementado se obmite la creacion 
		u.setNombre("Sebastian");
		u.setApellido("Aldaba");
		u.setUsuario("usuario5@ciber.com");
		u.setClave("123");
		u.setFnacim("2000/03/01");
		u.setTipo(1);
		u.setEstado(1);
		
		// grabar el objeto
		// 1. fabricar el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// 3. empezar mi transacci�n
		em.getTransaction().begin();
		// proceso a realizar (persistencia)
		em.persist(u); // es para crear los datos 
		//em.merge(u); // esto es para actualizar datos 
		// 4. confirmar la transacci�n
		em.getTransaction().commit();
		System.out.println("REGISTRO AGREGADO");
		em.close();
	}

}
