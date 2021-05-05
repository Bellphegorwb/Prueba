package com.st.demo.models.dao;

import java.util.List;


import com.st.demo.models.entity.Usuario;


public interface IUsuarioDAO {
	public List<Usuario> getUsuarios();
	public void inUsuario(String dni,String nom,String ape, String cel, String cor, String con, String ran);
	public void modUsuario(String dni,String nom,String ape, String cel, String cor, String con, String ran);
	public void delUsuario(String dni);
}
