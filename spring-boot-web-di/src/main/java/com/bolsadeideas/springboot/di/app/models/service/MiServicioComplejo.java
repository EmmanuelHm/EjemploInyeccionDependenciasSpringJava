package com.bolsadeideas.springboot.di.app.models.service;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;

//@Component("miServicioComplejo")
//@Primary 		//Le indica a la interface de servicio cual es el servicio por defecto o el principal
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "Ejecutando un proceso importante Complicado...";
	}

}