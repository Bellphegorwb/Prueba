package com.st.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.demo.models.dao.IUsuarioDAO;
import com.st.demo.models.entity.Usuario;

@Controller
public class UsuariosController {

	@Autowired
	public IUsuarioDAO usuarioDAO;
	
		//El atributo rango debe decir "Cliente" de forma predeterminada
	
	@RequestMapping("/clientes/registrar")
	public String rcliente(Model model,
	@RequestParam (name="dnix", required=false, defaultValue = "x")String dnix,
	@RequestParam (name="nomx", required=false, defaultValue = "x")String nomx,
	@RequestParam (name="apex", required=false, defaultValue = "x")String apex,
	@RequestParam (name="celx", required=false, defaultValue = "x")String celx,
	@RequestParam (name="corx", required=false, defaultValue = "x")String corx,
	@RequestParam (name="conx", required=false, defaultValue = "x")String conx) {
		boolean cenc=false;
		for(Usuario i:usuarioDAO.getUsuarios()) {
			if(dnix.equals(i.getDni())) cenc=true; 
		}
			if(dnix.equals("x")) {}
			else if(cenc) model.addAttribute("mensaje","Este usuario ya está registrado");
			else {
				usuarioDAO.inUsuario(dnix,nomx,apex,celx,corx,conx,"Cliente");
				return "redirect:/";
			}
		return "RegCli";
	}
	
	@RequestMapping("/usuarios/listar")
	public String usuarios(Model model) {
		model.addAttribute("usuarios",usuarioDAO.getUsuarios());
		return "LisUsu";
	}
	
	@RequestMapping("/usuarios/registrar")
	public String registrar(Model model,
	@RequestParam (name="dnix", required=false, defaultValue = "x")String dnix,
	@RequestParam (name="nomx", required=false, defaultValue = "x")String nomx,
	@RequestParam (name="apex", required=false, defaultValue = "x")String apex,
	@RequestParam (name="celx", required=false, defaultValue = "x")String celx,
	@RequestParam (name="corx", required=false, defaultValue = "x")String corx,
	@RequestParam (name="conx", required=false, defaultValue = "x")String conx,
	@RequestParam (name="ranx", required=false, defaultValue = "x")String ranx) {
		boolean uenc=false;
		for(Usuario i:usuarioDAO.getUsuarios()) {
			if(dnix.equals(i.getDni())) uenc=true; 
		}
			if(dnix.equals("x")) {}
			else if(uenc) model.addAttribute("mensaje","Este usuario ya está registrado");
			else {
				usuarioDAO.inUsuario(dnix,nomx,apex,celx,corx,conx,ranx);
				return "redirect:/usuarios/listar";
			}
		//usuarioDAO.inUsuario("89703327", "Bell", "Phegor", "996945445", "s@hotmail.com", "5040302010", "Administrador");
		return "RegUsu";
	}

	String moddni;
	@RequestMapping("/usuarios/modificar")
	public String modificar(Model model,
			@RequestParam (name="dnix", required=false, defaultValue = "x")String dnix,
			@RequestParam (name="nomx", required=false, defaultValue = "x")String nomx,
			@RequestParam (name="apex", required=false, defaultValue = "x")String apex,
			@RequestParam (name="celx", required=false, defaultValue = "x")String celx,
			@RequestParam (name="corx", required=false, defaultValue = "x")String corx,
			@RequestParam (name="conx", required=false, defaultValue = "x")String conx,
			@RequestParam (name="ranx", required=false, defaultValue = "x")String ranx) {
		Usuario a=new Usuario();
		if(nomx.equals("x")) {
			for (Usuario i:usuarioDAO.getUsuarios()) {
				if(dnix.equals(i.getDni())) { a=i; }
			}
			model.addAttribute("at",a);
			moddni=a.getDni();
			return "ModUsu";
		}
		else {
			usuarioDAO.modUsuario(moddni,nomx,apex,celx,corx,conx,ranx);
			return "redirect:/usuarios/listar";
		}
	}

	String elidni;
	@RequestMapping("/usuarios/eliminar")
	public String eliminar(Model model,
			@RequestParam (name="dnix", required=false, defaultValue = "x")String dnix,
			@RequestParam (name="nomx", required=false, defaultValue = "x")String nomx) {
		
		Usuario a=new Usuario();
		if(nomx.equals("x")) {
			for (Usuario i:usuarioDAO.getUsuarios()) {
				if(dnix.equals(i.getDni())) { a=i; }
			}
			model.addAttribute("at",a);
			elidni=a.getDni();
			return "EliUsu";
		}
		else {
			usuarioDAO.delUsuario(elidni);
			return "redirect:/usuarios/listar";
		}
		
	}
	
}
