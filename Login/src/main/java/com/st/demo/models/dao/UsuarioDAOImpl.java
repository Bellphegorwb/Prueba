package com.st.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.st.demo.models.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements IUsuarioDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Usuario> getUsuarios() {
		return em.createQuery("from Usuario").getResultList();
	}
	
	@Transactional
	@Override
	public void inUsuario(String dni,String nom,String ape, String cel, String cor, String con, String ran) {
		em.createNativeQuery("INSERT INTO usuarios (dni,nombre,apellido,celular,correo,contra,rango,habilitado) VALUES(?,?,?,?,?,?,?,?)")
	      .setParameter(1,dni)
	      .setParameter(2,nom)
	      .setParameter(3,ape)
	      .setParameter(4,cel)
	      .setParameter(5,cor)
	      .setParameter(6,con)
	      .setParameter(7,ran)
	      .setParameter(8,'1')
	      .executeUpdate();
	}
	

	@Transactional
	@Override
	public void modUsuario(String dni, String nom,String ape, String cel, String cor, String con, String ran) {
		em.createNativeQuery("UPDATE usuarios SET nombre= ? , apellido= ? , celular= ? , correo= ? , contra= ? , rango= ? WHERE dni=?")
	      .setParameter(1,nom)
	      .setParameter(2,ape)
	      .setParameter(3,cel)
	      .setParameter(4,cor)
	      .setParameter(5,con)
	      .setParameter(6,ran)
	      .setParameter(7,dni)
	      .executeUpdate();
	}
	

	@Transactional
	@Override
	public void delUsuario(String dni) {
		em.createNativeQuery("UPDATE usuarios SET habilitado='0' WHERE dni=?")
	      .setParameter(1,dni)
	      .executeUpdate();
	}

	
	
}
