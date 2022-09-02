package com.bolsadeideas.springboot.di.app.models.service;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

//@Service
//@Primary 		//Le indica a la interface de servicio cual es el servicio por defecto o el principal
//@Component("miServicioSimple")
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		return "Ejecutando un proceso importante Simple...";
	}

}