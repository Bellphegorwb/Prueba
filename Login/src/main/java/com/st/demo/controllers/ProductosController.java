package com.st.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.demo.models.dao.IProductoDAO;
import com.st.demo.models.entity.Producto;
import com.st.demo.models.entity.Usuario;

@Controller
public class ProductosController {

	@Autowired
	public IProductoDAO productoDAO;
	
	
	@RequestMapping("/productos/listar")
	public String productos(Model model) {
		model.addAttribute("productos",productoDAO.getProductos());
		return "LisPro";
	}

	@RequestMapping("/productos/registrar")
	public String pregistrar(
			@RequestParam(name="nomx", required = false, defaultValue = "x")String nomx,
			@RequestParam(name="prex", required = false, defaultValue = "x")String prex,
			@RequestParam(name="desx", required = false, defaultValue = "x")String desx,
			@RequestParam(name="catx", required = false, defaultValue = "x")String catx) {

		if(nomx.equals("x")) {}
		else {
			double prey=Double.parseDouble(prex);
			int desy=Integer.parseInt(desx);
			productoDAO.inProducto(nomx, prey, desy, catx);
			return "redirect:/productos/listar";
		}
		return "RegPro";
	}
	
	String modid;
	@RequestMapping("/productos/modificar")
	public String pmodificar(Model model,
			@RequestParam(name="idx", required = false, defaultValue = "x")String idx,
			@RequestParam(name="nomx", required = false, defaultValue = "x")String nomx,
			@RequestParam(name="prex", required = false, defaultValue = "x")String prex,
			@RequestParam(name="desx", required = false, defaultValue = "x")String desx,
			@RequestParam(name="catx", required = false, defaultValue = "x")String catx) {
		Producto a=new Producto();
		if(nomx.equals("x")) {
			for (Producto i:productoDAO.getProductos()) {
				if(idx.equals(String.valueOf(i.getId()))) a=i;
			}
			model.addAttribute("at",a);
			modid=idx;
			return "ModPro";
		}
		else {
			double prey=Double.parseDouble(prex);
			int desy=Integer.parseInt(desx);
			productoDAO.modProducto(modid, nomx, prey, desy, catx);
			return "redirect:/productos/listar";
		}
		
	}
	
	String eliid;
	@RequestMapping("/productos/eliminar")
	public String peliminar(Model model,
			@RequestParam(name="idx", required = false, defaultValue = "x")String idx,
			@RequestParam(name="nomx", required = false, defaultValue = "x")String nomx) {
		Producto a=new Producto();
		if(nomx.equals("x")) {
			for (Producto i:productoDAO.getProductos()) {
				if(idx.equals(String.valueOf(i.getId()))) a=i;
			}
			model.addAttribute("at",a);
			eliid=idx;
			return "EliPro";
		}
		else {
			productoDAO.delProducto(eliid);
			return "redirect:/productos/listar";
		}
		
	}
}
