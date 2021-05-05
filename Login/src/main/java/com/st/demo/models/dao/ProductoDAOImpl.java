package com.st.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.st.demo.models.entity.Producto;

@Repository
public class ProductoDAOImpl implements IProductoDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Producto> getProductos() {
		return em.createQuery("from Producto").getResultList();
	}
	
	@Transactional
	@Override
	public void inProducto(String nom, double pre, int des, String cat) {
		em.createNativeQuery("INSERT INTO productos (id,nombre,precio,descuento,categoria,habilitado) VALUES(?,?,?,?,?,?)")
	      .setParameter(1,null)
	      .setParameter(2,nom)
	      .setParameter(3,pre)
	      .setParameter(4,des)
	      .setParameter(5,cat)
	      .setParameter(6,'1')
	      .executeUpdate();
	}
	

	@Transactional
	@Override
	public void modProducto(String id,String nom, double pre, int des, String cat) {
		em.createNativeQuery("UPDATE productos SET nombre= ? , precio= ? , descuento= ? , categoria= ? WHERE id=?")
	      .setParameter(1,nom)
	      .setParameter(2,pre)
	      .setParameter(3,des)
	      .setParameter(4,cat)
	      .setParameter(5,id)//Posible error Long y String
	      .executeUpdate();
	}
	

	@Transactional
	@Override
	public void delProducto(String id) {
		em.createNativeQuery("UPDATE productos SET habilitado='0' WHERE id=?")
	      .setParameter(1,id)
	      .executeUpdate();
	}

	
	
}
