package com.st.demo.models.dao;

import java.util.List;

import com.st.demo.models.entity.Producto;


public interface IProductoDAO {
	public List<Producto> getProductos();
	public void inProducto(String nom, double pre, int des, String cat);
	public void modProducto(String id,String nom, double pre, int des, String cat);
	public void delProducto(String id);
}
