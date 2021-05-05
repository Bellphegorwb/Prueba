package com.st.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.demo.models.dao.IUsuarioDAO;
import com.st.demo.models.entity.Usuario;

@Controller
public class LoginController {

	@Autowired
	public IUsuarioDAO usuarioDAO;
	
	String ldni;
	String lnom;
	boolean enc=false;
	@RequestMapping("/")
	public String login(Model model,
			@RequestParam (name="usuarix", required=false, defaultValue = "x")String usuarix,
			@RequestParam (name="contrax", required=false, defaultValue = "x")String contrax) {
		lnom=null;
		ldni=null;
		for(Usuario i:usuarioDAO.getUsuarios()) {
		if(usuarix.equals(i.getDni())&&contrax.equals(i.getContra())){
			if(i.getRango().equals("Administrador")) {
				ldni=i.getDni();
				lnom=i.getNombre();
				return "redirect:/menu";//esta linea cambiaria en caso de menu cliente, vendedor o marketer
			}
		}
		}
		if(!usuarix.equals("x"))model.addAttribute("mensaje","Su usuario y/o contraseña son incorrectos");
		return "index";
	}

	@RequestMapping("/menu")
	public String menuadmin(Model model) {
		if(lnom==null) return "redirect:/";//esta linea impide que entren al menu por el link sin iniciar sesion
		model.addAttribute("lnom",lnom);
		return "MenAdm";
	}
	
}
