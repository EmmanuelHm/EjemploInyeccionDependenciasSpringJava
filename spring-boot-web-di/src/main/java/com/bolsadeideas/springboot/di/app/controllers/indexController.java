package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class indexController {
	
	//Instanciar MiServicio
	//private MiServicio servicio = new MiServicio();
	
	/*Asi queda despues de añadir @Component/@Service por que esta por Inyeccion de Dependencias */
	@Autowired
	@Qualifier("miServicioComplejo") //Solo si queremos que los servicios vengan de 'ServicioComplejo'
	private IServicio servicio;
	
	/*Si se inyecta un servicio a un costructor es opcional colocar el @Autowired*/
	/*@Autowired
	public indexController(IServicio servicio) {
		this.servicio = servicio;
	}*/

	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		
		model.addAttribute("objeto", servicio.operacion());
		
		return "index";
	}

	/*@Autowired
	public void setServicio(IServicio servicio) {
		this.servicio = servicio;
	}*/
	
	

}
