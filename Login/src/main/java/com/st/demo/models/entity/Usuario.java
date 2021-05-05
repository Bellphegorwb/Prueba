package com.st.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	@Id
	private String dni;
	private String nombre;
	private String apellido;
	private String celular;
	private String correo;
	private String contra;
	private String rango;
	private String habilitado;
	
	
	public String getHabilitado() {
		return habilitado;
	}


	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}


	public String getRango() {
		return rango;
	}


	public void setRango(String rango) {
		this.rango = rango;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContra() {
		return contra;
	}


	public void setContra(String contra) {
		this.contra = contra;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
